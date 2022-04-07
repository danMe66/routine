package com.freedougall.demo.example.graborders;

import com.freedougall.demo.common.untils.RedisUntil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * redis分布式锁-模拟抢单
 * https://www.cnblogs.com/wangrudong003/p/10627539.html
 * <p>
 * 问题？：抢单不是可以多个用户同时抢的吗，这样的话只能一个一个的去抢，感觉这样设计有问题，可以用Redis DECR 原子性来操作
 *
 * @author liudandan
 */
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedisUntil redisUntil;

    //总库存
    private long nKuCuen = 0;
    /**
     * 商品key名字
     */
    private String shangpingKey = "computer_key";
    //获取锁的超时时间 秒
    private int timeout = 30 * 1000;

    @GetMapping("/qiangdan")
    public List<String> qiangdan() {

        //抢到商品的用户
        List<String> shopUsers = new ArrayList<>();

        //构造很多用户
        List<String> users = new ArrayList<>();
        IntStream.range(0, 100000).parallel().forEach(b -> {
            users.add("神牛-" + b);
        });

        //初始化库存
        nKuCuen = 10;

        //模拟开抢
        //并行流模拟多用户抢购
        users.parallelStream().forEach(b -> {
            String shopUser = qiang(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });

        return shopUsers;
    }

    /**
     * 模拟抢单动作(10w个人开抢)
     *
     * @param b
     * @return
     */
    private String qiang(String b) {
        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，30秒内继续获取锁
        //判断未抢成功的用户，timeout秒内继续获取锁
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            //商品是否剩余
            if (nKuCuen <= 0) {
                break;
            }
            /**
             * 1：redis的普通key一般都允许覆盖，A用户set某个key后，B在set相同的key时同样能成功，
             * 如果是锁场景，那就无法知道到底是哪个用户set成功的；这里的setNx方式为我们解决了这个问题，
             * 简单原理是：当A用户先set成功了，那B用户set的时候就返回失败，满足了某个时间点只允许一个用户拿到锁。
             * 2：锁过期时间：某个抢购场景时候，如果没有过期的概念，当A用户生成了锁，但是后面的流程被阻塞了一直无法释放锁，
             * 那其他用户此时获取锁就会一直失败，无法完成抢购的活动；当然正常情况一般都不会阻塞，
             * A用户流程会正常释放锁；过期时间只是为了更有保障。
             */
            if (redisUntil.setNx(shangpingKey, b, 10)) {
                //用户b拿到锁
                log.info("用户{}拿到锁...", b);
                try {
                    //商品是否剩余
                    if (nKuCuen <= 0) {
                        break;
                    }

                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //抢购成功，商品递减，记录用户
                    nKuCuen -= 1;

                    //抢单成功跳出
                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, nKuCuen);

                    return b + "抢单成功，所剩库存：" + nKuCuen;
                } finally {
                    log.info("用户{}释放锁...", b);
                    //释放锁
                    //获取锁后并下单成功，最后释放锁
                    redisUntil.delNx(shangpingKey);
                }
            } else {
                /**
                 * 上面是创建锁，同样的具有有效时间，但是我们不能完全依赖这个有效时间，
                 * 场景如：有效时间设置1分钟，本身用户A获取锁后，没遇到什么特殊情况正常生成了抢购订单后，此时其他用户应该能正常下单了才对，
                 * 但是由于有个1分钟后锁才能自动释放，那其他用户在这1分钟无法正常下单（因为锁还是A用户的），因此我们需要A用户操作完后，主动去解锁：
                 */
                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
                if (b.equals("神牛-50") || b.equals("神牛-69")) {
                    log.info("用户{}等待获取锁...", b);
                }
            }
        }
        return "";
    }
}

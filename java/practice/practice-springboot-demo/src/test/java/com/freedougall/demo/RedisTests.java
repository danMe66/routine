package com.freedougall.demo;

import com.freedougall.demo.common.untils.RedisUntil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class RedisTests {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedisUntil redisUntil;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("myKey", "myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void contextLock() throws Exception {
        String key = "1-1-1";
        //创建锁
        boolean isLock = redisUntil.setNx(key, 1, 10);

        while (true) {
            if (redisUntil.hasKey(key)) {
                log.error("已锁定！无法抢购");
            } else {
                log.info("订单已释放！");
                throw new Exception("订单已释放");
            }
        }
    }

}

package com.freedougall.demo;

import com.freedougall.demo.aggregate.ListAggregateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootPracticeApplication.class)
public class ListAggregateTest {

    @Resource
    ListAggregateService listAggregateService;

    /**
     * ArrayList 和 LinkedList的性能对比
     * https://mp.weixin.qq.com/s/eiQj3GLN84knfpyNt8cFVA
     */
    @Test
    public void listContrast() {
        ArrayList<Integer> integerArrayList = listAggregateService.addArrayList();
        log.info(String.valueOf(integerArrayList));
    }

    /**
     * list分组
     */
    @Test
    public void listGroup() {
    }
}

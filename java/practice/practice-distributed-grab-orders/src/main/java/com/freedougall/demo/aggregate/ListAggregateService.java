package com.freedougall.demo.aggregate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * list集合处理
 *
 * @author freedougall
 */
@Component
public class ListAggregateService {

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private long startTime;

    ListAggregateService() {
        this.arrayList = new ArrayList<Integer>();
        this.linkedList = new LinkedList<Integer>();
        this.startTime = System.nanoTime();
    }

    public ArrayList<Integer> addArrayList() {
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long duration = System.nanoTime() - startTime;
        System.out.println("ArrayList add:  " + duration);
        return arrayList;
    }

    public LinkedList<Integer> addLinkedList() {
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("LinkedList add: " + duration);
        return linkedList;
    }

    public void getArrayList() {
        long startTime = System.nanoTime();

        for (
                int i = 0;
                i < 10000; i++) {
            arrayList.get(i);
        }


        long duration = System.nanoTime() - startTime;
        System.out.println("ArrayList get:  " + duration);
    }

    public void getLinkedList() {
        startTime = System.nanoTime();

        for (
                int i = 0;
                i < 10000; i++) {
            linkedList.get(i);
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("LinkedList get: " + duration);
    }

    public void removeArrayList() {
        startTime = System.nanoTime();

        for (
                int i = 9999;
                i >= 0; i--) {
            arrayList.remove(i);
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("ArrayList remove:  " + duration);
    }

    public void removeLinkedList() {
        startTime = System.nanoTime();

        for (
                int i = 9999;
                i >= 0; i--) {
            linkedList.remove(i);
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("LinkedList remove: " + duration);
    }
}

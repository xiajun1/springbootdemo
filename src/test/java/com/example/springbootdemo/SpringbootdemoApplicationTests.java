package com.example.springbootdemo;

import com.example.springbootdemo.util.ThreadPool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Test
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

//        Iterator<Map.Entry<String,Object>> it = map.entrySet().iterator();
//        while (it.hasNext()){
////            System.out.println(it.next().getKey());
//            System.out.println(it.next().getValue());
//        }
//        Iterator<String> it1 = map.keySet().iterator();
//        while ((it1.hasNext())){
////            System.out.println(it1.next());
//            System.out.println(map.get(it1.next()));
//        }
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
////            System.out.println(entry.getKey());
//            System.out.println(map.get(entry.getKey()));
//            System.out.println(entry.getValue());
//        }
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));

        }

    }

    /**
     * 加一线程与减一线程共同操作一个数
     * 两个问题：
     * 1、线程同步--synchronized
     * 2、线程之间如何共享同一个j变量--内部类
     *
     * @author liuwei
     */
    int j = 1;

    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    class T1 implements Runnable {
        public void run() {
            inc();
        }
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class T11 implements Runnable {
        public void run() {
            dec();
        }
    }

   /* public static void main(String[] args) {
        SpringbootdemoApplicationTests t = new SpringbootdemoApplicationTests();
        T1 t1 = t.new T1();
        T11 t11 = t.new T11();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(t1);
            thread.start();

            Thread thread1 = new Thread(t11);
            thread1.start();
        }

    }*/
    @Test
    public void strsub(){
        String str = "7i8hy4jjnb2";
        char[] ch = str.toCharArray();
        int bytes = ch.length;
        for(int i =0;i<bytes;i++){
            if(Character.isDigit(ch[i])){
                System.out.println(ch[i]);
            }
        }

    }

//    public static void main(String[] args) {
//        // 创建3个线程的线程池
//        ThreadPool t = ThreadPool.getThreadPool(3);
//        t.execute(new Runnable[] { new Task()});
////        t.execute(new Runnable[] { new Task(), new Task(), new Task() });
//        System.out.println(t);
//        // 所有线程都执行完成才destory
//        t.destroy();
//        System.out.println(t);
//    }

    // 任务类
    static class Task implements Runnable {
        private static volatile int i = 1;

        @Override
        // 执行任务
        public void run() {
            System.out.println("任务 " + (i++) + " 完成");
        }
    }

//    public static void main(String[] args) { // Line 1
//        int i=1; // Line 2
//        Object obj = new Object(); // Line 3
//        SpringbootdemoApplicationTests mem = new SpringbootdemoApplicationTests(); // Line 4
//        mem.foo(obj); // Line 5
//    } // Line 9

    private void foo(Object param) { // Line 6
        String str = param.toString(); //// Line 7
        System.out.println(str);
    }// Line8

    public static void main(String[] args) {
    //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
    //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }






}

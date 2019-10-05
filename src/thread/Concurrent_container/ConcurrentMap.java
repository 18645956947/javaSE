package thread.Concurrent_container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentMap {

    public static void main(String[] args) {
        //Map<String, String> map = new ConcurrentHashMap<>();//70
        //Map<String, String> map = new ConcurrentSkipListMap<>();//200
        //Map<String, String> map = new Hashtable<>();//48
        Map<String, String> map = new HashMap<>();//66

        List<String> list = new ArrayList<>();
        Random random = new Random();
        Thread[] threads= new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + random.nextInt(10000), "a" + random.nextInt(10000));
                    latch.countDown();
                }
            });
        }
        Arrays.asList(threads).forEach(t -> t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.printf("花费时间是:"+(end - start));

    }
}

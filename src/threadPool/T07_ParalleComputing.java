package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T07_ParalleComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> res = getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println("单线程时间花费："+(end - start));


        final int coreCpuNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(coreCpuNum);
        MyTask myTask1 = new MyTask(1, 80000);
        MyTask myTask2 = new MyTask(80001, 130000);
        MyTask myTask3 = new MyTask(130001, 170000);
        MyTask myTask4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(myTask1);
        Future<List<Integer>> f2 = service.submit(myTask2);
        Future<List<Integer>> f3 = service.submit(myTask3);
        Future<List<Integer>> f4 = service.submit(myTask4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println("多线程的执行时间是："+(end - start));
    }

    static class MyTask implements Callable<List<Integer>> {

        int startPos , endPos;
        public MyTask(int startPos, int endPos){
            this.startPos = startPos;
            this.endPos = endPos;
        }


        @Override
        public List<Integer> call() throws Exception {
            List<Integer> list = getPrime(startPos, endPos);
            return list;
        }


    }
    static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end){
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
}

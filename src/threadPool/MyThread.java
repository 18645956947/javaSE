package threadPool;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread{

    private int age;

    public MyThread(int a){
        age = a;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread(24);
        MyThread.MyCallable myCallable = myThread.new MyCallable();
        FutureTask<Integer> ft = new FutureTask(myCallable);
        new Thread(ft).start();
        System.out.println(ft.isDone());
        System.out.println(ft.get());
        /*for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(24)).start();
        }*/
    }



    private class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在计算。。。");
            int sum = 0;
            /*for (int i = 0; i < 100; i++) {
                sum += i;
            }*/
            System.out.println(sum);
            System.out.println(new Integer(sum));
            return new Integer(sum);
        }
    }

}

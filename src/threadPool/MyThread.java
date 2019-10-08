package threadPool;



import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //下面是使用Callable() 接口实现多线程的过程

        for (int i = 0; i < 5; i++) {

            //1.首先创建Callable 接口的实现类的实例
            MyCallable myCallable = new MyCallable();
            //因为Callable 会自带返回值 所以Callable 一般用FutureTask存储，把刚才的Callable实例放入进行包装
            FutureTask<Integer> ft = new FutureTask(myCallable);
            //把FutureTask的实例放入Thread中执行其start方法 即可让线程进入就绪状态，进而等待CPU调度执行
            new Thread(ft).start();
            System.out.println(ft);
            //查看执行的任务是否完毕
            System.out.println(ft.isDone());
            //取得返回值是用get() 注意：该方法是会产生阻塞
            System.out.println(ft.get());
        }

        //下面是使用Runnable接口实现多线程
        //下面两步都是为了创建 Runnable 的实例，因为我采用的是静态内部类的方法
        MyThread.MyRunnable myRunnable= new MyRunnable();
        //下面的也可以
        MyRunnable myRunnable1 = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            new Thread(myRunnable1).start();
        }

    }


    static private class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在计算。。。");
            System.out.println(Thread.currentThread().getName());
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            System.out.println(sum);
            //自动装箱机制 以下都可以
            System.out.println(new Integer(sum));
            return new Integer(sum);
            //return new sum;
        }
    }

    static private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }


}

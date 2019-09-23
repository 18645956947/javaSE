package thread.threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        //提交可分解的PrintTask
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}

package threadPool;

import java.util.concurrent.*;

public class T06_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });//相当于new callable(){Integer call()}

        new Thread(task).start();

        System.out.println(task.get());//阻塞

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future f = service.submit(() ->{
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
//        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}

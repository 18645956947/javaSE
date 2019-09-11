package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种创建线程的方式可以接受有返回值的情况
 */
public class ThirdThread {
    public static void main(String[] args) {
        ThirdThread rt = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " "+i);
            }
            return i;

        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i == 20){
                new Thread(task, "有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值"+" "+task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        /*String[] atp = new String[]{"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players = new ArrayList();
        players = Arrays.asList(atp);
        for (String  s:players) {
            System.out.println(s);
        }
        System.out.println("_--------------------------------");
        players.forEach((player) -> System.out.println(player));
    }*/
}

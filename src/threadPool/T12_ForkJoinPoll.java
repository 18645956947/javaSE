package threadPool;


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class T12_ForkJoinPoll {

    static int[] nums = new int[100000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }


    /*static class AddTask extends RecursiveAction {

        int start, end;
        public AddTask(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        protected void compute() {
            if(end - start <= MAX_NUM){
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
            }else{
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }*/

    static class AddTask extends RecursiveTask<Long>{

        int start, end;
        public AddTask(int s, int e){
            start = s;
            end = e;
        }

        @Override
        protected Long compute() {
            if(end - start <= MAX_NUM){
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            }else{
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();

                return subTask1.join() + subTask2.join();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        fjp.execute(task);

        long res = task.join();
        //System.in.read();
    }


}

package thread.threadPool;

import java.util.PriorityQueue;
import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction {

    private static final int THRESHOLD = 50;
    private int start;
    private int end;
    public PrintTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        //计算当差值小于50的时候开始打印
        if(end - start < THRESHOLD){
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName()+"的i值是："+i);
            }
        }else{
            //计算当差值大于50的时候开始打印
            //将两个大任务分解成两个小任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            //开始并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}

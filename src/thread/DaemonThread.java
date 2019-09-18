package thread;

/**
 * 测试后台线程
 * @author zhx
 */
public class DaemonThread extends Thread{

    public DaemonThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread("新线程");
        t.setDaemon(true);//若设置上后台线程 则当主线程运行结束后，该新线程不管运没运行完都直接结束，
                          //  因为最后如果只剩后台线程 是没啥用的
        t.start();
        //如果沉睡一段时间就不会这样了
        /*try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int i  = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

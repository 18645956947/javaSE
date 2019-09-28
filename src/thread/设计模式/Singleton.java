package thread.设计模式;

/**
 * 线程安全的单例模式
 * 既不用加锁  实现了懒加载的方式
 * @author zhx
 */
public class Singleton {// ---外部类
    class AAA{ // ----内部类
        //...
    }


    private Singleton(){

        System.out.println("Singleton");
    }
    private static class Inner{
        private static Singleton s = new Singleton();
    }
    public static Singleton getInstance(){
        return Inner.s;
    }

    public static void main(String[] args) {

    }
}

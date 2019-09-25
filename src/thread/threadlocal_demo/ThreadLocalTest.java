package thread.threadlocal_demo;

class Account {
    //定义一个ThreadLocal 类型的变量 该变量将是一个线程局部变量 每一个线程都将拥有该变量一个副本
    private ThreadLocal<String> name = new ThreadLocal<>();
    public Account(String str){
        this.name.set(str);
        System.out.println("---"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
class MyTest extends Thread{
    //定义一个Accoun类型的变量
    private Account account;
    public MyTest(Account account, String name){
        super(name);
        this.account = account;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            if(i == 6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户的i值"+i);
        }
    }
}
public class ThreadLocalTest{
    public static void main(String[] args) {
        Account at = new Account("初始化");
        new MyTest(at, "线程甲").start();
        new MyTest(at, "线程乙").start();
    }
}
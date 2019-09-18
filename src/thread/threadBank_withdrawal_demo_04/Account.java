package thread.threadBank_withdrawal_demo_04;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟存现取钱的操作
 */
public class Account {

    //封装 账户编号 账户余额
    private String accountNo;
    private double balance;
    //标记账户中是否已有存款的标志
    private boolean flag = false;

    public Account(){}
    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //取钱
    public synchronized void draw(double drawAmount){
        try {
            //如果flag为假那么表示账户中还没有人存钱进去，取钱方法阻塞
            if(!flag){
                wait();
            }else {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                    /*try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //修改余额
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                //将标志账户是否已有存款的标志设置为false
                flag = false;
                notifyAll();
                }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //存钱方法
    public synchronized void deposit(double depositAmount){
        try{
            //如果flag 为真那么表明账户中已经有人存钱进去 存钱方法阻塞
            if(flag){
                wait();
            }else {
                //执行存钱操作
                System.out.println(Thread.currentThread().getName()+"存钱"+depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为："+balance);
                flag = true;
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode(){
        return accountNo.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj != null && obj.getClass() == Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }


    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

}

package thread.threadBank_withdrawal_demo_06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    //封装 账户编号 账户余额
    private String accountNo;
    private double balance;
    //账户是否有钱的标志
    boolean flag = false;

    public Account(){}
    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void draw(double drawAmount){
        lock.lock();
        try {
            if(!flag){
                cond.await();
            }else{
                //取钱数小于账户余额
                if (balance >= drawAmount) {
                    System.out.println(Thread.currentThread().getName() + "取钱成功" + drawAmount);
                    /*try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //修改余额
                    balance -= drawAmount;

                    flag = false;
                    System.out.println("余额为：" + balance);
                    cond.signalAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + "余额不足 取钱失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
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
        if(obj != null && obj.getClass() == thread.threadBank_withdrawal_demo_03.Account.class){
            thread.threadBank_withdrawal_demo_03.Account target = (thread.threadBank_withdrawal_demo_03.Account)obj;
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

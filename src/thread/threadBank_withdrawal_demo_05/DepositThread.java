package thread.threadBank_withdrawal_demo_05;


/**
 * 存钱
 */
public class DepositThread extends Thread{
    //模拟用户账户
    private Account account;
    //当前存款线程希望存的钱数
    private double depositAmount;
    public DepositThread(){}
    public DepositThread(String name, Account account, double depositAmount){
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }

}

package thread.threadBank_withdrawal_demo_05;

/**
 * 取钱人
 */
public class DrawThread extends Thread{

    //模拟用户账户
    private Account account;
    //当前取钱线程希望取的钱数
    private double drawAmount;
    public DrawThread(){}
    public DrawThread(String name, Account account, double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;

    }
    //当多个线程修改同意数据会出现数据安全问题
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}

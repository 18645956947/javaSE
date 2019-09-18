package threadBank_withdrawal_demo_01;

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
        synchronized (account) {
            //取钱数小于账户余额
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "取钱成功" + drawAmount);
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                //修改余额
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "余额不足 取钱失败");
            }
        }
    }
}

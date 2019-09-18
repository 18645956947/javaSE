package thread.threadBank_withdrawal_demo_04;


public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("123456", 0);
        new DrawThread("取钱者", acct, 800).start();
        new DepositThread("存钱者甲", acct, 800).start();
        new DepositThread("存钱者乙", acct, 800).start();
        new DepositThread("存钱者丙", acct, 800).start();
    }
}

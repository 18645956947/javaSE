package thread.thread.threadBank_withdrawal_demo_03;

public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("123456", 1000);
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
    }
}

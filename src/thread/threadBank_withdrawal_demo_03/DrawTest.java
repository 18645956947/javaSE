package thread.threadBank_withdrawal_demo_03;

import thread.thread.threadBank_withdrawal_demo_03.Account;
import thread.thread.threadBank_withdrawal_demo_03.DrawThread;

public class DrawTest {
    public static void main(String[] args) {
        thread.thread.threadBank_withdrawal_demo_03.Account acct = new Account("123456", 1000);
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
    }
}

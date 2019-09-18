package thread.threadBank_withdrawal_demo_02;

public class Account {
    //封装 账户编号 账户余额
    private String accountNo;
    private double balance;
    public Account(){}
    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount){
        //取钱数小于账户余额
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName()+ "取钱成功" + drawAmount);
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            //修改余额
            balance -= drawAmount;
            System.out.println("余额为：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "余额不足 取钱失败");
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

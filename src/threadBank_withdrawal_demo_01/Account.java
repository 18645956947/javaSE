package threadBank_withdrawal_demo_01;

public class Account {
    //封装 账户编号 账户余额
    private String accountNo;
    private double balance;
    public Account(){}
    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

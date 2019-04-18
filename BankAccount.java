
public class BankAccount {
    double balance;
    int accountNumber;
    String accountHolder;
    String kind;
    
    BankAccount(double balance, int accountNumber, String accountHolder, String kind){
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.kind = kind;
    }
    
    //get
    double getBalance(){
        return balance;
    }
    
    int getAccountNumber(){
        return accountNumber;
    }
    
    String getAccountHolder(){
        return accountHolder;
    }
    
    String getKind(){
        return kind;
    }
    
    //set
    void setBalance(double balance){
        this.balance = balance;
    }
    
    void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    
    void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    
    void setKind(String kind){
        this.kind = kind;
    }
    
    
    void deposit(double amount){
        balance += amount;
    }
    
    boolean isOverdrawn(){
        return balance < 0;
    }
    
}
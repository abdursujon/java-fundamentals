package custom_checked_exception;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public String withdrawMoney(double requestedAmount) throws InsufficientBalanceException{
        if(requestedAmount > balance){
            double shortFall = requestedAmount - balance;
            throw new InsufficientBalanceException("You are " + shortFall + " short. Please add more balance or try smaller balance", shortFall);
        }
        balance -= requestedAmount;
        return "You withdrew: " + requestedAmount + "£. Balance after withdrawal: " + balance;
    }

    public static void main(String[] args) throws InsufficientBalanceException {
        BankAccount ba = new BankAccount(600.8);
        System.out.println(ba.withdrawMoney(80));
        ba.withdrawMoney(8000);
    }
}

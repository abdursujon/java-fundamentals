package custom_unchecked_exceptions;

import custom_checked_exception.InsufficientBalanceException;

public class SavingAccount {
    private double balance;
    private boolean isClosed;

    public SavingAccount(double balance, boolean isClosed){
        this.balance = balance;
        this.isClosed = isClosed;
    }


    /**
     * Here we through both runtime and compile time exceptions.
     * InvalidAccountStateException extends RuntimeException and only checked in JVM level.
     * InsufficientBalanceException extends Exception and is a checked exception which is checked in javac (compiler)
     * @param amount
     * @return string
     * @throws InvalidAccountStateException
     * @throws InsufficientBalanceException
     */
    public String withdrawMoney(int amount) throws InvalidAccountStateException, InsufficientBalanceException {
        if(isClosed){
            throw new InvalidAccountStateException("Account is closed");
        }
        if(amount > balance){
            double shortfall = amount - balance;
            throw new InsufficientBalanceException("You are short of balance of : " + shortfall, balance);
        }
        balance -= amount;
        return "Withdrew: " + amount + "£, Balance after transaction: " + balance;
    }

    public static void main(String[] args) throws InsufficientBalanceException {
        SavingAccount sv = new SavingAccount(66, false);
        System.out.println(sv.withdrawMoney(66));
        // System.out.println(sv.withdrawMoney(6666)); // InsufficientBalanceException: You are short of balance of : 6666.0

        SavingAccount svClosed = new SavingAccount(66, true);
        System.out.println(svClosed .withdrawMoney(66)); // InvalidAccountStateException: Account is closed
    }
}

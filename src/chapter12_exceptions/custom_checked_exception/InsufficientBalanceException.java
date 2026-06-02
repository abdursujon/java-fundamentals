package custom_checked_exception;

public class InsufficientBalanceException extends Exception {
    private final double shortfallAmount;

    public InsufficientBalanceException(String message, double shortfallAmount){
        super(message);
        this.shortfallAmount = shortfallAmount;
    }

    public double getShortfallAmount(){
        return shortfallAmount;
    }
}

public class ThrowVsThrows {
    /**
     * 'throws' = declaration. Tells callers: "I might throw this checked exception."
     *  Compiler forces the caller to handle or re-declare it.
     */
    static String withdrawMoney(int amount) throws Exception{
        int balance = 4000;
        if(amount > balance){
            throw new Exception("Balance is too low, try smaller amount.");
        }
        balance = balance - amount;
        return "Withdrew amount " + amount + ",  Balance after withdraw: " + balance;
    }

    // Unchecked exception (RuntimeException) — no 'throws' clause needed
    static void validateAge(double age){
        if(age <= 0){
            throw new IllegalArgumentException("Age must be >= 0");
        }
        System.out.println("You are age enough to create an account");
    }

    public static void main(String[] args){
        try{
            withdrawMoney(3000);
            System.out.println(withdrawMoney(3000));
        } catch(Exception e){
            System.out.println(e);
        }
        validateAge(5.5);
    }
}

package FinalExample;

public class TransactionalValidator {
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 100_000;

    public static boolean isValidAmount(int transferAmount) {
        if (transferAmount < MIN_AMOUNT) {
            IO.println("Минимальная сумма перевода: " + MIN_AMOUNT + " тг. Попробуйте ещё раз!");
            return false;
        } else if (transferAmount > MAX_AMOUNT) {
            IO.println("Максимальная сумма перевода: " + MAX_AMOUNT + " тг. Попробуйте ещё раз!");
            return false;
        } else {
            return true;
        }
    }
}

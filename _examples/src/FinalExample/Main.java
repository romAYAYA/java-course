package FinalExample;

import java.util.Scanner;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);

        IO.println("Enter a transfer amount");
        int transferInput = scanner.nextInt();

        boolean isValid = TransactionalValidator.isValidAmount(transferInput);
        if (isValid) {
            IO.println("Спасибо! Ваш перевод на сумму " + transferInput + " тг. успешно выполнен.");
        }
    }
}

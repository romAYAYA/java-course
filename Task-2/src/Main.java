import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> stepTracker.addNewNumberStepsPerDay();
                case 2 -> stepTracker.changeStepGoal();
                case 3 -> stepTracker.printStatistics();
                case 4 -> {
                    IO.println("Пока!");
                    scanner.close();
                    return;
                }
                default -> IO.println("Такой команды нет");
            }

        }
    }

    public static void printMenu() {
        IO.print("\nВыберите действие:\n1 - Ввести количество шагов за день\n2 - Изменить цель по количеству шагов в день\n3 - Напечатать статистику за определенный месяц\n4 - Выйти из приложения\n");
    }
}

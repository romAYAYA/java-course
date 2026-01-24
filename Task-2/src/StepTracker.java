import java.util.Scanner;

public class StepTracker {
    private final Scanner scanner;
    private final MonthData[] monthToData;
    private final Converter converter;
    private int goalByStepsPerDay;

    StepTracker(Scanner scanner) {
        monthToData = new MonthData[12];
        this.scanner = scanner;
        this.converter = new Converter();
        goalByStepsPerDay = 10_000;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        IO.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (!validateMonth(monthNum)) {
            IO.println("Некорректный номер месяца");
            return;
        }

        IO.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (!validateDay(day)) {
            IO.println("Некорректный номер дня");
            return;
        }

        IO.println("Введите количество шагов");
        int stepsNum = scanner.nextInt();
        if (validateStepsPerDay(stepsNum)) {
            IO.println("Количество шагов должно быть положительным");
            return;
        }

        MonthData monthData = monthToData[monthNum - 1];
        monthData.setStepsForDay(day - 1, stepsNum);
    }

    public void printStatistics() {
        IO.println("Введите число месяца");
        int monthNum = scanner.nextInt();

        if (!validateMonth(monthNum)) {
            IO.println("Некорректный номер месяца");
            return;
        }

        MonthData monthData = monthToData[monthNum - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        monthData.printDaysAndStepsFromMonth();
        IO.println("Общее количество шагов за месяц: " + sumSteps);
        IO.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        IO.println("Среднее количество шагов: " + sumSteps / 30);
        IO.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
        IO.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        IO.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + '\n');
    }


    public void changeStepGoal() {
        IO.println("Введите новую цель по количеству шагов");
        int goal = scanner.nextInt();
        if (validateStepsPerDay(goal)) {
            IO.println("Количество шагов должно быть положительным");
            return;
        }
        this.goalByStepsPerDay = goal;
    }

    private boolean validateMonth(int monthNum) {
        return monthNum >= 1 && monthNum <= 12;
    }

    private boolean validateDay(int day) {
        return day >= 1 && day <= 30;
    }

    private boolean validateStepsPerDay(int stepsNum) {
        return stepsNum <= 0;
    }
}

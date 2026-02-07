public class MonthData {
    private final int[] days;

    MonthData() {
        this.days = new int[30];
    }

    public void setStepsForDay(int day, int steps) {
        days[day] = steps;
    }

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            IO.println((i + 1) + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sum = 0;
        for (int day : days) {
            sum += day;
        }
        return sum;
    }

    public int maxSteps() {
        int max = 0;
        for (int day : days) {
            if (max < day) {
                max = day;
            }
        }
        return max;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int bestSeries = 0;

        for (int stepsInDay : days) {
            if (stepsInDay >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }

        return bestSeries;
    }

}

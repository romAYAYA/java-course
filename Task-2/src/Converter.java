public class Converter {
    private static final int STEPS_PER_KM = 1000;
    private static final int STEPS_PER_KILOCALORIE = 50;

    public int convertToKm(int steps) {
        return steps / STEPS_PER_KM;
    }

    public int convertStepsToKilocalories(int steps) {
        return steps / STEPS_PER_KILOCALORIE;
    }
}
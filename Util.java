import java.util.List;

public class Util {
    public static double sigmoid(double in) {
        return 1 / (1 + Math.exp(-in));
    }

    // Returns a random double between min (inclusive) and max (exclusive)
    public static double nextDouble(double min, double max) {
        java.util.Random r = new java.util.Random();
        return min + (max - min) * r.nextDouble();
    }

    // Returns a random integer between min (inclusive) and max (exclusive)
    public static int nextInt(int min, int max) {
        java.util.Random r = new java.util.Random();
        return min + (max - min) * r.nextInt();
    }

    // Calculate the mean square loss
    public static Double meanSquareLoss(List<Double> corAns, List<Double> predAns) {
        double sum = 0;
        for (int i = 0; i < corAns.size(); i++) {
            double error = corAns.get(i) - predAns.get(i);
            sum += (error * error);
        }
        return sum / (corAns.size());
    }
}
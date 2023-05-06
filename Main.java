import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the network
        Network network = new Network(6);

        // Data set to train the network
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        data.add(Arrays.asList(175, 78)); // Male (0)
        data.add(Arrays.asList(205, 72)); // Male (0)
        data.add(Arrays.asList(215, 71)); // Male (0)
        data.add(Arrays.asList(175, 69)); // Male (0)
        data.add(Arrays.asList(115, 66)); // Female (1)
        data.add(Arrays.asList(120, 67)); // Female (1)
        data.add(Arrays.asList(110, 60)); // Female (1)
        data.add(Arrays.asList(121, 64)); // Female (1)

        // Correct answers
        List<Double> answers = Arrays.asList(0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0);  

        // Train the network
        network.train(data, answers);

        // Predict the answers
        System.out.println(predict(network, "Male", 167, 73));
        System.out.println(predict(network, "Female", 105, 67));
        System.out.println(predict(network, "Female", 120, 72));
        System.out.println(predict(network, "Male", 143, 67));
        System.out.println(predict(network, "Male", 130, 66));
    }

    // Print the predictiomn result in a readable format
    private static String predict(Network net, String gender, int height, int weight) {
        return String.format(gender+". Height: "+height+", Weight: "+weight+" (%.10f)", net.predict(height, weight));
    }
}
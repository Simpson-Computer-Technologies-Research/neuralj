import java.util.ArrayList;
import java.util.List;

public class Network {
    List<Neuron> neurons = new ArrayList<Neuron>();

    public Network(int neurons) {

        // Add six neurons to the network.
        // Neurons 0 - 2 are the input nodes.
        // Neurons 3 - 4 are the hidden nodes.
        // Neuron 5 is the output node.
        for (int i = 0; i < neurons; i++) {
            this.neurons.add(new Neuron());
        }
    }

    // Test prediction using 6 neurons
    public Double predict(Integer in1, Integer in2) {
        // Output neuron
        Neuron n5_output = neurons.get(5);

        // Hidden neurons
        Neuron n4_hidden = neurons.get(4);
        Neuron n3_hidden = neurons.get(3);

        // Input neurons
        Neuron n2_inp = neurons.get(2);
        Neuron n1_inp = neurons.get(1);
        Neuron n0_inp = neurons.get(0);

        // Return computation
        return n5_output.compute(
                n4_hidden.compute(
                        n2_inp.compute(in1, in2),
                        n1_inp.compute(in1, in2)),
                n3_hidden.compute(
                        n1_inp.compute(in1, in2),
                        n0_inp.compute(in1, in2)));
    }

    // Train the network
    public void train(List<List<Integer>> data, List<Double> answers) {
        // Best epoch loss
        Double bestEpochLoss = null;
        for (int epoch = 0; epoch < 1000; epoch++) {
            // Adapt the Neuron
            Neuron epochNeuron = neurons.get(epoch % 6);
            epochNeuron.mutate();

            // Predict the answers
            List<Double> predictions = new ArrayList<Double>();
            for (int i = 0; i < data.size(); i++) {
                Integer d0 = data.get(i).get(0);
                Integer d1 = data.get(i).get(1);
                Double prediction = predict(d0, d1);
                predictions.add(i, prediction);
            }

            // Calculate the loss
            Double thisEpochLoss = Util.meanSquareLoss(answers, predictions);

            // Remember the best epoch
            if (bestEpochLoss == null) {
                bestEpochLoss = thisEpochLoss;
                epochNeuron.remember();
            } else {
                if (thisEpochLoss < bestEpochLoss) {
                    bestEpochLoss = thisEpochLoss;
                    epochNeuron.remember();
                } else {
                    epochNeuron.forget();
                }
            }
        }
    }
}

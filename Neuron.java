public class Neuron {
    private Bias bias = new Bias(-1, 1);
    private Weight weight1 = new Weight(-1, 1);
    private Weight weight2 = new Weight(-1, 1);

    public double compute(double in1, double in2) {
        double preAct = (this.weight1.current * in1) + (this.weight2.current * in2) + this.bias.current;
        return Util.sigmoid(preAct);
    }

    // Mutate the bias and weight.
    public void mutate() {
        // Property to change
        int propertyToChange = Util.nextInt(0, 3);

        // Change factor
        Double changeFactor = Util.nextDouble(-1, 1);

        // Change property
        if (propertyToChange == 0) {
            this.bias.current += changeFactor;
        } else if (propertyToChange == 1) {
            this.weight1.current += changeFactor;
        } else {
            this.weight2.current += changeFactor;
        }
        ;
    }

    // Forget the bias and weight.
    // Swaps the current and old values.
    public void forget() {
        bias.forget();
        weight1.forget();
        weight2.forget();
    }

    // Remember the bias and weight.
    // Swaps the current and old values.
    public void remember() {
        bias.remember();
        weight1.remember();
        weight2.remember();
    }
}

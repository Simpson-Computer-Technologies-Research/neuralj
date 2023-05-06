public class Bias {
    public double old;
    public double current;

    public Bias(int min, int max) {
        this.old = Util.nextDouble(min, max);
        this.current = this.old;
    }

    // Forget the bias.
    // Swaps the current and old values.
    public void forget() {
        this.current = this.old;
    }

    // Remember the bias.
    // Swaps the current and old values.
    public void remember() {
        this.old = this.current;
    }

}

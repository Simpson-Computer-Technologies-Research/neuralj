public class Weight {
    public double old;
    public double current;

    public Weight(int min, int max) {
        this.old = Util.nextDouble(min, max);
        this.current = this.old;
    }

    // Forget the weight.
    // Swaps the current and old values.
    public void forget() {
        this.current = this.old;
    }

    // Remember the weight.
    // Swaps the current and old values.
    public void remember() {
        this.old = this.current;
    }
}
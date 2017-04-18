package expression;

/**
 * Created by vanya on 21.03.17.
 */
public class Const implements AllExpression {
    private final double value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public double evaluate(double value) {
        return this.value;
    }

    @Override
    public int evaluate(int value) {
        return (int)this.value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)this.value;
    }
}

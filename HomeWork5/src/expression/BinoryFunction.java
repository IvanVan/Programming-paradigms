package expression;

/**
 * Created by vanya on 21.03.17.
 */
public abstract class BinoryFunction implements AllExpression {
    protected AllExpression firstArgument, secondArgument;

    public BinoryFunction(AllExpression firstArgument, AllExpression secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    public double evaluate(double value) {
        return apply(firstArgument.evaluate(value), secondArgument.evaluate(value));
    }

    public int evaluate(int x, int y, int z) {
        return apply(firstArgument.evaluate(x, y, z), secondArgument.evaluate(x, y, z));
    }

    protected abstract int apply(int first, int second);

    protected abstract double apply (double first, double second);

    public int evaluate(int x) {
        return apply(firstArgument.evaluate(x), secondArgument.evaluate(x));
    }
}

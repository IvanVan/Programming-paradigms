package expression;

/**
 * Created by vanya on 28.03.17.
 */
public abstract class UnaryOperator implements TripleExpression {
    protected TripleExpression argument;

    public UnaryOperator(TripleExpression argument) {
        this.argument = argument;
    }

    public abstract int apply(int argument) throws Exception;

    public int evaluate(int x, int y, int z) throws Exception {
        return apply(argument.evaluate(x, y, z));
    }

    protected abstract void check(int argument) throws Exception;
}

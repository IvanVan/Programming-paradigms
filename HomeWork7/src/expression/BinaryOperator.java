package expression;

/**
 * Created by vanya on 28.03.17.
 */

public abstract class BinaryOperator implements TripleExpression {
    private TripleExpression firstArgument, secondArgument;

    public BinaryOperator(TripleExpression firstArgument, TripleExpression secondArgument){
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    protected abstract int apply(int first, int second) throws Exception;

    protected abstract void check(int first, int second) throws Exception;

    public int evaluate(int x, int y, int z) throws Exception{
        return apply(firstArgument.evaluate(x, y, z), secondArgument.evaluate(x, y, z));
    }
}

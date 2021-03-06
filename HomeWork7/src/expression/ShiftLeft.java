package expression;

/**
 * Created by vanya on 28.03.17.
 */
public class ShiftLeft extends BinaryOperator {

    public ShiftLeft(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) {
        return first << second;
    }

    @Override
    protected void check(int first, int second) throws Exception {

    }
}

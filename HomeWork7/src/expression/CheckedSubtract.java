package expression;

import expression.exceptions.*;

/**
 * Created by vanya on 28.03.17.
 */
public class CheckedSubtract extends BinaryOperator {

    public CheckedSubtract(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) throws Exception {
        check(first, second);
        return first - second;
    }

    @Override
    protected void check(int first, int second) throws Exception {
        if (second > 0 && first < Integer.MIN_VALUE + second) {
            throw new Overflow();
        }
        if (second < 0 && first > Integer.MAX_VALUE + second) {
            throw new Overflow();
        }
    }
}

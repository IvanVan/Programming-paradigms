package expression;

import expression.exceptions.*;

/**
 * Created by vanya on 28.03.17.
 */
public class CheckedAdd extends BinaryOperator {
    public CheckedAdd(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) throws Exception{
        check(first, second);
        return first + second;
    }

    @Override
    protected void check(int first, int second) throws Exception {
        if (first > 0 && second > Integer.MAX_VALUE - first) {
            throw new Overflow();
        }
        if (first < 0 && second < Integer.MIN_VALUE - first) {
            throw new Overflow();
        }
    }
}

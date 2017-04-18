package expression;

import expression.exceptions.*;

/**
 * Created by vanya on 28.03.17.
 */
public class CheckedDivide extends BinaryOperator {

    public CheckedDivide(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) throws Exception{
        check(first, second);
        return first / second;
    }

    @Override
    protected void check(int first, int second) throws Exception {
        if (second == 0) {
            throw new DBZException();
        }
        if (first == Integer.MIN_VALUE && second == -1) {
            throw new Overflow();
        }
    }
}

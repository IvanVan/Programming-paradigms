package expression;

import expression.exceptions.*;

/**
 * Created by vanya on 29.03.17.
 */
public class CheckedNegate extends UnaryOperator {
    public CheckedNegate(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) throws Exception{
        check(argument);
        return -argument;
    }

    @Override
    protected void check(int argument) throws Exception {
        if (argument == Integer.MIN_VALUE) {
            throw new Overflow();
        }
    }
}

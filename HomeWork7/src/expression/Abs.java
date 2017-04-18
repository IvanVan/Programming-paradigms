package expression;

import expression.exceptions.Overflow;

/**
 * Created by vanya on 28.03.17.
 */
public class Abs extends UnaryOperator {
    public Abs(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) throws Exception{
        check(argument);
        if (argument > 0) {
            return argument;
        } else {
            return -argument;
        }
    }

    @Override
    protected void check(int argument) throws Exception {
        if (argument == Integer.MIN_VALUE) {
            throw new Overflow();
        }
    }
}

package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 29.03.17.
 */
public class Minus extends UnaryFunction {
    public Minus(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) {
        return -argument;
    }
}

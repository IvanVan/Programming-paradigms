package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public class Abs extends UnaryFunction {
    public Abs(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) {
        return Math.abs(argument);
    }
}

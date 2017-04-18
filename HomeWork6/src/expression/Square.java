package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public class Square extends UnaryFunction {
    public Square(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) {
        return argument * argument;
    }

}

package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public abstract class UnaryFunction implements TripleExpression {
    protected TripleExpression argument;

    public UnaryFunction(TripleExpression argument) {
        this.argument = argument;
    }

    public abstract int apply(int argument);

    public int evaluate(int x, int y, int z){
        return apply(argument.evaluate(x, y, z));
    }
}

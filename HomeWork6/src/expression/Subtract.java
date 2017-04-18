package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public class Subtract extends BinaryFunction {

    public Subtract(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) {
        return first - second;
    }
}

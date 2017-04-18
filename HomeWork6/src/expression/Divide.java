package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public class Divide extends BinaryFunction {

    public Divide(TripleExpression firstArgument, TripleExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    public int apply(int first, int second) {
        return first / second;
    }
}

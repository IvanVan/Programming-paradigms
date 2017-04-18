package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public abstract class BinaryFunction implements TripleExpression {
    private TripleExpression firstArgument, secondArgument;

    BinaryFunction(TripleExpression firstArgument, TripleExpression secondArgument){
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    public abstract int apply(int first, int second);

    public int evaluate(int x, int y, int z){
        return apply(firstArgument.evaluate(x, y, z), secondArgument.evaluate(x, y, z));
    }
}

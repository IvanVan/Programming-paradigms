package expression;

/**
 * Created by vanya on 28.03.17.
 */
public class Square extends UnaryOperator {

    public Square(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) throws Exception {
        return 0;
    }

    @Override
    protected void check(int argument) throws Exception {

    }
}

package expression;

/**
 * Created by vanya on 09.04.17.
 */
public class Max extends BinaryOperator {

    public Max(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    @Override
    protected int apply(int first, int second) throws Exception {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    @Override
    protected void check(int first, int second) throws Exception {}
}

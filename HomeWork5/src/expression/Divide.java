package expression;

/**
 * Created by vanya on 21.03.17.
 */
public class Divide extends BinoryFunction {
    public Divide(AllExpression firstArgument, AllExpression secondArgument) {
        super(firstArgument, secondArgument);
    }

    @Override
    protected int apply(int first, int second) {
        return first / second;
    }

    @Override
    protected double apply(double first, double second) {
        return first / second;
    }


}

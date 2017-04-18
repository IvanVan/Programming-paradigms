package expression;

/**
 * Created by vanya on 29.03.17.
 */
public interface AllExpression extends Expression, DoubleExpression, TripleExpression{
    double evaluate(double value);

    int evaluate(int value);

    int evaluate(int x, int y, int z);
}

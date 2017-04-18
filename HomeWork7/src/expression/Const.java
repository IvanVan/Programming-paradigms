package expression;

/**
 * Created by vanya on 28.03.17.
 */
public class Const implements TripleExpression {
    private int value;

    public Const (int value) {
        this.value = value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value;
    }
}

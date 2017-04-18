package expression;

/**
 * Created by vanya on 28.03.17.
 */
public class Variable implements TripleExpression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}

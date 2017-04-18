package expression;

import expression.exceptions.Overflow;

/**
 * Created by vanya on 09.04.17.
 */
public class Sqrt extends UnaryOperator {
    public Sqrt(TripleExpression argument) {
        super(argument);
    }

    @Override
    public int apply(int argument) throws Exception {
        check(argument);
        int l = 0, r = 46341;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (m * m <= argument) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    @Override
    protected void check(int argument) throws Exception {
        if(argument < 0) {
            throw new Overflow();
        }
    }
}

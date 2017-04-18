package expression;

import expression.parser.Expression;
import expression.parser.ExpressionParser;
import expression.parser.TripleExpression;

/**
 * Created by vanya on 04.04.17.
 */
public class Main {
    public static void main(String[] args) {
        String s = "2-y";
        ExpressionParser par = new ExpressionParser();
        TripleExpression ex = par.parse(s);
        System.out.println(ex.evaluate(0, 1, 0));
    }
}

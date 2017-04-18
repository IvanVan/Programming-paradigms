package expression;

import expression.parser.TripleExpression;

/**
 * Created by vanya on 28.03.17.
 */
public interface Parser {
    TripleExpression parse(String expression);
}

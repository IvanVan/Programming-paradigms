package expression.parser;



/**
 * Created by vanya on 09.04.17.
 */
class NextToken {
    private final String expression;
    private int curIndex;
    private Token prevToken;

    NextToken(String expression) {
        this.expression = expression;
        curIndex = 0;
    }

    Token getNextToken(ExpressionParser name) {
        Token curToken;
        int sz = expression.length();
        while(curIndex < sz && Character.isWhitespace(expression.charAt(curIndex))) {
            curIndex++;
        }
        if (curIndex >= sz) {
            return Token.End;
        }
        char nowHave = expression.charAt(curIndex);
        switch (nowHave) {
            case '+':
                curToken = Token.Add;
                break;
            case '-':
                if (prevToken == Token.CloseBracket || prevToken == Token.Variable || prevToken == Token.Number) {
                    curToken = Token.Sub;
                } else {
                    curToken = Token.Not;
                }
                break;
            case '*':
                curToken = Token.Mul;
                break;
            case '/':
                curToken = Token.Div;
                break;
            case '(':
                curToken = Token.OpenBracket;
                break;
            case ')':
                curToken = Token.CloseBracket;
                break;
            default:
                if (Character.isDigit(expression.charAt(curIndex))) {
                    int from = curIndex;
                    while(curIndex < sz && Character.isDigit(expression.charAt(curIndex))) {
                        curIndex++;
                    }
                    int to = curIndex;
                    int value = Integer.parseUnsignedInt(expression.substring(from, to));
                    name.setValue(value);
                    if (curIndex != sz)
                        curIndex--;
                    curToken = Token.Number;
                } else if (nowHave == 'x' || nowHave == 'y' || nowHave == 'z') {
                    curToken = Token.Variable;
                    name.setName(String.valueOf(nowHave));
                } else if (expression.substring(curIndex, curIndex + 2).equals("<<")) {
                    curToken = Token.LeftShift;
                    curIndex++;
                } else if (expression.substring(curIndex, curIndex + 2).equals(">>")) {
                    curToken = Token.RightShift;
                    curIndex++;
                } else if(expression.substring(curIndex, curIndex + 3).equals("abs")) {
                    curToken = Token.Abs;
                    curIndex += 2;
                } else if (expression.substring(curIndex, curIndex + 3).equals("mod")) {
                    curToken = Token.Mod;
                    curIndex += 2;
                } else if (expression.substring(curIndex, curIndex + 6).equals("square")) {
                    curToken = Token.Square;
                    curIndex += 5;
                } else {
                    curToken = Token.Mistake;
                }
        }
        curIndex++;
        prevToken = curToken;
        return curToken;
    }
}

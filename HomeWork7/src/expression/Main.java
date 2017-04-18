package expression;

import expression.parser.*;

/**
 * Created by vanya on 04.04.17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //String s = "1000000*x*x*x*x*x/(x-1)";
        //ExpressionParser par = new ExpressionParser();
        //TripleExpression ex = par.parse(s);
        //for (int i = 0; i < 10; i++) {
        //    System.out.printf("%d ", i);
        //    try{
        //        int ans = ex.evaluate(i, 0, 0);
        //        System.out.println(ans);
        //    } catch (Exception e) {
        //        System.out.println(e.getMessage());
        //    }
        //}
        String s = "(x+ y";
        ExpressionParser par = new ExpressionParser();
        TripleExpression ex = par.parse(s);
            int ans = ex.evaluate(-10, 0 ,0);
            System.out.println(ans);
    }
}

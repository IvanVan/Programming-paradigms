import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            ArrayQueueModule.push( i * 10);
        }
        while (!ArrayQueueModule.isEmpty()){
            System.out.println(
                    "size  = " + ArrayQueueModule.size() + " " +
                    "element = " + ArrayQueueModule.element() + " " + " " +
                    "deq = " + ArrayQueueModule.dequeue()
            );
        }
    }
}

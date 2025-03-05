import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        int pushNum = 1;
        for (int input = 1; input <= numCnt; input++) {
            int num = Integer.parseInt(br.readLine());

            while (pushNum <= num) {
                stack.push(pushNum++);
                answer.append("+").append("\n");
            }

            if (stack.peek() > num) {
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            answer.append("-").append("\n");
        }

        System.out.println(answer);
    }
}
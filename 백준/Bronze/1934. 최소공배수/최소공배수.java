import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCnt = Integer.valueOf(br.readLine());
        for (int input = 1; input <= inputCnt; input++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.valueOf(st.nextToken());
            int num2 = Integer.valueOf(st.nextToken());

            answer.append(num1 * num2 / gcd(num1, num2)).append("\n");
        }

        System.out.println(answer);
    }
}

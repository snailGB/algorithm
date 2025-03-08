import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] startNumArr = {2, 3, 5, 7};
    static int[] possibleNumArr = {1, 3, 7, 9};
    static StringBuilder answer = new StringBuilder();

    static void dfs(int currentNum, int currentDigit, int limitDigit) {
        if(currentDigit == limitDigit) {
            answer.append(currentNum).append("\n");
            return;
        }

        for (int num : possibleNumArr) {
            int nextNum = currentNum * 10 + num;

            if(!isPrime(nextNum))
                continue;

            dfs(nextNum, currentDigit + 1, limitDigit);
        }
    }

    static boolean isPrime(int checkNum) {
        if(checkNum == 1)
            return false;

        for (int divideNum = 2; divideNum <= Math.sqrt(checkNum); divideNum++) {
            if(checkNum % divideNum == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int digit = Integer.valueOf(br.readLine());

        for (int num : startNumArr) {
            dfs(num, 1, digit);
        }

        System.out.println(answer);
    }
}

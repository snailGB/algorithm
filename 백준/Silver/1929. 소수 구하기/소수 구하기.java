import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int from = sc.nextInt();
        int to = sc.nextInt();

        boolean[] isPrime = new boolean[to + 1];
        for (int num = 2; num <= to; num++) {
            isPrime[num] = true;
        }

        for (int stdNum = 2; stdNum <= Math.sqrt(to); stdNum++) {
            if(isPrime[stdNum]) {
                //stdNum의 배수 소수에서 제외
                for (int searchNum = stdNum + stdNum; searchNum <= to; searchNum += stdNum) {
                    isPrime[searchNum] = false;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int num = from; num <= to; num++) {
            if(isPrime[num])
                answer.append(num).append("\n");
        }

        System.out.println(answer);
    }
}

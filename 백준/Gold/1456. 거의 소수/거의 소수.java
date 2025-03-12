import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long from = sc.nextLong();
        long to = sc.nextLong();

        int max = (int) Math.sqrt(to);
        boolean[] isPrime = new boolean[max + 1];

        for (int num = 2; num <= max; num++) {
            isPrime[num] = true;
        }

        for (int stdNum = 2; stdNum <= Math.sqrt(max); stdNum++) {
            if (!isPrime[stdNum]) {
                continue;
            }

            for (int multiple = stdNum * 2; multiple <= max; multiple += stdNum) {
                isPrime[multiple] = false;
            }
        }

        int answer = 0;

        for (int num = 2; num <= max; num++) {
            if (!isPrime[num]) {
                continue;
            }

            long square = (long) num * num;
            while (square <= to) {
                if (square >= from) {
                    answer++;
                }

                if (square > to / num) {
                    break;
                }

                square *= num;
            }
        }

        System.out.println(answer);
    }
}

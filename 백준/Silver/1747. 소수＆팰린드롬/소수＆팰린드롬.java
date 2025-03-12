import java.io.IOException;
import java.util.*;

public class Main {
    static boolean isPalindrome(int num) {
        String str = num + "";

        for (int chIdx = 0; chIdx < str.length() / 2; chIdx++) {
            if (str.charAt(chIdx) != str.charAt(str.length() - chIdx - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int from = sc.nextInt();

        int max = 10000000;
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int num = 2; num <= Math.sqrt(max); num++) {
            if (!isPrime[num]) {
                continue;
            }

            for (int multiple = num * num; multiple <= max; multiple += num) {
                isPrime[multiple] = false;
            }
        }

        for (int num = from; num <= max; num++) {
            if(isPrime[num] && isPalindrome(num)) {
                System.out.println(num);
                System.exit(0);
            }
        }

    }
}

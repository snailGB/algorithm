import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long answer = n;
        for (long num = 2; num <= Math.sqrt(n); num++) {
            if (n % num == 0) { //소인수이면
                answer -= answer / num;
                while(n % num == 0) {
                    n /= num;
                }
            }
        }

        if (n > 1) {
            answer -= answer / n;
        }

        System.out.println(answer);
    }
}

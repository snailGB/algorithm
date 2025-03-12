import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long gcd(long num1, long num2) {
        while (num2 != 0) {
            long remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        long leftDigit = sc.nextLong();
        long rightDigit = sc.nextLong();

        long gcd = gcd(leftDigit, rightDigit);

        StringBuilder answer = new StringBuilder();
        while (gcd > 0) {
            answer.append(1);
            gcd--;
        }

        System.out.println(answer);
    }
}

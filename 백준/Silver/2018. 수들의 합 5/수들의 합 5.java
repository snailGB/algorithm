import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int startNum = 1;
        int endNum = 1;
        int sum = 1;
        int answer = 1;
        while (endNum < num) {
            if (sum < num) {
                sum += ++endNum;
            } else if (sum > num) {
                sum -= startNum++;
            } else {
                answer++;
                sum += ++endNum;
            }
        }

        System.out.println(answer);
    }
}
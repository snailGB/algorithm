import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.valueOf(br.readLine());
        String num = br.readLine();
        int sum = 0;

        for(int numIdx = 0; numIdx < length; numIdx++) {
            sum += num.charAt(numIdx) - 48;
        }

        System.out.println(sum);
    }
}
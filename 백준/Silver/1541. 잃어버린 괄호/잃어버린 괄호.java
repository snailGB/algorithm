import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum(String str) {
        int sum = 0;
        String[] tmpArr = str.split("\\+");
        for (String num : tmpArr) {
            sum += Integer.valueOf(num);
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] strArr = input.split("-");
        int answer = sum(strArr[0]);
        for (int idx = 1; idx < strArr.length; idx++) {
            answer -= sum(strArr[idx]); // 이후 그룹은 더한 뒤 빼기
        }

        System.out.println(answer);
    }
}

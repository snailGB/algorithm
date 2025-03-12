import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCnt = Integer.valueOf(st.nextToken());
        int targetSum = Integer.valueOf(st.nextToken());

        int[] coinArr = new int[coinCnt];
        for (int idx = 0; idx < coinCnt; idx++) {
            coinArr[idx] = Integer.valueOf(br.readLine());
        }

        int coinIdx = coinCnt - 1;
        while (targetSum / coinArr[coinIdx] == 0) {
            coinIdx--;
        }

        int answer = 0;
        while(true) {
            int currentCnt = targetSum / coinArr[coinIdx];

            answer += currentCnt;
            targetSum -= coinArr[coinIdx] * currentCnt;

            if (targetSum == 0) {
                break;
            }

            coinIdx--;
        }

        System.out.println(answer);
    }
}

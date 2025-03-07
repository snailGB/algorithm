import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int[] numArr = new int[numCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(numArr);

        System.out.println(numArr[target - 1]);
    }
}

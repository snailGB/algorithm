import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder answer = new StringBuilder();

    static void binarySearch(int[] arr, int findNum) {
        int fromIdx = 0;
        int toIdx = arr.length - 1;
        boolean found = false;
        while (fromIdx <= toIdx) {
            int midIdx = fromIdx + (toIdx - fromIdx) / 2;
            if(arr[midIdx] > findNum) {
                toIdx = midIdx - 1;
            } else if(arr[midIdx] < findNum) {
                fromIdx = midIdx + 1;
            } else {
                found = true;
                break;
            }
        }

        if(found) {
            answer.append(1).append("\n");
        } else {
            answer.append(0).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.valueOf(br.readLine());
        int[] numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(numArr);

        int findNumCnt = Integer.valueOf(br.readLine());
        int[] findNumArr = new int[findNumCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < findNumCnt; idx++) {
            findNumArr[idx] = Integer.valueOf(st.nextToken());
        }

        for (int findNum : findNumArr) {
            binarySearch(numArr, findNum);
        }

        System.out.println(answer);
    }
}

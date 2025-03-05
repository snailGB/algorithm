import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        int[] arr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for(int targetIdx = 0; targetIdx < numCnt; targetIdx++) {
            int startIdx = 0;
            int endIdx = numCnt - 1;

            while(startIdx < endIdx) {
                long sum = arr[startIdx] + arr[endIdx];
                if(sum > arr[targetIdx]) {
                    endIdx--;
                } else if(sum < arr[targetIdx]) {
                    startIdx++;
                } else {
                    if(startIdx != targetIdx && endIdx != targetIdx) {
                        answer++;
                        break;
                    } else if(startIdx == targetIdx) {
                        startIdx++;
                    } else {
                        endIdx--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
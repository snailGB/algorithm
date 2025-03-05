import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int startIdx = 0;
        int endIdx = length - 1;

        int count = 0;
        while(startIdx < endIdx) {
            int sum = arr[startIdx] + arr[endIdx];
            if(sum < target) {
                startIdx++;
            } else if(sum > target) {
                endIdx--;
            } else {
                count++;
                endIdx--;
                startIdx++;
            }
        }

        System.out.println(count);
    }
}
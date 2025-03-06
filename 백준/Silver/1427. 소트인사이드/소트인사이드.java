import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();
        int[] arr = new int[size];
        for (int idx = 0; idx < size; idx++) {
            arr[idx] = str.charAt(idx) - '0';
        }

        for (int changeIdx = 0; changeIdx < size; changeIdx++) {
            int maxIdx = changeIdx;
            for (int idx = changeIdx + 1; idx < size; idx++) {
                if(arr[maxIdx] < arr[idx])
                    maxIdx = idx;
            }
            
            if(arr[changeIdx] < arr[maxIdx]) {
                int tmp = arr[changeIdx];
                arr[changeIdx] = arr[maxIdx];
                arr[maxIdx] = tmp;
            }
        }

        for (int num : arr) {
            System.out.print(num);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCnt = sc.nextInt();

        int[] numArr = new int[numCnt];
        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = sc.nextInt();
        }

        //버블 정렬
        for (int areaIdx = 0; areaIdx < numCnt - 1; areaIdx++) {
            for (int idx = 0; idx < numCnt - 1 - areaIdx; idx++) {
                if (numArr[idx] > numArr[idx + 1]) {
                    int tmp = numArr[idx];
                    numArr[idx] = numArr[idx + 1];
                    numArr[idx + 1] = tmp;
                }
            }
        }

        for (int num : numArr) {
            System.out.println(num);
        }
    }
}
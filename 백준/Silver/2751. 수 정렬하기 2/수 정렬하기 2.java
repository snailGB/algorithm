import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void mergeSort(int[] arr, int fromIdx, int toIdx) {
        if (fromIdx >= toIdx)
            return;

        int midIdx = fromIdx + (toIdx - fromIdx) / 2;

        mergeSort(arr, fromIdx, midIdx);
        mergeSort(arr, midIdx + 1, toIdx);

        merge(arr, fromIdx, midIdx, toIdx);
    }

    static void merge(int[] arr, int fromIdx, int midIdx, int toIdx) {
        int leftIdx = fromIdx;
        int rightIdx = midIdx + 1;
        int insertIdx = 0;

        int[] tmpArr = new int[toIdx - fromIdx + 1];

        while(leftIdx <= midIdx && rightIdx <= toIdx) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                tmpArr[insertIdx++] = arr[leftIdx++];
            } else {
                tmpArr[insertIdx++] = arr[rightIdx++];
            }
        }

        while (leftIdx <= midIdx) {
            tmpArr[insertIdx++] = arr[leftIdx++];
        }

        while (rightIdx <= toIdx) {
            tmpArr[insertIdx++] = arr[rightIdx++];
        }

        System.arraycopy(tmpArr, 0, arr, fromIdx, tmpArr.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());

        int[] numArr = new int[numCnt];

        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = Integer.parseInt(br.readLine());
        }

        mergeSort(numArr, 0, numCnt - 1);

        for(int num : numArr) {
            System.out.println(num);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long answer;  // 교환 횟수를 세기 위해 long으로 선언

    static void mergeSort(int[] arr, int fromIdx, int toIdx) {
        if (fromIdx >= toIdx) {
            return;
        }

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

        // 왼쪽 배열과 오른쪽 배열을 병합하면서 교환 횟수 세기
        while (leftIdx <= midIdx && rightIdx <= toIdx) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                tmpArr[insertIdx++] = arr[leftIdx++];
            } else {
                tmpArr[insertIdx++] = arr[rightIdx++];
                // 왼쪽 배열의 남은 원소들이 오른쪽 배열의 원소보다 크므로
                // 그만큼 교환 횟수 증가
                answer += (midIdx - leftIdx + 1); // leftIdx부터 midIdx까지의 값들은 모두 교환되어야 한다.
            }
        }

        // 왼쪽 배열에 남은 값 처리
        while (leftIdx <= midIdx) {
            tmpArr[insertIdx++] = arr[leftIdx++];
        }

        // 오른쪽 배열에 남은 값 처리
        while (rightIdx <= toIdx) {
            tmpArr[insertIdx++] = arr[rightIdx++];
        }

        // 임시 배열의 값을 원본 배열에 복사
        System.arraycopy(tmpArr, 0, arr, fromIdx, tmpArr.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());

        int[] numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        mergeSort(numArr, 0, numCnt - 1);

        System.out.println(answer);
    }
}

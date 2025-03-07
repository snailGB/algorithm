package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    //데이터를 분할, 분할한 집합을 정렬하고 합치는 정렬, O(nlogn)
    static void mergeSort(int[] arr, int fromIdx, int toIdx) {
        if(fromIdx >= toIdx)
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
        while (leftIdx <= midIdx && rightIdx <= toIdx) {
            if(arr[leftIdx] <= arr[rightIdx]) {
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
}

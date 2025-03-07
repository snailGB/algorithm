package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    //pivot 기준 왼쪽, 오른쪽 배열 정렬, O(nlogn)
    static void quickSort(int[] arr, int fromIdx, int toIdx) {
        if (fromIdx >= toIdx)
            return;

        int pivotIdx = partition(arr, fromIdx, toIdx);

        quickSort(arr, fromIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, toIdx);
    }

    static int partition(int[] arr, int fromIdx, int toIdx) {
        //중간 값 pivot으로 설정
        int pivotIdx = fromIdx + (toIdx - fromIdx) / 2;
        int pivotValue = arr[pivotIdx];

        //pivot 끝으로 이동
        swap(arr, pivotIdx, toIdx);

        int lastLowIdx = fromIdx - 1;
        for (int searchIdx = fromIdx; searchIdx < toIdx; searchIdx++) {
            //pivot보다 작은 값들을 맨 앞부터 교환
            if(arr[searchIdx] < pivotValue) {
                lastLowIdx++;
                swap(arr, lastLowIdx, searchIdx);
            }
        }

        //pivot을 제 위치로 이동
        swap(arr, lastLowIdx + 1, toIdx);

        //pivot 위치 반환
        return lastLowIdx + 1;
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}

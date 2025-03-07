package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //기준값을 정하고 왼쪽으로 탐색하며 올바른 위치에 삽입, O(n^2)
    static void insertionSort(int[] arr) {
        for (int stdIdx = 1; stdIdx < arr.length; stdIdx++) {
            int insertValue = arr[stdIdx];
            int searchIdx = stdIdx - 1;
            //insertValue보다 큰 값들을 찾아 오른쪽으로 한 칸씩 밀어준다
            while(searchIdx >= 0 && arr[searchIdx] > insertValue) {
                arr[searchIdx + 1] = arr[searchIdx];
                searchIdx--;
            }

            arr[searchIdx + 1] = insertValue;
        }
    }
}

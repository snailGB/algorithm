package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //최솟값을 찾아 맨 앞으로 이동을 반복하며 정렬, O(n^2)
    static void selectionSort(int[] arr) {
        for (int changeIdx = 0; changeIdx < arr.length; changeIdx++) {
            int minIdx = changeIdx;
            for(int searchIdx = changeIdx + 1; searchIdx < arr.length; searchIdx++) {
                if(arr[searchIdx] < arr[minIdx]) {
                    minIdx = searchIdx;
                }
            }

            if(arr[minIdx] < arr[changeIdx]) {
                int tmp = arr[minIdx];
                arr[minIdx] = arr[changeIdx];
                arr[changeIdx] = tmp;
            }

            System.out.println(Arrays.toString(arr));
        }
    }
}

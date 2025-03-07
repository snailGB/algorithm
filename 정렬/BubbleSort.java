package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //두 인접한 데이터의 크기를 비교해 정렬, O(n^2)
    //가장 큰 수를 맨 끝으로 보내고, 보낸 수를 배제하고 루프 진행
    static void bubbleSort(int[] arr) {
        for (int completeCnt = 0; completeCnt < arr.length; completeCnt++) {
            for (int searchIdx = 0; searchIdx < arr.length - 1 - completeCnt; searchIdx++) {
                if(arr[searchIdx] > arr[searchIdx + 1]) {
                    int tmp = arr[searchIdx];
                    arr[searchIdx] = arr[searchIdx + 1];
                    arr[searchIdx + 1] = tmp;
                }
            }
        }
    }
}

package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //값이 아닌 자릿수 비교를 통한 정렬, O(가장 큰 자릿수 * n)
    static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // 최댓값의 자릿수만큼 정렬 반복
        for (int digit = 1; max / digit > 0; digit *= 10) {
            countingSort(arr, digit);
        }
    }

    static void countingSort(int[] arr, int digit) {
        int[] resultArr = new int[arr.length];
        int[] countArr = new int[10];

        // 현재 자릿수 값의 개수 세기
        for (int idx = 0; idx < arr.length; idx++) {
            countArr[(arr[idx] / digit) % 10]++;
        }

        // 누적합 계산 >> arr 값의 자릿수별 정렬 위치 파악
        for (int idx = 1; idx < 10; idx++) {
            countArr[idx] += countArr[idx - 1];
        }

        // 정렬 (반대로 순회해야 같은 자릿수를 가진 숫자 순서 유지)
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            int currentDigit = (arr[idx] / digit) % 10;
            resultArr[countArr[currentDigit] - 1] = arr[idx];
            countArr[currentDigit]--;
        }

        System.arraycopy(resultArr, 0, arr, 0, arr.length);
    }
}

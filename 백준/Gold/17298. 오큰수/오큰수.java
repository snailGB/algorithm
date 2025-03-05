import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < size; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        int[] answer = new int[size];
        Arrays.fill(answer, -1); // 기본적으로 -1로 초기화

        for (int idx = 0; idx < size; idx++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[idx]) {
                answer[stk.pop()] = arr[idx]; // 오큰수 저장
            }
            stk.push(idx); // 현재 인덱스를 스택에 저장
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int idx = 0; idx < size; idx++) {
            bw.write(answer[idx] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}

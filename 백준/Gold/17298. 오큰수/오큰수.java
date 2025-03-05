import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.valueOf(br.readLine());
        int[] numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < numCnt; idx++) {
            numArr[idx] = Integer.valueOf(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int[] resultArr = new int[numCnt];
        for (int idx = 1; idx < numCnt; idx++) {
            while(!stk.isEmpty() && numArr[stk.peek()] < numArr[idx]) {
                resultArr[stk.pop()] = numArr[idx];
            }
            stk.push(idx);
        }

        while(!stk.isEmpty()) {
            resultArr[stk.pop()] = -1;
        }
        
        StringBuilder answer = new StringBuilder();
        for (int num : resultArr) {
            answer.append(num).append(" ");
        }

        System.out.println(answer);
    }
}
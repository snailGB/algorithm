import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.valueOf(st.nextToken());
        int sumCnt = Integer.valueOf(st.nextToken());

        int[][] numArr = new int[size + 1][size + 1];
        for (int row = 1; row <= size; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= size; col++) {
                numArr[row][col] = Integer.valueOf(st.nextToken());
            }
        }

        int[][] sumArr = new int[size + 1][size + 1];
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                //가로합 + 세로합 - 겹친 부분 + 새로운 값
                sumArr[row][col] = sumArr[row-1][col] + sumArr[row][col-1] - sumArr[row-1][col-1] + numArr[row][col];
            }
        }

        StringBuilder answer = new StringBuilder();
        while(sumCnt > 0) {
            st = new StringTokenizer(br.readLine());
            int fromRow = Integer.valueOf(st.nextToken());
            int fromCol = Integer.valueOf(st.nextToken());
            int toRow = Integer.valueOf(st.nextToken());
            int toCol = Integer.valueOf(st.nextToken());

            //-가로합 -세로합 + 겹친 부분
            answer.append(sumArr[toRow][toCol] - sumArr[fromRow - 1][toCol] - sumArr[toRow][fromCol - 1]
                    + sumArr[fromRow - 1][fromCol - 1]).append("\n");

            sumCnt--;
        }

        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int subjectCnt = Integer.valueOf(br.readLine());
        int[] scoreArr = new int[subjectCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        int maxScore = 0;
        while(st.hasMoreTokens()) {
            int score = Integer.valueOf(st.nextToken());
            scoreArr[idx++] = score;

            if(maxScore < score) {
                maxScore = score;
            }
        }

        double sum = 0;
        for(int scoreIdx = 0; scoreIdx < subjectCnt; scoreIdx++) {
            sum += scoreArr[scoreIdx] / (double) maxScore * 100;
        }

        System.out.println(sum / subjectCnt);
    }
}
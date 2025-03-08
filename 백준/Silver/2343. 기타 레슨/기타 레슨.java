import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 레슨의 수
        int M = Integer.parseInt(st.nextToken());  // 블루레이의 수

        int[] lessons = new int[N];
        st = new StringTokenizer(br.readLine());
        int totalLength = 0;
        int maxLesson = 0;

        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            totalLength += lessons[i];
            maxLesson = Math.max(maxLesson, lessons[i]);
        }

        int left = maxLesson, right = totalLength;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            int count = 1;
            int currentSize = 0;
            for (int i = 0; i < N; i++) {
                if (currentSize + lessons[i] > mid) {
                    count++;
                    currentSize = lessons[i];
                } else {
                    currentSize += lessons[i];
                }

                if (count > M) {
                    break;
                }
            }

            if (count <= M) {
                answer = mid;  
                right = mid - 1;  
            } else {
                left = mid + 1;  
            }
        }

        System.out.println(answer);
    }
}

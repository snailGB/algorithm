import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(br.readLine());
        int target = Integer.valueOf(br.readLine());

        long from = 1;
        long to = target;
        long answer = 0;

        while (from <= to) {
            long mid = (from + to) / 2;
            long count = 0;

            // mid 값보다 작거나 같은 값들의 개수 계산
            for (int i = 1; i <= size; i++) {
                // i * j <= mid 를 만족하는 j 값의 개수
                count += Math.min(mid / i, size);   // mid / i는 j의 최댓값
            }

            if (count < target) {
                from = mid + 1;
            } else {
                answer = mid;
                to = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

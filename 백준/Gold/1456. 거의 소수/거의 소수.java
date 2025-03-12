import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // from과 to를 입력받음
        long from = sc.nextLong();
        long to = sc.nextLong();

        // to의 제곱근까지의 소수를 구하기 위한 배열
        int max = (int) Math.sqrt(to);
        boolean[] isPrime = new boolean[max + 1];
        
        // 에라토스테네스의 체로 소수 구하기
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        
        // 소수의 거듭제곱 수 찾기
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                long power = (long) i * i; // p^2 부터 시작
                while (power <= to) {
                    if (power >= from) {
                        count++;
                    }
                    // 오버플로우 방지
                    if (power > to / i) break;
                    power *= i;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}

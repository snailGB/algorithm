import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] times = new int[N];
        
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
        }
        
        Arrays.sort(times);
        
        int totalTime = 0;  
        int sum = 0;        
        
        for (int time : times) {
            sum += time;
            totalTime += sum;
        }
        
        System.out.println(totalTime);
    }
}

//queue 활용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> que = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine().trim());
		for(int num = 1; num <= N; num++) {
			que.offer(num);
		}
		
		while(que.size() != 1) {
			que.poll();
			que.offer(que.poll());
		}
		
		System.out.println(que.poll());
	}
}

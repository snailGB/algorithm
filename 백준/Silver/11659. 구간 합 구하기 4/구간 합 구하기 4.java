import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이경배
 * 1sec, 256MB
 * 
 * 수 numCnt가 주어졌을 때, from번째 수부터 to번째 수까지 합을 구하시오
 * 
 * 입력
 * 	1. 수의 개수 numCnt, 합 횟수 sumCnt(1~100,000)
 * 	2. numCnt개의 수(1~1000)
 * 	3~ from, to
 *
 *출력
 * 각 구역의 합 출력
 * ==========================================================
 * int[]에 수들을 입력하면서, 각 인덱스까지의 합을 sum[]에 따로 저장한다
 * sum[to]에서 sum[from-1]을 구하면 구간합이 나온다
 */
public class Main {
	static int numCnt, sumCnt;
	static int[] nums;
	
	static int[] sums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		numCnt = Integer.parseInt(st.nextToken());
		sumCnt = Integer.parseInt(st.nextToken());
		
		//배열 생성, 0인덱스 사용 X
		st = new StringTokenizer(br.readLine().trim());
		nums = new int[numCnt+1];
		sums = new int[numCnt+1];
		for(int num = 1; num <= numCnt; num++) {
			nums[num] = Integer.parseInt(st.nextToken());
			sums[num] = sums[num-1] + nums[num];	//입력값마다 합을 누적해 저장
		}
		
		//부분합 구하기
		for(int sum = 0; sum < sumCnt; sum++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			sb.append(sums[to]-sums[from-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}

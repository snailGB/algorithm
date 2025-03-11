import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author 이경배
 * 	N을 입력받아 N*N map을 형성
 * 	1은 집, 0은 집X
 * 	상하좌우 연결된 집의 모임을 단지로 정의
 * 	지도를 입력하여 단지수 출력, 각 단지에 속하는 집의 수를 오름차순으로 정렬해 출력
 * ==========================================================
 * 	BFS, DFS 모두 활용 가능
 * 	
 *
 */
public class Main {
	static int N;
	static int[][] map;
	
	static boolean[][] isVisited;
	static List<Integer> cnt;
	static StringBuilder sb;
	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void bfs(int row, int col) {
		Queue<int[]> que = new ArrayDeque<>();
		int homeCnt = 0;
		
		que.offer(new int[] {row, col});
			isVisited[row][col] = true;
			homeCnt++;
			
		while(!que.isEmpty()) {
			int[] currentRC = que.poll();
			
			for(int dIdx = 0; dIdx < 4; dIdx++) {
				int nextR = currentRC[0] + dr[dIdx];
				int nextC = currentRC[1] + dc[dIdx];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
					continue;
				
				if(map[nextR][nextC] == 0 || isVisited[nextR][nextC])
					continue;
				
				que.offer(new int[] {nextR, nextC});
				isVisited[nextR][nextC] = true;
				homeCnt++;
			}
		}
		
		cnt.add(homeCnt);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		cnt = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine().trim();
			for(int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 0)	//0이면 방문할 필요가 없으니 방문처리를 하고 넘어간다
					isVisited[r][c] = true;
				else {	//1을 만났고, 검증된 적이 없다면 해당 좌표를 시작으로 bfs탐색 진행
					if(!isVisited[r][c]) {
						bfs(r, c);
					}
				}
			}
		}
		
		System.out.println(cnt.size());
		Collections.sort(cnt);
		for(int num : cnt) {
			System.out.println(num);
		}
	}
}

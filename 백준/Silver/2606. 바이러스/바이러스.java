import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int comCnt;
	static int pairCnt;
	
	static List<List<Integer>> list;
	static boolean[] isVisited;
	static int count;
	
	static void bfs(int startNode) {
		Queue<Integer> que = new ArrayDeque<>();
		
		que.offer(startNode);
		isVisited[startNode] = true;
		
		while(!que.isEmpty()) {
			int current = que.poll();
			
			for(int next : list.get(current)) {
				if(isVisited[next])
					continue;
				
				que.offer(next);
				isVisited[next] = true;
				count++;
			}
		}
	}
	
	static void dfs(int currentNode) {
		isVisited[currentNode] = true;
		
		for(int next : list.get(currentNode)) {
			if(isVisited[next])
				continue;
			
			dfs(next);
			count++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		comCnt = Integer.parseInt(br.readLine().trim());
		pairCnt = Integer.parseInt(br.readLine().trim());
		
		//인접 리스트 생성
		list = new ArrayList<>();
		for(int com = 0; com <= comCnt; com++) {	//컴터 입력
			list.add(new ArrayList<>());
		}
		
		for(int link = 1; link <= pairCnt; link++) {	//연결 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		count = 0;
		isVisited = new boolean[comCnt+1];
		dfs(1);
		System.out.println(count);
	}
}
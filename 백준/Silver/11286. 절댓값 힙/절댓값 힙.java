import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2sec 256MB
 * 
 * 절댓값 힙은 두 연산을 지원한다
 * 	1. 배열에 정수를 넣는다
 * 	2. 배열에서 절댓값이 가장 작은 값을 출력, 제거한다.
 * 		절댓값의 최소가 여러개일 때는 가장 작은 수를 출력, 제거
 * 
 * 입력
 * 	1. 연산의 개수 commandCnt(1~100,000)
 * 	2~ 연산 정보(Integer 범위)
 * 		0이 아닌 수 : 배열에 입력값 추가
 * 		0 : 2번 연산
 * 
 * 출력
 * 	0이 주어진 회수만큼 출력(배열이 비어있는데 0이 입력된 경우 0 출력)
 * ===================================================
 * 절댓값을 기준으로 정렬하는 정렬 기준 객체 생성
 * 우선순위 큐에 적용
 */
public class Main {
	static int commandCnt;
	
	static PriorityQueue<Integer> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//절댓값 힙 생성
		queue = new PriorityQueue<>(new AbsHeap());
		
		//연산 수행
		commandCnt = Integer.parseInt(br.readLine().trim());
		for(int input = 1; input <= commandCnt; input++) {
			int command = Integer.parseInt(br.readLine().trim());
			
			if(command != 0) queue.offer(command);
			
			else {
				if(queue.isEmpty()) {	//비어있을 때 0이 들어오면 0 출력
					sb.append(0).append("\n");
					continue;
				}
				
				//우선순위 대로 출력
				sb.append(queue.poll()).append("\n");
			}
		}
		
		//출력
		System.out.println(sb);
		
		
		
	}
}

//정렬 기준 객체
class AbsHeap implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;	//절댓값이 같으면 크기 비교
		
		return Math.abs(o1) - Math.abs(o2);	//기본은 절대값비교
	}
	
}
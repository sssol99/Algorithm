import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14567 {
public static void main(String[] args) throws IOException {
	//입력부입니다
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer stk = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(stk.nextToken());
	int M = Integer.parseInt(stk.nextToken());
	int[] res = new int[N+1];
	int[] inD = new int[N+1];
	LinkedList<Integer>[] arr = new LinkedList[N+1];
	for(int i = 1 ; i <= N ; i++) {
		arr[i] = new LinkedList<>();
		
	}
	
	Queue<Integer> q = new LinkedList<Integer>();
	
	for(int i = 0 ; i < M ; i++) {
		stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());
		arr[start].add(end);
		inD[end]+=1;
	}
	//알고리즘 구현입니다 

	//진입차수가 0인것들부터 시작
	for(int i = 1 ; i <= N ; i++) {		
		if(inD[i] == 0) q.offer(i);	
		res[i] = 1; // 진입차수가 0이더라도 한 학기는 들어야  하니까 
	}
	

	//진입차수를 닿는곳마다 하나씩 낮춰서 0인곳으로 접근 while
	while(!q.isEmpty()) {
		int now = q.poll(); // 진입차수 0인것 빼기  (큐에는 진입차수가 0인것만 들어가있음) 
		
		for(int a : arr[now]) { 
			inD[a] -=1;// now 에서 뻗은 가지들 차수 1씩 빼기
			res[a] = res[now] +1; // 선수과목 수 갱신
			if(inD[a]==0) {
				q.offer(a); // 진입차수가 0이면 큐에 넣기
			}
		}
	}
	
	
	
	for(int i = 1 ; i <= N ; i++) {
		System.out.print(res[i]+" ");
	}
	
	
}
}

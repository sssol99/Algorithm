




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class dijikstra {
	
	static class Nodes implements Comparable<Nodes>{
		int start; //시작노드
		int weight; //가중치
		
	
		@Override
		public int compareTo(Nodes o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}


		public Nodes(int start, int weight) {
			super();
			this.start = start;
			this.weight = weight;
		}

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
				//입력부입니다
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int res = 0; //답 
				int N = Integer.parseInt(br.readLine()); // 도시의 개수
				int M = Integer.parseInt(br.readLine()); // 버스의 개수
				int arr[][] = new int[N][N];
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						arr[i][j] = -1; //버스비용이 0인 경우
					}
				}
				for(int i = 0 ; i < M ; i++) {
					StringTokenizer stk = new StringTokenizer(br.readLine());
					int start = Integer.parseInt(stk.nextToken())-1;
					int end = Integer.parseInt(stk.nextToken())-1;
					int weight = Integer.parseInt(stk.nextToken());
					
					if (arr[start][end]!=-1) { // 똑같은 버스 노선이 나왔을 경우 작은 값 넣기
						if (arr[start][end] < weight) continue; 
					}
					arr[start][end] = weight;
				}
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int START = Integer.parseInt(stk.nextToken())-1; // 출발지점 
				int END = Integer.parseInt(stk.nextToken())-1; // 도착지점
			

				Queue<Nodes> q= new PriorityQueue<Nodes>(); // 우선순위 큐 구현
				
				boolean[] ck = new boolean[N]; // 이미 들어간 곳 안가게 체크
				int[] minvalue = new int[N]; // 자신의 노드까지 최소 값 넣을 배열
				
				for(int i = 0 ; i < N ; i++) {
					minvalue[i] = Integer.MAX_VALUE; //자신의 노드까지 최소값 넣을 배열을 최대로 초기화
				}
				
				minvalue[START] = 0;
				
				q.offer(new Nodes(START,0)); //큐에 최소값 (시작할 노드) 넣기
				
				int cnt = 0;
				//다익스트라 시작
				while(!q.isEmpty()) {
					//최소노드 빼기
					Nodes cur = q.poll();
					//이미 체크된 노드면 다시 안 감
					if (ck[cur.start] == true) continue;				
					ck[cur.start] = true; //다시 자기한테 가면 안되니까 체크
		
					
					//최소값 갱신
					for(int i = 0 ; i < N ; i++) {
						//이미 체크된 노드면 다시 안 감
						if (ck[i] == true) continue;
						//버스가 안다니는곳이면 안 감
						if (arr[cur.start][i] == -1) continue;
						//비용 업데이트
						if(arr[cur.start][i] + minvalue[cur.start] <= minvalue[i]) {
							minvalue[i] = arr[cur.start][i] + minvalue[cur.start];
							q.offer(new Nodes(i,minvalue[i]));
						}
					}
				
				}
				
				
				System.out.println(minvalue[END]);			

	}

}

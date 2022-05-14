import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589 {
	static int GA; // 가로길이
	static int SE; // 세로길이 
	static int[][] arr; // 알파벳 저장할 배열
	static boolean[][] ck; // 전체 방문 체크
	static boolean[][] arrck; // 한 점에서의 방문 체크
	static int[][] go; // 한 점에서의 이동값 거리
	
	static int[] dx = {-1,0,1,0}; //4방탐색
	static int[] dy = {0,1,0,-1}; //4방탐색
	static int max = 0; // 최대값 (정답저장)

	public static void main(String[] args) throws IOException {
		//입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		 GA = Integer.parseInt(stk.nextToken());
		 SE = Integer.parseInt(stk.nextToken());
		 arr = new int[GA][SE];
		 ck = new boolean[GA][SE];
		 
		 for(int i = 0 ; i < GA ; i++) {
			 String tmp = br.readLine();
			 for(int j = 0 ; j < SE ; j++) {
				 arr[i][j] = tmp.charAt(j);
			 }
		 }
		
		 //알고리즘 구현 시작입니다
		 for(int i = 0 ; i < GA ; i++) {			
			 for(int j = 0 ; j < SE ; j++) {
				 if(arr[i][j]=='W') continue; // 바다 만나면 continue;
				 if(ck[i][j])continue; // 이미 방문했으면 continue;
				 
				 ck[i][j] = true; // 방문 체크
				 go = new int[GA][SE]; //한 점에서의 이동값 거리 초기화
				 arrck = new boolean[GA][SE]; // 한 점에서의 방문 체크 초기화
				 BFS(i,j); //BFS 시작	 
			 }
		 }
		 System.out.println(max);		
	}


	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		int tmp[] = {i,j};
		q.offer(tmp); // 초기값 큐에 넣기
		arrck[i][j] = true; // 초기 방문체크!!!!!!이거 안해서 한번 틀림 ㅠㅠ
	
		while(!q.isEmpty()) {
			tmp = q.poll();				
			for(int k = 0 ; k < 4 ; k++) {
				int ni = tmp[0] + dx[k];
				int nj = tmp[1]+dy[k];
				
				if(ni<0 | ni>=GA | nj <0 | nj >=SE) continue; //범위 벗어나면 out
				if (arrck[ni][nj]) continue;  // 이미 방문한 곳이면 out
				if(arr[ni][nj]=='W') continue; // 바다면 out
				
				arrck[ni][nj] = true; // 방문체크
				int[] ntmp = {ni,nj}; 
				q.offer(ntmp); //큐에 넣기 -> 한번에 넣는 방법이 있었던거 같은데 까먹음...없나?
				int now = go[tmp[0]][tmp[1]]+1; // 시간 계산
				if(now> go[ni][nj]) { //시간이 현재 있는 값보다 크면
					go[ni][nj] = now ; // 시간 바꿔치기(+1)
					if(now > max) max = now; // 최대값 비교
				}				
			}
		}		
	}
}

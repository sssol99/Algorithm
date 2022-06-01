import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ6593 {
	// 층,행,열,움직인 거리 저장 위한 클래스
	public static class Node{
		int L;
		int C;
		int R;
		int move;
		
		public Node(int l, int c, int r, int move) {
			super();
			L = l;
			C = c;
			R = r;
			this.move = move;
		}
	}

	static char sangbum[][][]; //빌딩 정보 저장할 배열
	static boolean ck[][][]; //간 곳인지 체크하기 위한 배열
	static int dl[] = {1,-1,0,0,0,0};
	static int dr[] = {0,0,0,0,1,-1};
	static int dc[] = {0,0,1,-1,0,0};
	static Node start; // 시작노드 저장하기 위한 변수
	static Node end; // 끝노드 저장하기 위한 변수
	static int L; //층
	static int C; //행
	static int R; //열
	static StringBuilder bres = new StringBuilder(); // 답 출력하기 위한 변수
	
	public static void main(String[] args) throws IOException {
		//입력부입니다
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		while(true) {
			String tmp;
			stk = new StringTokenizer(br.readLine());
			L = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			R = Integer.parseInt(stk.nextToken());
			
			if(L==0 && C==0 && R ==0) {
				System.out.println(bres);
				break;
			}
			sangbum = new char[L][C][R];
			ck = new boolean[L][C][R];
			
			for(int i = 0 ; i < L ; i++) {
				if(i!=0)tmp = br.readLine(); // 엔터 받기위함 - tmp 없이 그냥 엔터만 받으면 안됨
				for(int j = 0 ; j < C ; j++ ) {
					tmp = br.readLine(); // 엔터 받기위함 - tmp 없이 그냥 엔터만 받으면 안됨
					for(int k = 0 ; k < R ; k++) {
						sangbum[i][j][k] = tmp.charAt(k);
						if(sangbum[i][j][k]=='S') start = new Node(i,j,k,0);
						if(sangbum[i][j][k]=='E') end = new Node(i,j,k,0);
					}
				}
			}				 
		 BFS();	
		}		
	}
	
	//알고리즘 구현 시작입니다
	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);
		ck[start.L][start.C][start.R] = true; // 첫번째 시작 노드 방문 체크
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			//처음에 여기서 방문체크했으나, 그렇게 하면 동시에 접근하는 다른 노드들은 방문 체크가 안된걸로 인식하므로 메모리 초과
			if(sangbum[tmp.L][tmp.C][tmp.R]=='E') {
				//처음엔 바로 return 하면 안되는 줄 알았는데, 어차피 BFS에서 제일 처음 나온 게 제일 빠른 경로이므로 상관 x
				bres.append("Escaped in "+tmp.move+" minute(s).\n"); // 한번에 뽑기 위해 stringbuilder append
				return;
			}
			
			for(int i = 0 ; i < 6 ; i++) { // 동서남북상하
				int nextL = tmp.L+dl[i];
				int nextC = tmp.C+dc[i];
				int nextR = tmp.R+dr[i];				
			
				if(nextL>=0 && nextR>=0 && nextC>=0 && nextL<L && nextR <R && nextC < C) { // 지나갈수있는지
					//처음엔 ck를 int 로 뒀음 , 방문한 곳을 다른 곳이 방문할 때 방문 안 된 곳으로 둬야 한다고 생각했기 때문
					//하지만 BFS는 그럴 필요 없음
					if(ck[nextL][nextC][nextR]) continue; // 이미 방문된 곳이면 continue
					if(sangbum[nextL][nextC][nextR] == '#') continue; //갈 수 없는 곳이면 continue				
					q.offer(new Node(nextL,nextC,nextR,tmp.move+1)); // 큐에 넣기
					ck[nextL][nextC][nextR] = true; //방문 체크
				}
			}			
		}	
		bres.append("Trapped!\n"); // 한번에 뽑기 위해 stringbuilder append
	}
}

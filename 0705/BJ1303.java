import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1303 {
	static char[][] arr;
	static boolean[][] ck;
	static int N;
	static int M;
	static int tmpn;
	static int res1 = 0;
	static int res2 = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk= new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		
		arr = new char[N][M];
		ck = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			String sold = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = sold.charAt(j);
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j++) {
				
				if(ck[i][j]==true) continue;
				tmpn = 1;
				
				if(arr[i][j]=='W') {
					ck[i][j] = true;
					DFS(i,j,'W');
					res1+= tmpn*tmpn;
				}else {
					ck[i][j] = true;
					DFS(i,j,'B');
					res2+= tmpn*tmpn;
				}			
			}
		}	
		System.out.println(res1 +" "+ res2);	
	}
	
	private static void DFS(int I, int J, char solder) {
		
		for(int i = 0 ; i < 4 ; i++) {
			int nexti = dx[i]+I;
			int nextj = dy[i]+J;
			
			if(nexti <0 | nexti >= N | nextj <0 | nextj >= M) continue;
			if(ck[nexti][nextj]) continue;
			
			if(arr[nexti][nextj]==solder) {
				ck[nexti][nextj] = true;
				tmpn++;
				DFS(nexti,nextj,solder);
			}	
		}		
	}
}

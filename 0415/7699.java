import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7699 {
	static int[][] arr;
	static boolean[][] ck;
	static boolean[] alp;
	static int max;
	static int R;
	static int C;

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TK = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <=TK ; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			arr = new int[R][C];
			ck = new boolean[R][C];
			max = 0;
			alp = new boolean[26];

			for(int i = 0 ; i < R ; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0 ; j < C ; j++) {
					arr[i][j] = tmp[j];
				}
			}
			ck[0][0] = true;
			alp[arr[0][0]-'A'] = true;
			
			//알고리즘 구현 시작입니다
			DFS(0,0,1);

			System.out.println("#"+t+" "+max);
		}
	}

	private static void DFS(int r, int c , int sum) {
		if(max < sum) max=  sum;

		for(int k = 0 ; k < 4 ; k++) {
			int nr = r+dr[k]; // 다음 r칸
			int nc = c+dc[k]; // 다음 c칸		
			if(nr >=0 & nr < R & nc >= 0 &nc < C) { // 예외체크
				if (!alp[arr[nr][nc]-'A'] ) { // 이미 간 알파벳인지 체크
					if(!ck[nr][nc]) { // 이미 간 경로인지 체크
						alp[arr[nr][nc]-'A'] = true; // 알파벳 체크
						ck[nr][nc] = true; // 경로 체크
						DFS(nr,nc,sum+1);			
						alp[arr[nr][nc]-'A'] = false; // 알파벳 체크 해제
						ck[nr][nc] = false; //경로 체크 해제
					}
				}
			}
		}
	}
}


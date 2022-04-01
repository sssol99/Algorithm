package webx0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA3282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TK = Integer.parseInt(br.readLine());  // 테스트 케이스의 수

		for(int t = 1 ; t = TK ; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());  // 물건의 개수
			int K = Integer.parseInt(stk.nextToken());  // 가방의 부피
			int[][] dp = new int[N+1][K+1];

			//알고리즘 구현입니다
			for(int i = 1 ; i =N ; i++) {		
				stk = new StringTokenizer(br.readLine());
				int V = Integer.parseInt(stk.nextToken()); // 물건의 부피
				int C = Integer.parseInt(stk.nextToken()); // 물건의 가치
				
				for(int j = 1 ; j=K ; j++) {			
					if (j  V) {  // 아직 물건을 넣을 수 없을 때 ( 가방에 넣을 수 있는 부피보다 현재 물건 부피가 더 클 때)
						dp[i][j] = dp[i-1][j];
					}else { // 물건을 넣을 수 있을 때 (가방에 넣을 수 있는 부피보다 현재 물건 부피가 작거나 같을 때)
						dp[i][j] = Integer.max(dp[i-1][j-V]+C, dp[i-1][j]);  // 넣을 수 있는 최대물건 + 지금 물건 가치 vs 지금물건 안넣기				
					}	
				}
			}
			System.out.println(#+t+ +dp[N][K]);
		}
	}
}

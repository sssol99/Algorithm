package study0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class BJ2573 {

	static int[][] arr;

	static int N;
	static int M;
	static int[][] map;
	public static void makeset() {
	
		for(int i = 0; i < N ; i++) {	
			for(int j = 0 ; j < M ; j++) {

				if(arr[i][j] > 0) map[i][j] = i*10+j;
				
			}
		}
	}

	public static boolean union(int a, int b) {
		int roota = findroot(a/10,a%10);
		int rootb = findroot(b/10,b%10);
		
		if(roota==rootb) return true;
		else return false;
	}

	public static int findroot(int i, int j) {
		if(map[i][j] == i*10+j) return map[i][j];
		
		return map[i][j] = findroot(map[i][j] /10 , map[i][j] %10);
				
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken()); // 세로줄(행)개수
		M = Integer.parseInt(stk.nextToken()); // 가로줄(열)개수
		arr = new int[N][M];
		map = new int[N][M];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		for(int i = 0; i < N ; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		makeset();
		while(min !=0) {
			//4방 탐색
			for(int i = 0; i < N ; i++) {		
				int water = 0;
				for(int j = 0 ; j < M ; j++) {
					 water = 0;
					if (arr[i][j] > 0) { // 빙하값이 있으면
						
						for(int a = 0 ; a < 4 ; a++) {
							if(i+dx[a] >=0 && i+dx[a] < N && j+dy[a] >=0 && j+dy[a] < M) {
								if (arr[i+dx[a]][j+dy[a]] == 0) water++;
							}
							
						}
						
					}
					if(arr[i][j] - water <= 0) {
						arr[i][j] = 0;						
					}
					else arr[i][j] = arr[i][j] - water;
				}
			}

			

			//union으로 확인
			
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	static int arr[][];
	
	//static boolean ck[][];
	static int white; //하양갯수저장
	static int blue; //파랑갯수저장
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		white = 0; //하양갯수저장
		blue = 0; //파랑갯수저장
		//ck = new boolean[N][N];
		arr = new int[N][N];

		for(int i = 0 ; i < N ; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		//알고리즘 구현입니다

		DFS(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void DFS(int x, int y, int n) {
		int tmp = 0;
		for(int i = x ; i < x+n ; i++) {
			for(int j = y ; j < y+n ; j++){
				tmp+=arr[i][j];
			}
		}

		if(tmp == n*n) {
			blue++;
			return;
		}else if(tmp==0) {
			white++;
			return;
		}else {
			DFS(x,y,n/2); //2사분면
			DFS(x,y+(n/2),n/2);//3사분면
			DFS(x+(n/2),y,n/2);//1사분면
			DFS(x+(n/2),y+(n/2),n/2);//4사분면
		}


	}

}

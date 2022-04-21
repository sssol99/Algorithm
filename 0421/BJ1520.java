import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1520 {

	/*참조
	 * https://dev-nomad.com/m/22
	 */


	static int I;
	static int J;
	static int arr[][];
	static int ck[][];

	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {

		//입력부입니다.	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		I = Integer.parseInt(stk.nextToken());
		J = Integer.parseInt(stk.nextToken());
		arr = new int[I][J];
		ck = new int[I][J];
		
		for(int i = 0 ; i < I ; i ++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < J ; j++) {
				arr[i][j] =  Integer.parseInt(stk.nextToken());
				ck[i][j] = -1;
			}
		}
		//알고리즘 구현 시작입니다.


		System.out.println(memo(0,0));

	}


	private static int memo(int r, int c) {
		if(r==I-1 & c==J-1) { // 끝에 도달시 (최초 ) -> 이때부터 양수값이 생기기 시작
			return 1;
		}

		if(ck[r][c] != -1) return ck[r][c]; // 이미 방문한 곳은 갈 필요 없음. 양수값이 나왔다면 도달경로가 있다는 뜻이므로 리턴

		ck[r][c] = 0;

		for(int k = 0; k<4 ; k++) { // 4방향 탐색
			int ni = r+di[k]; // nexti
			int nj = c+dj[k]; // nextj
			if(ni < 0 | ni >=I | nj < 0 | nj >= J ) continue; //범위 벗어나면 continue	
			if(arr[r][c] > arr[ni][nj]) { // 내리막길이 맞는지 체크
				ck[r][c] += memo(ni,nj); // ck[0][0]에 경로값이 쌓이게 함(하향식)
			}

		}

		return ck[r][c];

	}
}

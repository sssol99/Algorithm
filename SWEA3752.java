import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3752 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력부
		int TK = Integer.parseInt(br.readLine());	
		for(int t = 1 ; t <= TK ; t++) {
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer stk = new StringTokenizer(br.readLine());

			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
				sum+=arr[i];
			}

			//여기서부터 문제해결입니다
			
			//dp 배열은 0부터 max합까지를 인덱스로 가지고 있는 배열입니다.
			int[] dp = new int[sum+1];
			//dp 값을 -1로 초기화해줍니다 (아래에서 A.막 교체한걸 continue 하기 위함입니다)
			for(int i = 0 ; i <= sum ; i++) {
				dp[i] = -1;
			}


			
			for(int i = 0 ; i < N ; i++) {	
				//B. 아직 채워지지 않은 인덱스라면, arr[i]값을 인덱스로 dp에 채워 줍니다.
				if (dp[arr[i]] == -1) dp[arr[i]] = i;
				for(int j = 0 ; j <= sum ; j++) {
					//(A. 막 교체한것에 값을 더하면 안되니, i값보다 작을 때를 첫번째 조건으로
					// B. 값이 있어야 arr[i]값을 더해 다음 값을 만들 수 있으니 -1보다 클 때를 두 번째 조건으로
					if(dp[j] < i && dp[j] >-1) {
						//여기서 
						//if(dp[j+arr[i]] == -1) 
							dp[j+arr[i]] = i;

					}

				}
			}
			int res = 0;
			for(int i = 0 ; i <= sum ; i++) {
				if(dp[i] >= 0) res++;

			}

			System.out.printf("#%d %d\n",t,res+1);
		}

	}

}

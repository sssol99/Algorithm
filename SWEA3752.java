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

			int[] dp = new int[sum+1];
			for(int i = 0 ; i <= sum ; i++) {
				dp[i] = -1;
			}


			//i개 맞췄을때
			for(int i = 0 ; i < N ; i++) {	
				if (dp[arr[i]] == -1) dp[arr[i]] = i;
				for(int j = 0 ; j <= sum ; j++) {

					if(dp[j] < i) {
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

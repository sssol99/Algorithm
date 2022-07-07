import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BJ5557 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][21];
		int[] arr = new int[N+1];
		String tmp = br.readLine();
		tmp = tmp.replace(" ", "");
		for(int i = 1 ; i <= N; i++){
			arr[i] = tmp.charAt(i-1)-48;
		}
		
		dp[1][arr[1]] = 1;
		
		for(int i = 2 ; i <=N ; i++) {
			for(int j = 0 ; j <=20 ; j++) {
			
				if(dp[i-1][j] != 0) {
					int plus = j+arr[i];
					int minus = j-arr[i];
					
					if(plus <=20) dp[i][plus] += dp[i-1][j];
					if(minus >=0) dp[i][minus] += dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-1][arr[N]]);
	}

}

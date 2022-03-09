import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3752 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�Էº�
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

			//���⼭���� �����ذ��Դϴ�
			
			//dp �迭�� 0���� max�ձ����� �ε����� ������ �ִ� �迭�Դϴ�.
			int[] dp = new int[sum+1];
			//dp ���� -1�� �ʱ�ȭ���ݴϴ� (�Ʒ����� A.�� ��ü�Ѱ� continue �ϱ� �����Դϴ�)
			for(int i = 0 ; i <= sum ; i++) {
				dp[i] = -1;
			}


			
			for(int i = 0 ; i < N ; i++) {	
				//(B. ���� ä������ ���� �ε������, arr[i]���� �ε����� dp�� ä�� �ݴϴ�._
				if (dp[arr[i]] == -1) dp[arr[i]] = i;
				for(int j = 0 ; j <= sum ; j++) {
					//(A. �� ��ü�ѰͿ� ���� ���ϸ� �ȵǴ�, i������ ���� ���� ù��° ��������)
					// (B. ���� �־�� arr[i]���� ���� ���� ���� ���� �� ������ -1���� Ŭ ���� �� ��° ��������)
					if(dp[j] < i && dp[j] >-1) {
						// (C. �̹� ä���� ���� �մ��, A���� ������ �ǳʶپ� ������ ���� �� ä���� �ε����� �� i�ο� )
						if(dp[j+arr[i]] == -1) dp[j+arr[i]] = i;

					}

				}
			}
			
			//�ε����� ä���� �κ��� �������� ��
			int res = 0;
			for(int i = 0 ; i <= sum ; i++) {
				if(dp[i] >= 0) res++;

			}
			//0���� ��쵵 ������, 1�� �߰�
			System.out.printf("#%d %d\n",t,res+1);
		}

	}

}

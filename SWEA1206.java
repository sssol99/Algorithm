import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		//입력부입니다 
		for(int t = 1 ; t <= 10 ; t++) {
			int N = Integer.parseInt(br.readLine()); // 케이스 길이
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int res = 0; // 답 입력받을 변수
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			//여기부터 구현입니다
			for(int i = 2 ; i < N-2 ; i++) {
				int[] tmp = new int[4];
				tmp[0] = arr[i-1];
				tmp[1] = arr[i-2];
				tmp[2] = arr[i+1];
				tmp[3] = arr[i+2];
				
				Arrays.sort(tmp);
				if(tmp[3] < arr[i]) res+= arr[i] - tmp[3];
			}
			
			System.out.printf("#%d %d\n",t,res);
		}
	}
}

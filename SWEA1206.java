import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		//�Էº��Դϴ� 
		for(int t = 1 ; t <= 10 ; t++) {
			int N = Integer.parseInt(br.readLine()); // ���̽� ����
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int res = 0; // �� �Է¹��� ����
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			//������� �����Դϴ�
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

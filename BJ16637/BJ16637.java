import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int max; // 최대값을 담기 위한 변수입니다
	static char[] arr;
	
	public static void DFS(int idx, int sum) {
		//끝까지 계산한 경우
		if (idx >= N) { //N과 같은 경우 체크 못해서 한번 틀림
			if (max < sum) max = sum;
		}
		
		//아직 끝이 아닌경우 계속 DFS
		else {
			//idx+2를 해주는 이유는 연산자도 끼어있기 때문에 숫자와 연산자를 다 뛰어넘어야 하기 때문		
			//첫번째 갈림길 - 괄호 없음
			DFS(idx+2,cal(sum,arr[idx]-'0',arr[idx-1]));
			//두번째 갈림길 - 괄호 있음
			if(idx+2 < N) {
				int tmp = cal(arr[idx]-'0',arr[idx+2]-'0',arr[idx+1]);
				DFS(idx+4,cal(sum,tmp,arr[idx-1]));
			}		
		}	
	}
	
	//필요함수2 - 연산함수입니다
	public static int cal(int i,int j , char op) {
		if(op=='*') {
			return i*j;
		}else if(op=='+') {
			return i+j;
		}else{
			return i-j;
		}
	}

	public static void main(String[] args) throws IOException {
		//입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String tmp = br.readLine();
		arr = new char[N];//수식을 담기 위한 배열입니다
		arr = tmp.toCharArray();
		max = Integer.MIN_VALUE; //음수 최저점을 설정 안해서 두번 틀림 -> 답은 음수가 나올 수도 있음
		//알고리즘 구현입니다	
		DFS(2,arr[0]-'0');	
		System.out.println(max);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2629 {
	static ArrayList<Integer> weight;
	static int chuN;
	static int[] chus;
	static int guN;
	static int[] gus;
	static boolean[][] gusck;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer stk = new StringTokenizer(br.readLine());
		chuN = Integer.parseInt(stk.nextToken()); // 추의 개수
		
		stk = new StringTokenizer(br.readLine());
		chus = new int[chuN]; // 추의 무게들 저장할 배열 ( 작은 순서대로 )
		for(int i = 0 ; i< chuN ; i++) {
			chus[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine());
		guN = Integer.parseInt(stk.nextToken()); // 구슬의 개수
		
		stk = new StringTokenizer(br.readLine());
		gus = new int[guN]; // 구슬의 무게들 저장할 배열 ( 작은 순서대로 )
		
		gusck = new boolean[chuN+1][40001]; // (최대무게) , 2차원 배열로 만드는 이유는 DFS에서 이미 체크한거 넘길려고(-값이 있으므로)
		for(int i = 0 ; i< guN ; i++) {
			gus[i] = Integer.parseInt(stk.nextToken());
		}
		
		//알고리즘 구현입니다
		DFS(0,0);
		
		for(int i = 0 ; i < guN ; i++) {
			if(gusck[chuN][gus[i]] == true) System.out.print("Y"+" "); //체크되어 있으면 Y 출력
			else System.out.print("N"+" "); //체크되어있지 않으면 N 출력
		}
	}

	private static void DFS(int lv, int sum) {
	
			if(gusck[lv][sum]) return; // 이미 체크되어 있으면 리턴
			
			gusck[lv][sum] = true; // 값 저장
			
			if(lv==chuN) return; // 끝까지 갔을 경우 값 대조하고 리턴
					
			
			DFS(lv+1,sum+chus[lv]); // 무게추 더하기
			DFS(lv+1,sum); // 무게추 안넣기
			DFS(lv+1,Math.abs(sum-chus[lv])); // 무게추 빼기  - abs를 하는 이유는 indexout때문 / abs를 하면 안될 거라고 생각했는데 50라인에서 걸러 주므로 ㄱㅊ	
					
	}
}

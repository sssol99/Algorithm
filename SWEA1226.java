import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1226 {
	static int[] di = {-1,0,1,0}; // 4방위 행
	static int[] dj = {0,1,0,-1}; // 4방위 열
	static int[][] arr; // 미로 담을 배열
	static int[][] ck;
	static int flag = 0;
	
	public static void BFS(int i , int j) {
		if(arr[i][j] == 3) {
			flag = 1;
		}
		
		else {
			for(int k = 0 ; k < 4 ; k++) {
				if(arr[i+di[k]][j+dj[k]] == 1) continue;
				
				if(ck[i+di[k]][j+dj[k]] == 0) {			
					ck[i+di[k]][j+dj[k]] = 1;
					BFS(i+di[k],j+dj[k]);
				}
				
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 넘버
		int startx = 0;
		int starty = 0;

		for(int t = 0 ; t  < 10 ; t++) {
			int TKN = Integer.parseInt(br.readLine()); 
			arr = new int[16][16];
			ck = new int[16][16];
			flag = 0;

			//미로 배열 만들기
			for(int i = 0 ; i <16 ; i++) {
				String tmp[] =br.readLine().split("");
				for(int j = 0 ; j < 16 ; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
					if(arr[i][j] == 2) {
						startx = i;
						starty = j;
					}
				}

			}

			BFS(startx,starty);
			
			System.out.printf("#%d %d",TKN,flag);

		}


	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack stack = new Stack();
		for(int n = 0 ; n < N ; n++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String order = stk.nextToken(); 
			switch (order) {	
			case "push":
				int tmp = Integer.parseInt(stk.nextToken());
				stack.add(tmp);
				break;
			case "pop":
				if (stack.size()!=0) System.out.println(stack.pop());
				else System.out.println(-1);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.size()==0) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if (stack.size()!=0) System.out.println(stack.peek());
				else System.out.println(-1);
				break;
			}		
		}
	}
}

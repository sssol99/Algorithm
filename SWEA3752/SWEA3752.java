import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3752 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ì…ë ¥ë¶€
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

<<<<<<< HEAD:SWEA3752.java
			//¿©±â¼­ºÎÅÍ ¹®Á¦ÇØ°áÀÔ´Ï´Ù
			
			//dp ¹è¿­Àº 0ºÎÅÍ maxÇÕ±îÁö¸¦ ÀÎµ¦½º·Î °¡Áö°í ÀÖ´Â ¹è¿­ÀÔ´Ï´Ù.
			int[] dp = new int[sum+1];
			//dp °ªÀ» -1·Î ÃÊ±âÈ­ÇØÁİ´Ï´Ù (¾Æ·¡¿¡¼­ A.¸· ±³Ã¼ÇÑ°É continue ÇÏ±â À§ÇÔÀÔ´Ï´Ù)
=======
			//ì—¬ê¸°ì„œë¶€í„° ë¬¸ì œí•´ê²°ì…ë‹ˆë‹¤
			
			//dp ë°°ì—´ì€ 0ë¶€í„° maxí•©ê¹Œì§€ë¥¼ ì¸ë±ìŠ¤ë¡œ ê°€ì§€ê³  ìˆëŠ” ë°°ì—´ì…ë‹ˆë‹¤.
			int[] dp = new int[sum+1];
			//dp ê°’ì„ -1ë¡œ ì´ˆê¸°í™”í•´ì¤ë‹ˆë‹¤ (ì•„ë˜ì—ì„œ A.ë§‰ êµì²´í•œê±¸ continue í•˜ê¸° ìœ„í•¨ì…ë‹ˆë‹¤)
>>>>>>> 5e08d745ba0cde7430aee4c947cb766c3e097e02:SWEA3752/SWEA3752.java
			for(int i = 0 ; i <= sum ; i++) {
				dp[i] = -1;
			}


			
			for(int i = 0 ; i < N ; i++) {	
<<<<<<< HEAD:SWEA3752.java
				//B. ¾ÆÁ÷ Ã¤¿öÁöÁö ¾ÊÀº ÀÎµ¦½º¶ó¸é, arr[i]°ªÀ» ÀÎµ¦½º·Î dp¿¡ Ã¤¿ö Áİ´Ï´Ù.
				if (dp[arr[i]] == -1) dp[arr[i]] = i;
				for(int j = 0 ; j <= sum ; j++) {
					//(A. ¸· ±³Ã¼ÇÑ°Í¿¡ °ªÀ» ´õÇÏ¸é ¾ÈµÇ´Ï, i°ªº¸´Ù ÀÛÀ» ¶§¸¦ Ã¹¹øÂ° Á¶°ÇÀ¸·Î
					// B. °ªÀÌ ÀÖ¾î¾ß arr[i]°ªÀ» ´õÇØ ´ÙÀ½ °ªÀ» ¸¸µé ¼ö ÀÖÀ¸´Ï -1º¸´Ù Å¬ ¶§¸¦ µÎ ¹øÂ° Á¶°ÇÀ¸·Î
					if(dp[j] < i && dp[j] >-1) {
						//¿©±â¼­ 
						//if(dp[j+arr[i]] == -1) 
=======
				//B. ì•„ì§ ì±„ì›Œì§€ì§€ ì•Šì€ ì¸ë±ìŠ¤ë¼ë©´, arr[i]ê°’ì„ ì¸ë±ìŠ¤ë¡œ dpì— ì±„ì›Œ ì¤ë‹ˆë‹¤.
				if (dp[arr[i]] == -1) dp[arr[i]] = i;
				for(int j = 0 ; j <= sum ; j++) {
					//(A. ë§‰ êµì²´í•œê²ƒì— ê°’ì„ ë”í•˜ë©´ ì•ˆë˜ë‹ˆ, iê°’ë³´ë‹¤ ì‘ì„ ë•Œë¥¼ ì²«ë²ˆì§¸ ì¡°ê±´ìœ¼ë¡œ
					// B. ê°’ì´ ìˆì–´ì•¼ arr[i]ê°’ì„ ë”í•´ ë‹¤ìŒ ê°’ì„ ë§Œë“¤ ìˆ˜ ìˆìœ¼ë‹ˆ -1ë³´ë‹¤ í´ ë•Œë¥¼ ë‘ ë²ˆì§¸ ì¡°ê±´ìœ¼ë¡œ
					if(dp[j] < i && dp[j] >-1) {
						//ì—¬ê¸°ì„œ 
						if(dp[j+arr[i]] == -1) 
>>>>>>> 5e08d745ba0cde7430aee4c947cb766c3e097e02:SWEA3752/SWEA3752.java
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

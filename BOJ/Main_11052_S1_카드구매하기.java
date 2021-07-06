package baekjoon;

/**
예외
6
1 5 6 1 1 1
→ 15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_S1_카드구매하기 {
	static int n;
	// idx번째에 저장되는 값 : idx개를 구매할 때 가장 비싸게 주고 살 수 있는 가격
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		dp = new int[n + 1];
		int temp = n;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= n; i++) {
			for(int j=1; j<=i/2; j++) {
				dp[i] = Math.max(dp[i-j]+dp[j], dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
}

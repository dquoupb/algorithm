package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_S3_계단오르기 {
	static int n;
	static int[] stairs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		stairs = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
			if(i==1)
				dp[i] = stairs[1];
			else if(i==2)
				dp[i] = stairs[1]+stairs[2];
			else if(i==3)
				dp[i] = Math.max(stairs[1]+stairs[3], stairs[2]+stairs[3]);
			else
				dp[i] = Math.max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i]);
		}
		System.out.println(dp[n]);
	}
}

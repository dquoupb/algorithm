package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			int[] price = new int[4]; // 가격 저장
			int[] dp = new int[12]; // dp로 저장

			// 가격 입력 받기
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());

			// 월 별 이용일 수 입력 받기
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 12; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) { // 이용 일수가 0일이면 이전이랑 가격 같은 것
					dp[i] = i == 0 ? 0 : dp[i - 1];
				} else { // 이용 일 수가 0일이 아니면 이전 최소값+현재 최소 값 해주어야 함
					// 현재 계산해보려고 하는 월에서 나올 수 있는 최소 값
					int tempMin = Math.min(temp * price[0], price[1]);
					dp[i] = i == 0 ? tempMin : dp[i - 1] + tempMin;
					if (i >= 2) {
						int third = i == 2 ? 0 : dp[i - 3];
						dp[i] = Math.min(dp[i], third+price[2]);
					}
				}
			}

			/*System.out.println("dp출력");
			for(int i=0; i<12; i++) {
				System.out.print(dp[i]+" ");
			}System.out.println();*/
			
			System.out.printf("#%d %d\n", test_case, Math.min(dp[11], price[3]));
		}
	}

}

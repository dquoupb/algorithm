package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int n, m, c, max;
	static int arr[][], start[][];
	static boolean select[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			start = new int[n][n - m + 1];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int profit = 0, profitX=0, profitY=0; // 수익 최대값 구하기 위한 숫자
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					max = 0;
					select = new boolean[m];
					subset(0, i, j);
					if(profit<start[i][j]) {
						profit = start[i][j];
						profitX = i;
						profitY = j;
					}
				}
			}
			// start 배열에 각각 행으로 벌꿀 통 최대값 저장
			
			// start 배열에서 최대값인것 추출
			int profitSec = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					if(start[i][j]<=profit) {
						if(profitX == i) {
							if(profitY+m<=j)
								profitSec = Math.max(profitSec, start[i][j]);
						}
						else
							profitSec = Math.max(profitSec, start[i][j]);
					}
				}
			}

			/*for(int i=0; i<n; i++) {
				for(int j=0; j<=n-m; j++) {
					System.out.print(start[i][j]+" ");
				}System.out.println();
			}
			System.out.println(profit);
			System.out.println(profitSec);*/
			int result = profit+profitSec;
			System.out.println("#" + tc + " "+result);
		}
	}

	// 묶은 무리 안에서 부분집합으로 최대합 찾아냄
	static void subset(int idx, int x, int y) {
		if (idx == m) {
			int sum = 0, value = 0;
			for (int i = 0; i < m; i++) {
				if (select[i]) {
					sum += arr[x][y + i];
					value += (arr[x][y + i]) * (arr[x][y + i]);
				}
			}
			if (sum <= c && max < value) {
				max = value;
				start[x][y] = value;
			}
			return;
		}

		select[idx] = true;
		subset(idx + 1, x, y);
		select[idx] = false;
		subset(idx + 1, x, y);
	}
}

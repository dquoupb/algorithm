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

			// start 배열에는 해당 칸을 시작으로 m칸까지 선택했을 때 추출할 수 있는 최대 이익을 저장한 배열이다.
			// 그래서 start[n][n-m]칸으로 구성되어 있다!
			int profit = 0, profitX=0, profitY=0; // 수익 최대값, 수익 최대값의 위치 인덱스
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
			
			// start 배열에서 최대값인 것 추출
			int profitSec = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					if(start[i][j]<=profit) {
						if(profitX == i) { // 최대 수익이 선택된 행과 같은 행에 있을 경우 겹치지 않게 계산해야 함
							if(profitY + m <= j)
								profitSec = Math.max(profitSec, start[i][j]);
						}
						else // 최대 수익이 선택된 행과 다른 행에 있을 경우에는 그냥 나머지 행에서 최대값 구해오면 됨
							profitSec = Math.max(profitSec, start[i][j]);
					}
				}
			}

			// 확인
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

	// 선택한 m개의 벌꿀 통 안에서 부분집합으로 c를 넘지 않고 이익이 최대인 구성 첮아서 start 맴에 저장함
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

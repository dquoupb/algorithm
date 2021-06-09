package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int n, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			ans = Integer.MAX_VALUE;
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			isSelected = new boolean[n];

			// 입력 받기
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0,0);
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}

	static private void combination(int idx, int start) {
		if (idx == n / 2) {
			int result = solve();
			ans = Math.min(ans, result);
			return;
		}
		for (int i = start; i < n; i++) {
			isSelected[i] = true;
			combination(idx + 1, i + 1);
			isSelected[i] = false;
		}
	}
	
	static private int solve() {
		ArrayList<Integer> Afood = new ArrayList<>();
		ArrayList<Integer> Bfood = new ArrayList<>();
		
		// A음식과 B음식으로 나누기
		for(int i=0; i<n; i++) {
			if(isSelected[i]) 
				Afood.add(i);
			else
				Bfood.add(i);
		}
		
		int a = 0, b = 0;
		
		// 각 음식의 시너지 합 구하기
		for(int i=0; i<Afood.size()-1; i++) {
			for(int j=i; j<Afood.size(); j++) {
				a+=arr[Afood.get(i)][Afood.get(j)];
				a+=arr[Afood.get(j)][Afood.get(i)];
				b+=arr[Bfood.get(i)][Bfood.get(j)];
				b+=arr[Bfood.get(j)][Bfood.get(i)];
			}
		}
		
		return Math.abs(a-b);
	}
}

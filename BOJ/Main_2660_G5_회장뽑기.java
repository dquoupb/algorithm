package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2660_G5_회장뽑기 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i!=j)
					arr[i][j] = 99999;
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			if(temp1 == -1 && temp2 == -1)
				break;
			arr[temp1][temp2] = arr[temp2][temp1] = 1;
			
		}
		
		// 제대로 입력됐는지 확인
		/*for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}*/
		
		//경출도
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j])
						arr[i][j]=arr[i][k]+arr[k][j];
				}
			}
		}
		
		// 제대로 입력됐는지 확인
		/*for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}*/
		
		int min = Integer.MAX_VALUE;
		
		int[] score = new int[n+1]; // 점수 저장하기 위한 배열
		for(int i=1; i<=n; i++) {
			int max = 0;
			for(int j=1; j<=n; j++) {
				if(arr[i][j]!=Integer.MAX_VALUE)
					max = Math.max(max, arr[i][j]);
			}
			score[i] = max;
			min = Math.min(min, max);
		}
		
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=1; i<=n; i++) {
			if(score[i] == min) {
				count++;
				sb.append(i+" ");
			}
		}
		
		System.out.println(min+" "+count);
		System.out.print(sb);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5567_S1_결혼식 {
	static int n, m, count;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			if(arr[1][i]==1) {
				if(!visit[i])
					count++;
				visit[i]=true;
				for(int j=2; j<=n; j++) {
					if(arr[i][j]==1&&!visit[j]) {
						count++;
						visit[j] = true;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}

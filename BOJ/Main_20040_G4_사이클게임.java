package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_G4_사이클게임 {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		make();
		
		int count = 0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 같은 집합인경우 사이클 생성
			if(!union(a,b) && count==0)
				count = i+1;
		}
		
		System.out.println(count);
	}

	// 처음에는 전부 본인으로 초기화
	static void make() {
		for (int i = 0; i < n; i++)
			arr[i] = i;
	}
	
	//부모 찾아서 지정
	static int findSet(int a) {
		if(arr[a] == a) return a;
		return arr[a] = findSet(arr[a]);
	}
	
	// 같은 집합이면 false, 다른 집합이면 true
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		
		arr[bRoot] = aRoot;
		return true;
	}
	
}

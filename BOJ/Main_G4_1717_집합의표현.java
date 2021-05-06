package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1717_집합의표현 {
	static int n, m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		makeSet();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(op == 0)
				union(a,b);
			else {
				if(findSet(a) == findSet(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	static void makeSet() {
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parent[a] == a) // 내가 대표
			return a;
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB)
			return false;
		parent[rootB] = rootA;
		return true;
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
5 3 2 3 4
→ YES

5
3
0 1 0 1 0
1 0 0 1 0
0 0 0 1 0
1 1 1 0 0
0 0 0 0 0
1 5 2
→ NO
 */
public class Main_1976_G4_여행가자 {
	static int n, m;
	static int[][] arr;
	static int[] parent, rank, trip;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine()); // 도시 수
		m = Integer.parseInt(bf.readLine()); // 여행계획에 속한 도시 수
		arr = new int[n+1][n+1];
		parent = new int[n + 1];
		rank = new int[n + 1];
		trip = new int[m];

		makeSet();

		StringTokenizer st = null;
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					union(i, j);
				}
			}
		}


		// 여행갈 도시
		st = new StringTokenizer(bf.readLine());
		int tripFirst = 0;
		for (int i = 0; i < m; i++) {
			if(i==0)
				tripFirst = Integer.parseInt(st.nextToken());
			else {
				if(findSet(tripFirst) != findSet(Integer.parseInt(st.nextToken()))) {
					System.out.println("NO");
					return;
				}
			}
				
		}
		System.out.println("YES");
	}

	static void makeSet() {
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = i;
		}
	}

	static int findSet(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = findSet(parent[a]);
	}

	static void union(int a, int b) {
		 int rootA = findSet(a);
		 int rootB = findSet(b);
		 
		    if (rootA == rootB)
		        return;
		 
		    if (rank[rootA] > rank[rootB]) {
		    	int temp = rootA;
		    	rootA = rootB;
		    	rootB = temp;
		    }
		 
		    parent[rootA] = rootB;
		 
		    if (rank[rootA] == rank[rootB])
		        ++rank[rootB];
	}
}

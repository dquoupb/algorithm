
public class UnionFind {
	static int n;
	static int[] parent, rank;
	
	public static void main(String[] args) {
		n = 7;
		parent = new int[n + 1];

	}

	static void makeSet() {
		for(int i=0; i<=n; i++) {
			parent[i] = i;
			rank[i] = i;
		}
	}
	
	static int findSet(int a) {
		// 자기자신이면
		if(parent[a] == a) return a;
		
		// path 압축
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		// 같은 집합
		if(rootA == rootB) return false;
		
		// b를 a에 속하게
		parent[rootB] = rootA;
		return true;
	}
	
	// rank 압축까지 한 union
	static boolean unionRank(int a, int b) {
		// 루트 찾기
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		// 같은 집합
		if(rootA == rootB) return false;
		
		// 항상 b를 a에 속하게 하기 위해 두개 변경
		if(rank[rootB] > rank[rootA]) {
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		parent[rootB] = rootA;
		
		// 갚이가 같으면 a의 깊이를 늘려주면 된다.
		if(rank[rootA] == rank[rootB])
			++rank[rootA];
		
		return true;
	}
}

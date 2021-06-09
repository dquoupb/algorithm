package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_단어변환 {
	static String begin = "hit";
	static String target = "cog";
	static String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

	public static void main(String[] args) {
		int result = solution(begin, target, words);
		System.out.println(result);
	}

	/***** DFS *****/
	/*static boolean visit[];
	static int answer;

	static public int solution(String begin, String target, String[] words) {
		answer = 51;
		visit = new boolean[words.length];
		dfs(begin, target, 0, words);
		return answer == 51 ? 0 : answer;
	}

	// count를 한 단계씩 늘려주어 단계 세어주고, 최소값 저장하기
	static void dfs(String begin, String target, int count, String[] words) {
		// 현재 보고 있는 문자열과 target문자열이 같으면 완료된 것이므로 answer 저장해주고 리턴
		if (target.equals(begin)) {
			answer = Math.min(answer, count);
			return;
		}
		
		// 이미 확인한 문자열은 다시 가면 안되므로 방문 처리 해주어야함
		// check함수로 문자 하나만 다를경우 다음 단계로 넘어가기
		for (int i = 0; i < words.length; i++) {
			if (!visit[i] && check(begin, words[i])) {
				visit[i] = true;
				dfs(words[i], target, count + 1, words);
				visit[i] = false;
			}
		}
	}

	// 한 글자만 다른 경우 true, 아닌 경우 false
	static boolean check(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
		}
		return count == 1 ? true : false;
	}*/
	
	/***** BFS *****/
	static class Node {
		String next;
		int count;
		
		// next 문자열, count 단계를 의미 
		public Node(String next, int count) {
			this.next = next;
			this.count = count;
		}
	}
	
	static public int solution(String begin, String target, String[] words) {
		int n = words.length, answer = 0;
		
		Queue<Node> q = new LinkedList<>();
		boolean[] visit = new boolean[n];
		q.add(new Node(begin, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 현재 보고 있는 노드(문자열)가 target과 같으면 단계 answer에 저장하고 빠져나오기
			if(cur.next.equals(target)) {
				answer = cur.count;
				break;
			}
			
			// 방문 체크와 문자열 비교 체크
			for(int i=0; i<n; i++) {
				if(!visit[i] && check(cur.next, words[i])) {
					visit[i] = true;
					q.add(new Node(words[i], cur.count+1));
				}
			}
		}
		return answer;
	}
	
	// 문자열 비교 체크
	static boolean check(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
		}
		return count == 1 ? true : false;
	}
}

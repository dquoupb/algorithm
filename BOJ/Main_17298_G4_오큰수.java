package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_G4_오큰수 {
	static int n;
	static int[] arr, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		result = new int[n];

		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 스택이 비어있지 않고, 큰 수를 만나면 스택에 있는 것 빼고 집어넣어야 함
			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				result[s.pop()] = arr[i];
			}
			s.add(i);
		}

		while(!s.isEmpty()) {
			result[s.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(result[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}

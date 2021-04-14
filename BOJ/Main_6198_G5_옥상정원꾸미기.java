package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main6198옥상정원꾸미기 {
	static int n, temp;
	static long result;
	static int[] arr;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			if (s.isEmpty())
				s.push(i);
			else {
				if (arr[s.peek()] > arr[i]) { // 새로 넣을 숫자가 더 작으면
					s.push(i);
				} else { // 새로 넣을 숫자가 더 크면, 새로 넣을 숫자가 더 작을때 까지 pop한다.
					while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
						temp = s.pop();
						result += (i - temp - 1);
					}
					s.push(i);
				}
			}
		}
		int temp = 0;
		if (!s.isEmpty()) {
			temp = s.peek();
		}
		while (!s.isEmpty()) {
			result += (temp - s.pop());
		}

		System.out.println(result);
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2531_S1_회전초밥 {
	static int n, d, k, c, max;
	static int[] shisi, count;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] total;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// n : 접시 수, d : 초밥 가짓수, k : 연속해서 먹는 접시 수, d : 쿠폰번호
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		shisi = new int[n];
		for(int i=0; i<n; i++) {
			shisi[i] = Integer.parseInt(bf.readLine());
		}
		
		int count = 0;
		// 처음에는 그냥 넣어주기
		for(int i = 0; i<k; i++) {
			// 겹치는 거 먹으면 count해주면 안됨
			if(!q.contains(shisi[i]))
				count++;
			q.offer(shisi[i]);
		}
		
		// count 확인
		// 쿠폰이랑 겹치는 지 확인
		if(!q.contains(c)) {
			max = Math.max(max, count+1);
		}
		if(max == k+1) {
			System.out.println(max);
			return;
		}
		max = Math.max(max, count);
		
		for(int i=k; i<n+k-1; i++) {
			// 다음을 위해서 q에서 제거해야하는데, 
			// 두개 이상 있었으면 count에서 빼줄 필요가 없기 때문에 확인하는 것
			int temp = q.poll();
			if(!q.contains(temp))
				count--;
			// 겹치는 거 먹으면 count해주면 안됨
			if(!q.contains(shisi[i%n]))
				count++;
			q.offer(shisi[i % n]);
			
			
			if(!q.contains(c)) {
				max = Math.max(max, count+1);
			}
			if(max == k+1)
				break;
			
			max = Math.max(max, count);
		}
		
		
		System.out.println(max);
	}
}
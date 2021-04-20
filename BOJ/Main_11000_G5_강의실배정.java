package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_G5_강의실배정 {
	static int n;
	static int[][] timetable;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		timetable = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			timetable[i][0] = Integer.parseInt(st.nextToken());
			timetable[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timetable, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		/* 어차피 start기준으로 정렬했으므로 시작시간은 확인할 필요없이 끝나는 시간과 다음 강의의 시작시간과 비교하면 된다.
		 * start값으로 정렬하고, end값을 pq에 넣는 것이 핵심  */
		
		// 큐에는 end값을 저정한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(timetable[0][1]);
		
		// 새로 비교할 강의시작 시간이 이전 강의보다 작으면 새로운 강의실이 추가되어야 한다.
		// 그래서 poll하지 않고 add해준다.
		for(int i=1; i<n; i++) {
			// 비교는 이전의 end값과 새로 비교할 timetable의 start랑 비교
			// 이때 새 강의가 peek보다 크면 해당 강의가 끝나고 같은 강의장에서 새 강의 진행하는 것
			// 이 새 강의를 pq에 넣으면 뒤로 들어가므로 다음 강의는 다른 강의실에서 열리는 강의와 비교하게 된다. 어쨌든 그게 먼저 열리는 강의니까
			if(pq.peek() <= timetable[i][0])
				pq.poll();
			
			pq.add(timetable[i][1]);
		}
		
		System.out.println(pq.size());
	}

}

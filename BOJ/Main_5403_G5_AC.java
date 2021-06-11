package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5403_G5_AC {
	static String functionString;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		here :
		for(int test = 1; test<=tc; test++) {
			functionString = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			
			int status = 1;
			Deque<Integer> dq = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(bf.readLine(),",");
			for(int i=0; i<n; i++) {
				String str = st.nextToken();
				if(str.charAt(0)=='[')
					str = str.substring(1);
				if(str.charAt(str.length()-1)==']')
					str = str.substring(0,str.length()-1);
				dq.add(Integer.parseInt(str));
			}
			
			for(int i=0; i<functionString.length(); i++) {
				if(functionString.charAt(i)=='R') {
					status*=-1;
				} else {
					if(dq.size() == 0) {
						System.out.println("error");
						continue here;
					} else if(status == -1) {
						dq.pollLast();
					} else {
						dq.poll();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if(status==-1) {
				int size = dq.size();
				for(int i=0; i<size; i++) {
					sb.append(dq.pollLast());
					if(i!= size-1)
						sb.append(",");
				}
			} else {
				int size = dq.size();
				for(int i=0; i<size; i++) {
					sb.append(dq.poll());
					if(i!= size-1)
						sb.append(",");
				}
			}
			sb.append("]");
			
			System.out.println(sb);
		}
	}
}

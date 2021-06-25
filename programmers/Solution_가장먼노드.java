import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    static int[] visit;
    static ArrayList<Integer> arr[];
    static int max;
    static Queue<Node> q = new LinkedList<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0, size = edge.length; i<size; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            arr[x].add(y);
            arr[y].add(x);
        }

        visit[1] = -1;
        // 1번 노드에서 갈 수 있는 곳 큐에 넣기
        for(int i = 0; i < arr[1].size(); i++){
            // 1번 노드에서 갈 수 있는 노드번호 : idx
            int idx = arr[1].get(i);
            q.add(new Node(1, idx, 1));
            visit[idx] = 1;
        }

        while(!q.isEmpty()){
            Node temp = q.poll();
            for(int i=0; i<arr[temp.y].size(); i++){
                int idx = arr[temp.y].get(i);
                // 한 번도 방문하지 않은 곳으로 가야함
                if(visit[idx] == 0){
                    visit[idx] = temp.dir+1;
                    q.add(new Node(temp.y, idx, visit[idx]));
                    max = Math.max(visit[idx], max);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(max == visit[i])
                answer++;
        }

        return answer;
    }

    static class Node{
        int x, y, dir;
        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
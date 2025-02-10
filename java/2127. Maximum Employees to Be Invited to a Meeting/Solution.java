class Solution {
    public int maximumInvitations(int[] favorite) {
   
        int n = favorite.length;
        int long_cycle=0;

        ArrayList<int[]> two_cycle = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            HashSet<Integer> set = new HashSet<>();
            int start = i;
            int cur = i;
            while(!visited[cur]){
                visited[cur] = true;
                set.add(cur);
                cur = favorite[cur];
            }
            int len = set.size();
            while(start!=cur){
                len--;
                start = favorite[start];
            }
            //len
            long_cycle = Math.max(long_cycle,len);
            if(len == 2){
                two_cycle.add(new int[]{cur,favorite[cur]});
            }
        }

        // find 2 len cycles (add if possible)
        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i=0;i<n;i++){
            reverseList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            reverseList.get(favorite[i]).add(i);
        }
        int max2lenCyclePath = 0;
        for(int arr[] : two_cycle){
            max2lenCyclePath += f(arr[0], arr[1],reverseList) + f(arr[1],arr[0],reverseList)  + 2;
        }
        // return max
        return Math.max(max2lenCyclePath,long_cycle);
    }
    private int f(int node, int skip, List<List<Integer>> reverseList){
        int len=0;
        // [node, len]
        Queue<int[]> queue = new LinkedList<>();
        // queue.offer(node);
        queue.offer(new int[]{node, 0});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            len = Math.max(len, cur[1]);
            for(int neighbour:reverseList.get(cur[0])){
                if(neighbour == skip) continue;
                queue.offer(new int[]{neighbour, cur[1] + 1});
            }
        }
        return len;
    }
}
import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> queue;
    public RecentCounter() {
        queue= new ArrayDeque<>();
    }
    
    public int ping(int t) {
        int lb=t-3000;
        while(!queue.isEmpty()&&queue.peek()<lb){
            queue.remove();
        }
        queue.offer(t);
        return queue.size();
        
    }
}
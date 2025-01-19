import java.util.*;

public class PriorityQueueConcept {
    public static void main(String[] args) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        minHeap.add(new int[]{1, 2, 5});  // Priority based on the 3rd element (5)
        minHeap.add(new int[]{3, 4, 1});  // Priority based on the 3rd element (1)
        minHeap.add(new int[]{6, 7, 3});  // Priority based on the 3rd element (3)

        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            System.out.println("Polled: " + arr[0] + ", " + arr[1] + ", " + arr[2]);
        }
    }
}

// Example 1: String PriorityQueue (Alphabetical Order)
/* public class PriorityQueueConcept {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Banana");
        pq.add("Apple");
        pq.add("Mango");
        pq.add("Cherry");

        System.out.println("PriorityQueue: " + pq);

        // Removing elements in alphabetical order
        while (!pq.isEmpty()) {
            System.out.println("Polling: " + pq.poll());
        }
    }

} */





// Example 2: Custom Comparator for PriorityQueue (Sort by String Length)
/* public class PriorityQueueConcept {
    public static void main(String[] args) {
        // PriorityQueue with custom Comparator to sort strings by their length
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));

        pq.add("Elephant");
        pq.add("Dog");
        pq.add("Cat");
        pq.add("Hippopotamus");

        System.out.println("PriorityQueue (by length): " + pq);

        // Removing elements based on string length
        while (!pq.isEmpty()) {
            System.out.println("Polling: " + pq.poll());
        }
    }
} */

// Example 3: PriorityQueue with Integers (Custom Comparator for Descending Order): to implement max heap
/* public class PriorityQueueConcept {
    public static void main(String[] args) {
            // Custom comparator for descending order
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
            pq.add(15);
            pq.add(5);
            pq.add(30);
            pq.add(10);
    
            System.out.println("PriorityQueue (Descending Order): " + pq);
    
            // Polling elements in descending order
            while (!pq.isEmpty()) {
                System.out.println("Polling: " + pq.poll());
            }
    }
} */


// Example 4: PriorityQueue with Custom Object (Task Scheduling Example)
/* 
class Task implements Comparable<Task> {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        // Higher priority (lower value) tasks should come first
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

public class PriorityQueueConcept {
    public static void main(String[] args) {
        // PriorityQueue will order tasks based on priority (lower value means higher priority)
        PriorityQueue<Task> pq = new PriorityQueue<>();

        pq.add(new Task("Task 1", 3));
        pq.add(new Task("Task 2", 1));
        pq.add(new Task("Task 3", 2));

        System.out.println("PriorityQueue of tasks: " + pq);

        // Polling tasks based on priority
        while (!pq.isEmpty()) {
            System.out.println("Polling: " + pq.poll());
        }
    }
}
 */

// Example 7: PriorityQueue with Custom Object and Comparator (Task Priority)
/* import java.util.PriorityQueue;
import java.util.Comparator;
class Task {
    String name;
    int priority;  // Lower value means higher priority

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}


public class PriorityQueueConcept {
    public static void main(String[] args) {
        // Custom comparator to sort tasks by priority (ascending order)
        Comparator<Task> taskComparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.priority, t2.priority);
            }
        };

        // PriorityQueue with the custom comparator
        PriorityQueue<Task> pq = new PriorityQueue<>(taskComparator);

        pq.add(new Task("Task A", 3));
        pq.add(new Task("Task B", 1));
        pq.add(new Task("Task C", 2));

        System.out.println("PriorityQueue with Custom Comparator: " + pq);

        // Polling tasks based on priority
        while (!pq.isEmpty()) {
            System.out.println("Polling: " + pq.poll());
        }
    }
}
 */
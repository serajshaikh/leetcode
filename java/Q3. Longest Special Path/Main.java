import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] edges1 = {{0, 1, 2}, {1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 5, 6}};
        int[] nums1 = {2, 1, 2, 1, 3, 1};
        System.out.println(Arrays.toString(sol.longestSpecialPath(edges1, nums1))); // Output: [6, 2]
        
        int[][] edges2 = {{1, 0, 8}};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(sol.longestSpecialPath(edges2, nums2))); // Output: [0, 1]
        
        int[][] edges3 = {{0, 1, 3}};
        int[] nums3 = {4, 5};
        System.out.println(Arrays.toString(sol.longestSpecialPath(edges3, nums3))); // Expected Output: [3, 2]
    }
}


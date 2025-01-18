import java.util.*;

class Solution {
    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        // Step 1: Build adjacency list for the tree
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        // Variables to track the max length and min nodes
        int[] result = new int[]{0, Integer.MAX_VALUE}; // [maxLength, minNodes]
        
        // Step 2: DFS traversal to compute special paths
        Set<Integer> pathValues = new HashSet<>();
        dfs(0, -1, nums, graph, pathValues, 0, 1, result);
        
        return result;
    }

    private void dfs(int node, int parent, int[] nums, Map<Integer, List<int[]>> graph,
                     Set<Integer> pathValues, int currentLength, int currentNodes, int[] result) {
        
        // Add the current node's value to the path set (to ensure uniqueness)
        pathValues.add(nums[node]);

        // If we found a longer path, update the result
        if (currentLength > result[0]) {
            result[0] = currentLength;
            result[1] = currentNodes;  // Update the minimum nodes in the longest path
        }
        // If we found a path with the same length, update the minimum node count
        else if (currentLength == result[0]) {
            result[1] = Math.min(result[1], currentNodes);
        }

        // Explore neighbors
        for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            int nextNode = neighbor[0];
            int edgeLength = neighbor[1];
            
            // Only visit a neighbor if it's not visited and does not have the same value
            if (nextNode != parent && !pathValues.contains(nums[nextNode])) {
                dfs(nextNode, node, nums, graph, pathValues,
                        currentLength + edgeLength, currentNodes + 1, result);
            }
        }

        // Backtrack: Remove the current node's value from the path set
        pathValues.remove(nums[node]);
    }
}

import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            minHeap.offer(new int[]{i, 0, heightMap[i][0]});
            minHeap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            minHeap.offer(new int[]{0, j, heightMap[0][j]});
            minHeap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int trappedWater = 0;
        int[] directions = {-1, 0, 1, 0, -1};

        // Process cells in the heap
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int x = cell[0], y = cell[1], height = cell[2];

            // Check all 4 neighboring cells
            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d];
                int ny = y + directions[d + 1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    // Water can only be trapped if the neighbor's height is less than the current height
                    trappedWater += Math.max(0, height - heightMap[nx][ny]);
                    // Update the neighbor's height to ensure it holds the new boundary condition
                    minHeap.offer(new int[]{nx, ny, Math.max(height, heightMap[nx][ny])});
                }
            }
        }

        return trappedWater;
    }
}

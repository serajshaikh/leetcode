public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        System.out.println(solution.trapRainWater(heightMap)); // Output: 4
    }
}

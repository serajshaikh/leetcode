class Solution {
    int ro;
    int cl;
    public int findMaxFish(int[][] grid) {
        ro = grid.length;
        cl = grid[0].length;
        int maxFishes=0;
        for(int i=0;i<ro;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]!=0){
                    maxFishes=Math.max(maxFishes, dfs(i,j,grid));
                }
            }
        }
        return maxFishes;
    }
    public int dfs(int r, int c, int grid[][]){
        if(r<0 || r>=ro || c<0 || c>= cl || grid[r][c] == 0){
            return 0;
        }
        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(r-1,c,grid) + dfs(r,c+1,grid) + dfs(r+1,c,grid) + dfs(r,c-1,grid);
        return ans;
    }
}
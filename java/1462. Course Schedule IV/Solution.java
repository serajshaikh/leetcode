class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean mt[][] = new boolean[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int s = prerequisites[i][0];
            int d = prerequisites[i][1];
            mt[s][d] = true;
        }

        for(int k=0;k<numCourses;k++){
            for(int s=0;s<numCourses;s++){
                for(int d=0;d<numCourses;d++){
                    mt[s][d] = mt[s][d] || (mt[s][k] && mt[k][d]);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int d = queries[i][1];
            ans.add(mt[s][d]);
        }
        return ans;
    }
}
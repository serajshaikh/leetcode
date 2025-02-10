class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22},{1, 11}, {2, 12}};
        // Directly call the static method from Solution class
        System.out.println(Solution.eraseOverlapIntervals(intervals)); 
    }
}

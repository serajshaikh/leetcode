/* import java.util.*;

class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; 
            num /= 10; 
        }
        return sum;
    }


    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> freqMap = new HashMap<>();

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            freqMap.computeIfAbsent(digitSum, _ -> new PriorityQueue<>(Collections.reverseOrder())).add(num);
        }

        int maxSum = -1;

        for (PriorityQueue<Integer> pq : freqMap.values()) {
            if (pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                maxSum = Math.max(maxSum, first + second);
            }
        }

        return maxSum;
    }


} */


import java.util.*;

class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, int[]> freqMap = new HashMap<>();

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            freqMap.putIfAbsent(digitSum, new int[]{-1, -1});
            int[] largest = freqMap.get(digitSum);

            if (num > largest[0]) {
                largest[1] = largest[0];
                largest[0] = num;
            } else if (num > largest[1]) {
                largest[1] = num;
            }
        }

        int maxSum = -1;

        for (int[] largest : freqMap.values()) {
            if (largest[1] != -1) {
                maxSum = Math.max(maxSum, largest[0] + largest[1]);
            }
        }

        return maxSum;
    }
}

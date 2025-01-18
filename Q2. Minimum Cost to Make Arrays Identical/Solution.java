import java.util.Arrays;

public class Solution {
    public static long minimumCost(int[] arr, int[] brr, int k) {
        int n = arr.length;
        long noRearrangeCost = 0;
        long rearrangeCost = k;
        for (int i = 0; i < n; i++) {
            noRearrangeCost += Math.abs(arr[i] - brr[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i = 0; i < n; i++) {
            rearrangeCost += Math.abs(arr[i] - brr[i]);
        }

        return Math.min(noRearrangeCost, rearrangeCost);
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {-7, 9, 5};
        int[] brr1 = {7, -2, -5};
        int k1 = 2;

        // Example 2
        int[] arr2 = {2, 1};
        int[] brr2 = {2, 1};
        int k2 = 0;

        // Example 3
        int[] arr3 = {-9};
        int[] brr3 = {9};
        int k3 = 29;

        System.out.println(minimumCost(arr1, brr1, k1)); // Output: 13
        System.out.println(minimumCost(arr2, brr2, k2)); // Output: 0
        System.out.println(minimumCost(arr3, brr3, k3)); // Output: 18
    }
}

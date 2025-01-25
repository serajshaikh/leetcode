import java.util.*;
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        List<Queue<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        list.add(new LinkedList<>());
        list.get(0).offer(temp[0]);
        map.put(temp[0], 0);
        int index = 0;

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] - temp[i - 1] > limit) {
                list.add(new LinkedList<>());
                index++;
            }
            list.get(index).offer(temp[i]);
            map.put(temp[i], index);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int group = map.get(val);
            nums[i] = list.get(group).poll();
        }

        return nums;
    }
}
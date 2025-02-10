import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<Integer> stack = new Stack<>();
        // int n = temperatures.length;
        // int[] result = new int[n];
   
        // for(int i = 0; i < n; i++) {
      
        //     while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
              
        //         int index = stack.pop();
        //         result[index] = i - index;
        //     }
        //     stack.push(i);
        // }
        // return result;

        //Now with array instead of stack
        int n = temperatures.length;
        int[] stack = new int[n];
        int top = -1;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            while (top>-1&&temperatures[i]>temperatures[stack[top]]) {
                int index=stack[top--];
                result[index] = i-index;
                
            }
            stack[++top]=i;
        }
        return result;
    }
}
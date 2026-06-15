import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to hold number and its index
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            
            // Remember the current number
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}

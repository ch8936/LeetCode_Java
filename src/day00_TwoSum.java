/*
*Given nums = [2, 7, 11, 15], target = 9,
*Because nums[0] + nums[1] = 2 + 7 = 9,
*return [0, 1].
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
		for (int x = 0; x < nums.length - 1; x++) {
			for (int y = x + 1; y < nums.length; y++) {
				if (nums[x] + nums[y] == target) {
					result[0] = x;
					result[1] = y;
                    return result;
				}
			}
		}
		return result;   
    }
}

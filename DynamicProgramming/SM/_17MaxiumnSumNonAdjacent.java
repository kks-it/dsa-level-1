package SM;

import java.util.ArrayList;

// Question Link: https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261
public class _17MaxiumnSumNonAdjacent {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.

		// return solutionRecursion(nums, nums.size() - 1);

		// Integer[]dp = new Integer[nums.size()];
		// return solutionMem(nums, nums.size() -1, dp);

		return solutIonTab(nums);

	}

	public static int solutionRecursion(ArrayList<Integer> nums, int index){

		if(index == 0)	return nums.get(0);
		if(index < 0)	return 0;

		int take = nums.get(index) + solutionRecursion(nums, index -2);
		int notTake = solutionRecursion(nums, index -1);

		return Math.max(take, notTake);

	}

	public static int solutionMem(ArrayList<Integer> nums, int index, Integer[] dp){
		if(index == 0)	return nums.get(0);
		if(index < 0)	return 0;

		if(dp[index] != null)	return dp[index];

		int take = nums.get(index) + solutionMem(nums, index -2, dp);
		int notTake = solutionMem(nums, index -1, dp);

		return dp[index] = Math.max(take, notTake);
	}

	public static  int solutIonTab(ArrayList<Integer> nums){
		int last = nums.get(0), secondLast = 0;

		for(int i = 1; i < nums.size(); i++){
			int result = Math.max(last , secondLast + nums.get(i));
			secondLast = last;
			last = result;
		}
		return last;
	}
}
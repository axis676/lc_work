package lc_work.easy.SearchInsertPosition;

public class Solution {
	public int searchInsert(int[] nums, int target) {
        int ans = 0;
        
        for(int i = 0; i<nums.length; i++) {
        	int thisNum = nums[i];
        	int previousNum = i==0?nums[0]:nums[i-1];
        	int nextNum = i==nums.length-1? nums[nums.length-1]:nums[i+1];
        	
        	boolean isBiggerThanPrevious = target > previousNum;
        	boolean isSmallerThanNext = target < nextNum;
        	
        	if(target == thisNum) {
        		return i;
        	}else if(!isBiggerThanPrevious) {
        		return 0;
        	}else if(isBiggerThanPrevious && target < thisNum) {
        		return i;
        	}else if(target > thisNum && isSmallerThanNext) {
        		return i+1;
        	}else if(!isSmallerThanNext && i != nums.length-1) {
        		continue;
        	}else if(!isSmallerThanNext && i == nums.length-1) {
        		return nums.length;
        	}
        	
        }
		return ans;
    }
	
    public int searchInsertBetter(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int ans = sol.searchInsertBetter(new int[]{1,3,5,6}, 7);
		System.out.println(ans);
	}
}

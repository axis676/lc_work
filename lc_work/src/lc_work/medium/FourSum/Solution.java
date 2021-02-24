package lc_work.medium.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    	for(int i = 0 ; i< nums.length-3; i++) {
    		for(int j=i+1; j<nums.length-2;j++) {
    			for(int k=j+1; k<nums.length-1; k++) {
    				for(int l=k+1; l<nums.length; l++) {
    					if(nums[i]+nums[j]+nums[k]+nums[l] == target) {
    						List<Integer> oneAnsList = new ArrayList<Integer>();
    						oneAnsList.add(nums[i]);
    						oneAnsList.add(nums[j]);
    						oneAnsList.add(nums[k]);
    						oneAnsList.add(nums[l]);
    						ansList.add(oneAnsList);
    					}
    				}
    			}
    		}
    	}
    	
    	
    	
    	return ansList;
    }
    
    public List<List<Integer>> fourSumAns(int[] nums, int target) {
    	List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    	if(nums==null|| nums.length<4)
            return ansList;
    	
    	Arrays.sort(nums);
    	for(int i = 0 ; i< nums.length-3; i++) {
    		if(i!=0 && nums[i] == nums[i-1]) {
    			continue;
    		}
    		for(int j=i+1; j<nums.length-2;j++) {
    			if(j!=i+1 && nums[j] == nums[j-1]) {
    				continue;
    			}
    			int k = j+1;
    			int l = nums.length-1;
    			while(k<l) {
    				if(nums[i]+nums[j]+nums[k]+nums[l] < target) {
    					k++;
    				}else if(nums[i]+nums[j]+nums[k]+nums[l] > target) {
    					l--;
    				}else {
    					List<Integer> oneAnsList = new ArrayList<Integer>();
						oneAnsList.add(nums[i]);
						oneAnsList.add(nums[j]);
						oneAnsList.add(nums[k]);
						oneAnsList.add(nums[l]);
						ansList.add(oneAnsList);
						k++;
						l--;
						while(k<l && nums[l] == nums[l+1]) {
							l--;
						}
						while(k<l&& nums[k] == nums[k-1]) {
							k++;
						}
						
    				}
    			}
    		}
    	}
    	
    	
    	
    	return ansList;
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> ansList = sol.fourSumAns(new int[]{1,0,-1,0,-2,2}, 0);
//    	List<List<Integer>> ansList = sol.fourSumAns(new int[]{-2,-1,-1,1,1,2,2}, 0);
    	System.out.println(ansList);
    }
    
    /**
Input
[-2,-1,-1,1,1,2,2]
0

Output
[[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-2,-1,1,2],[-1,-1,1,1]]

Expected
[[-2,-1,1,2],[-1,-1,1,1]]
     */
}

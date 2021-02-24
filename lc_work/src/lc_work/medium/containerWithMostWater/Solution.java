package lc_work.medium.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
    	int volume = 0;
    	int maxVolume = 0;
    	for(int i =0 ; i<height.length; i++) {
    		for(int j =0; j<i; j++) {
    			int thisWidth = i-j;
    			int thisHeight = Math.min(height[i], height[j]);
    			int thisVolume = thisWidth * thisHeight;
    			if(maxVolume<thisVolume) {
    				maxVolume = thisVolume;
//    				System.out.println("i="+i+",j="+j+",area="+maxVolume);
    				
    			}
    		}
    	}
    	
        
    	return maxVolume;
    }
    
    public int maxAreaAgain(int[] height) {
    	int left = 0;
    	int right = height.length-1;
    	int maxArea = 0;
    	while(left < right) {
//    		int thisHeight = Math.min(height[left], height[right]);
//    		int thisWidth = right - left;
//    		int thisArea = thisHeight * thisWidth;
//    		maxArea = Math.max(maxArea, thisArea);
    		maxArea = Math.max(maxArea, Math.min(height[left],height[right]) * (right - left));
    		if(height[left]<height[right]) {
    			left++;
    		}else {
    			right--;
    		}
    	}
    	return maxArea;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] height = {1,8,6,2,5,4,8,3,7};
//    	int[] height = {1,1};
//    	int[] height = {4,3,2,1,4};
//    	System.out.println(sol.maxArea(height));
    	System.out.println(sol.maxAreaAgain(height));
    }
    
	public int maxAreaBetter(int[] a) {
		int left = 0, right = a.length - 1;
		int maxArea = 0;
		
		//從最外層往內層找，因為要有面積最大值勢必寬度要大才有可能
		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(a[left], a[right]) * (right - left));
			if (a[left] < a[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}
}

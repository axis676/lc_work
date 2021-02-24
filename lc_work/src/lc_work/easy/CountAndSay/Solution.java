package lc_work.easy.CountAndSay;

public class Solution {
    public String countAndSay(int n) {
    	if(n==1) {
    		return "1";
    	}
        
    	String previousAns = countAndSay(n-1);
    	
    	StringBuilder sb = new StringBuilder();
    	char previousDigit = 0;
    	int tmpCount = 1;
    	boolean isFirst = true;
    	for(int i =0; i<previousAns.length(); i++) {
    		if(isFirst) {
    			previousDigit = previousAns.charAt(i);
    			isFirst = false;
    		}else if(previousDigit == previousAns.charAt(i)) {
    			tmpCount++;
    		}else {
    			sb.append(tmpCount).append(previousDigit);
    			tmpCount =1;
    			previousDigit = previousAns.charAt(i);
    		}
    	}
    	sb.append(tmpCount).append(previousDigit);
    	
        return sb.toString();
    }
    
    public String countAndSayAgain(int n) {
    	if(n==1) {
    		return "1";
    	}
        
    	String previousAns = countAndSay(n-1);
    	
    	StringBuilder sb = new StringBuilder();
    	char previousDigit = previousAns.charAt(0);
    	int tmpCount = 1;
    	for(int i =1; i<previousAns.length(); i++) {
    		char thisChar = previousAns.charAt(i);
    		if(previousDigit == thisChar) {
    			tmpCount++;
    		}else {
    			sb.append(tmpCount).append(previousDigit);
    			tmpCount =1;
    			previousDigit = thisChar;
    		}
    	}
    	sb.append(tmpCount).append(previousDigit);
    	
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
//    	String ans = sol.countAndSay(5);
    	String ans = sol.countAndSayAgain(5);
    	System.out.println(ans);
    }
}

package lc_work.medium.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<String> letterCombinations(String digits) {
	    List<String> rtnList = new ArrayList<String>();
	    Map<Character, String[]> digitsToLettersMapping = new HashMap<Character,String[]>();
	    String[] twoToLetters = {"a","b","c"};
	    String[] threeToLetters = {"d","e","f"};
	    String[] fourToLetters = {"g","h","i"};
	    String[] fiveToLetters = {"j","k","l"};
	    String[] sixToLetters = {"m","n","o"};
	    String[] sevenToLetters = {"p","q","r","s"};
	    String[] eightToLetters = {"t","u","v"};
	    String[] nineToLetters = {"w","x","y","z"};
	    digitsToLettersMapping.put('2',twoToLetters);
	    digitsToLettersMapping.put('3',threeToLetters);
	    digitsToLettersMapping.put('4',fourToLetters);
	    digitsToLettersMapping.put('5',fiveToLetters);
	    digitsToLettersMapping.put('6',sixToLetters);
	    digitsToLettersMapping.put('7',sevenToLetters);
	    digitsToLettersMapping.put('8',eightToLetters);
	    digitsToLettersMapping.put('9',nineToLetters);
	    
//	    for(int i =0; i<digits.length(); i++) {
//	    	char thisChar = digits.charAt(i);
//	    	String[] thisDiditToLettersString = digitsToLettersMapping.get(thisChar);
//	    	for(int j = 0; j<thisDiditToLettersString.length; j++) {
//	    		
//	    	}
//	    }
	    
    	char thisChar = digits.charAt(0);
    	String[] thisDiditToLettersString = digitsToLettersMapping.get(thisChar);
    	char nextChar = digits.charAt(0+1);
    	String[] nextDiditToLettersString = digitsToLettersMapping.get(nextChar);
    	char nextnextChar = digits.charAt(0+1+1);
    	String[] nextnextDiditToLettersString = digitsToLettersMapping.get(nextnextChar);
    	for(int j = 0; j<thisDiditToLettersString.length; j++) { 
    		for(int k=0; k<nextDiditToLettersString.length; k++) {
    			for(int m=0; m<nextnextDiditToLettersString.length; m++) {
    				String ans =  thisDiditToLettersString[j];
    				ans = ans + nextDiditToLettersString[k];
    				ans = ans + nextnextDiditToLettersString[m];
    				
    				rtnList.add(ans);
    			}
    		}
    	}
	    	
	    
	    
	   
	    return rtnList;
	}
	// my dfs start
	public List<String> letterCombinationsDFSMine(String digits) {
	    List<String> rtnList = new ArrayList<String>();
	    Map<Character, String[]> digitsToLettersMapping = new HashMap<Character,String[]>();
	    String[] twoToLetters = {"a","b","c"};
	    String[] threeToLetters = {"d","e","f"};
	    String[] fourToLetters = {"g","h","i"};
	    String[] fiveToLetters = {"j","k","l"};
	    String[] sixToLetters = {"m","n","o"};
	    String[] sevenToLetters = {"p","q","r","s"};
	    String[] eightToLetters = {"t","u","v"};
	    String[] nineToLetters = {"w","x","y","z"};
	    digitsToLettersMapping.put('2',twoToLetters);
	    digitsToLettersMapping.put('3',threeToLetters);
	    digitsToLettersMapping.put('4',fourToLetters);
	    digitsToLettersMapping.put('5',fiveToLetters);
	    digitsToLettersMapping.put('6',sixToLetters);
	    digitsToLettersMapping.put('7',sevenToLetters);
	    digitsToLettersMapping.put('8',eightToLetters);
	    digitsToLettersMapping.put('9',nineToLetters);
	    
	    char[] curChar = new char[digits.length()];
	    dfs(digits, 0, rtnList, curChar, digitsToLettersMapping);
	    return rtnList;
	}
	
	private void dfs(String digits, int index, List rtnList, char[] curChar, Map<Character, String[]> digitsToLettersMapping) {
		if(index == digits.length()) {
			if(index > 0) {
				rtnList.add(new String(curChar));
			}
			return;
		}
		
		String[] curLettersArray = digitsToLettersMapping.get(digits.charAt(index));
		for(int i = 0; i<curLettersArray.length; i++) {
			curChar[index] = curLettersArray[i].charAt(0);
			dfs(digits, index+1, rtnList, curChar, digitsToLettersMapping);
		}
	}
	// my dfs end
	
	// my bfs start
	public List<String> letterCombinationsBFSMine(String digits){
		if(digits.length() == 0) {
			return new ArrayList<String>();
		}
		List<String> rtnList = new ArrayList<String>();
		Map<Character, String[]> digitsToLettersMapping = new HashMap<Character,String[]>();
		String[] oneToLetters = {""};
	    String[] twoToLetters = {"a","b","c"};
	    String[] threeToLetters = {"d","e","f"};
	    String[] fourToLetters = {"g","h","i"};
	    String[] fiveToLetters = {"j","k","l"};
	    String[] sixToLetters = {"m","n","o"};
	    String[] sevenToLetters = {"p","q","r","s"};
	    String[] eightToLetters = {"t","u","v"};
	    String[] nineToLetters = {"w","x","y","z"};
	    digitsToLettersMapping.put('1',oneToLetters);
	    digitsToLettersMapping.put('2',twoToLetters);
	    digitsToLettersMapping.put('3',threeToLetters);
	    digitsToLettersMapping.put('4',fourToLetters);
	    digitsToLettersMapping.put('5',fiveToLetters);
	    digitsToLettersMapping.put('6',sixToLetters);
	    digitsToLettersMapping.put('7',sevenToLetters);
	    digitsToLettersMapping.put('8',eightToLetters);
	    digitsToLettersMapping.put('9',nineToLetters);
	    
	    rtnList.add("");
	    for(char currentNumber : digits.toCharArray()) {
	    	List<String> tmp = new ArrayList<>();
	    	for(String s : rtnList) {
	    		String[] numberToLetters = digitsToLettersMapping.get(currentNumber);
	    		for(String letter : numberToLetters) {
	    			tmp.add(s + letter);
	    		}
	    	}
	    	rtnList = tmp;
	    }
		return rtnList;
	}
	// my bfs end
    public List<String> letterCombinations2(String digits) {      
      String[] d = new String[]{" ", 
                                "", 
                                "abc", 
                                "def",
                                "ghi",
                                "jkl",
                                "mno",
                                "pqrs",
                                "tuv",
                                "wxyz"};        
      char[] cur = new char[digits.length()];
      List<String> ans = new ArrayList<>();
      dfs(digits, d, 0, cur, ans);
      return ans;
    }
    private void dfs(String digits, String[] d, 
                     int l, char[] cur, List<String> ans) {
      if (l == digits.length()) {
          if (l > 0) ans.add(new String(cur));
          return;
      }
 
      String s = d[Character.getNumericValue(digits.charAt(l))];
 
      for (int i = 0; i < s.length(); ++i) {
          cur[l] = s.charAt(i);
          dfs(digits, d, l + 1, cur, ans);            
      }
    }
    
    
    public List<String> letterCombinationsBFS(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        
        String[] d = new String[]{" ", 
                                  "", 
                                  "abc", 
                                  "def",
                                  "ghi",
                                  "jkl",
                                  "mno",
                                  "pqrs",
                                  "tuv",
                                  "wxyz"};       
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit : digits.toCharArray()) {
          List<String> tmp = new ArrayList<>();
          for (String t : ans) {
            String s = d[Character.getNumericValue(digit)];
            for (int i = 0; i < s.length(); ++i)
              tmp.add(t + s.charAt(i));
          }
          ans = tmp;
        }
        
        return ans;
      }
    
    
	public static void main(String[] args) {
//		System.err.println("error");
		Solution sol = new Solution();
//		List rtnList = sol.letterCombinations("234");
//		List rtnList = sol.letterCombinations2("234");
//		List rtnList = sol.letterCombinationsMine("1");
//		List rtnList = sol.letterCombinationsBFS("234");
		List rtnList = sol.letterCombinationsBFSMine("");
		
		System.err.println(rtnList);
	}
}

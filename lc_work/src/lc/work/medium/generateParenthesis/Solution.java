package lc.work.medium.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private char[] parenthesisChar = { '(', ')' };
	char leftParenthesisChar = '(';
	char rightParenthesisChar = ')';
	
	public List<String> generateParenthesis(int n) {
		
		List<String> ansList = new ArrayList<String>();
		
		char[] tmpAnsChar = new char[n * 2];
		helper(ansList, tmpAnsChar, 0, 0, 0, n);

		return ansList;
	}

	private void helper(List ansList, char[] tmpAnsChar, int index, int leftParenCount, int rightParenCount, int n) {
		if (index == n * 2) {
			ansList.add(new String(tmpAnsChar));
			return;
		}
		if (leftParenCount <= rightParenCount && leftParenCount < n) {
			tmpAnsChar[index] = leftParenthesisChar;

			helper(ansList, tmpAnsChar, index + 1, leftParenCount + 1, rightParenCount, n);
		} else if (leftParenCount > rightParenCount && leftParenCount < n) {
			for (char parenthesis : parenthesisChar) {
				if ('(' == parenthesis) {
					tmpAnsChar[index] = leftParenthesisChar;

					helper(ansList, tmpAnsChar, index + 1, leftParenCount + 1, rightParenCount, n);
				} else {
					tmpAnsChar[index] = rightParenthesisChar;

					helper(ansList, tmpAnsChar, index + 1, leftParenCount, rightParenCount + 1, n);
				}
			}
		} else if (leftParenCount <= rightParenCount && leftParenCount >= n) {
			tmpAnsChar[index] = rightParenthesisChar;

			helper(ansList, tmpAnsChar, index + 1, leftParenCount, rightParenCount + 1, n);
		} else if (leftParenCount > rightParenCount && leftParenCount >= n) {
			tmpAnsChar[index] = rightParenthesisChar;

			helper(ansList, tmpAnsChar, index + 1, leftParenCount, rightParenCount + 1, n);
		}
	}
	
	// better method start
	public List<String> generateParenthesisBetter(int n) {
        List<String> res = new ArrayList();
        
        int left = n, right = left;
        
        helper(res, new StringBuilder(), left, right);
        
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, int left, int right) {
        if (right == 0) {
            if (left == 0) res.add(sb.toString());
            return;
        }
        
        if (right >= left && left > 0) {
            sb.append('(');
            helper(res, sb, left - 1, right);
            sb.setLength(sb.length() - 1);
        } 
        if (left >= right) return;
        sb.append(')');
        helper(res, sb, left, right - 1);
        sb.setLength(sb.length() - 1);
    }
	// better method end 
	
	public static void main(String[] args) throws java.lang.Exception {
		Solution ideone = new Solution();
		List<String> rtnList = ideone.generateParenthesis(3);
		System.out.println(rtnList);
//		StringBuilder testSB = new StringBuilder();
//		testSB.append(12345);
//		testSB.setLength(testSB.length()-1);
//		System.out.println(testSB);
	}
	
	

}

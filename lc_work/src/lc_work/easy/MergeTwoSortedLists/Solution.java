package lc_work.easy.MergeTwoSortedLists;

public class Solution {
	
	 //Definition for singly-linked list.
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode finalAns = new ListNode();
        ListNode currentNode = finalAns;
        if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
//        while(l1 != null){
//        	while(l2 != null) {
//        		if(l1.val <= l2.val) {
//        			currentNode.next = l1;
//        			l1 = l1.next;
//        			currentNode = currentNode.next;
//        			break;
//        		}else {
//        			currentNode.next = l2;
//        			l2 = l2.next;
//        			currentNode = currentNode.next;
//        		}
//        	}
//        }
        while(l1 != null && l2!= null){
        		if(l1.val < l2.val) {
        			currentNode.next = l1;
        			l1 = l1.next;
        			currentNode = currentNode.next;
        		}else {
        			currentNode.next = l2;
        			l2 = l2.next;
        			currentNode = currentNode.next;
        		}
        }
        
        if(l1!= null) { 
        	currentNode.next = l1;
        }
        if(l2 != null) { 
        	currentNode.next = l2;
        }
        
    	return finalAns.next;
    }
    
	public static void main(String[] args) {
		
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2,l3);
		ListNode l1 = new ListNode(1,l2);
		
		ListNode l4_ = new ListNode(4);
		ListNode l2_ = new ListNode(2, l4_);
		ListNode l1_ = new ListNode(1, l2_);
		
		Solution sol = new Solution();
		ListNode ans = sol.mergeTwoLists(l1, l1_);
		System.err.println(ans);
		while(ans!=null) {
			System.err.println(ans.val);
			ans = ans.next;
		}
//		System.err.println(ans.val);
//		System.err.println(ans.next.val);
//		System.err.println(ans.next.next.val);
//		System.err.println(ans.next.next.next.val);
//		System.err.println(ans.next.next.next.next.val);
//		System.err.println(ans.next.next.next.val);
		
		
	}

}

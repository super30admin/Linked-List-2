package s30Coding;

import java.util.*;

//Time Complexity :- O(m+n) --> where m is length of the list A and n is the length of list B
//Space Complexity :- O(m) or O(n)

//LeetCode :- Yes
//Logic :- Store nodes of ListA in hashset, and then traverse through listB if any node is present in the set return the node

public class FindIntersectioninList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       Set<ListNode> set = new HashSet<>();
	        while(headA!= null){
	            set.add(headA);
	            headA = headA.next;
	        }
	        
	        while(headB != null){
	            if(set.contains(headB)) return headB;
	            headB = headB.next;
	        }
	        
	     return null;
	    }
}

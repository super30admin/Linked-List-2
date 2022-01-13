package linkedList2;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//Time Complexity : O(n+m), where n is the length of linked listA and m of linked listB
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b) {
            if(a == null)
                a = headB;
            else
                a = a.next;
            if(b == null)
                b = headA;
            else
                b = b.next;
        }
        
        return a;
    }
	
	//Time Complexity : O(n+m), where n is the length of linked listA and m of linked listB
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        while(curr != null) {
            curr = curr.next;
            lenB++;
        }
        
        if(lenA > lenB) {
            while(lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while(lenB > lenA) {
                headB = headB.next;
                lenB--;
            }
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
	 
	//Time Complexity : O(n+m), where n is the length of linked listA and m of linked listB
	//Space Complexity : O(n), for set
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        
        return null;
    }
}

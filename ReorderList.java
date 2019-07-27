package linkedList2;

/*
Idea : 1. We fill a deque with all nodes in the linked list.
	   2. Whenever we encounter odd position, place last dq element in next to head or last result node and continue..
	   3. When we encounter even position, place first qd element next to head or last result node and continue.
	   4. Keep removing the nodes from the dq with every iteration. 
	   
Time Complexity : O(n) where n is the length of the list.
Space Complexity : O(n) because we used a deque of length n.

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
public void reorderList(ListNode head) {
        
        Deque<ListNode> dq = new LinkedList<>();
        if(head == null || head.next == null) 
        {
            return;
        }
        ListNode temp = head.next;
        while (temp != null) 
        {
            dq.offer(temp);
            temp = temp.next;
        }
        
        int count = 1;
        ListNode prev = head;
        
        while(!dq.isEmpty())
        {
            ListNode next;
            if(count % 2 == 0) 
            {
                next = dq.pollFirst();
            }
            else next = dq.pollLast();
                
            prev.next = next;
            prev = next;
            count ++;      
        }
        prev.next = null;
    }
}

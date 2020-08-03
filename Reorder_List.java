
public class Reorder_List {
	//Approach:
	//1. Here we perform 3 functions, finding the middle of the list and reversing the nodes in the second half. Then we can split the two halves and start merging the two lists.
	//2. For fidning middle, am using slow (1x) and fast (2x) pointer - when fast.next reaches null, slow will be before middle, so we pass slow.next to reverse function.
	//3. We have a reverse function, and it returns the head of reversed list. Now we have 2 lists, we can start merging the node of first list to the ode of second list and continue doing it.
	
	public void reorderList(ListNode head) {
        //edge case
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {            
            slow = slow.next;
            fast = fast.next.next;
        }      
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        slow = head;
        fast = reversed;
        ListNode curr = null;
        while(fast != null)
        {
            curr = slow.next;
            slow.next = fast;
            
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
     
        while(fast != null)
        {            
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
//Time Complexity : O(n)  
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :


//middle of the list
//reverse them
//merge them
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // Base case
        if(head == null || head.next == null || head.next.next == null){	// base case
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode Node1 = head;
        ListNode Node2 = head;
        int count = 0;
        
        while(Node1 != null){	// push all the nodes into the stack
            stack.push(Node1);
            Node1 = Node1.next;
            count++;
        }
        
        int mid = (count/2);	// calculate the mid point
        System.out.println(mid);
        int i = 0;
        
        while(i < mid){
            ListNode NewNext = stack.pop();	// logic - for every pop from the back of the node, add it to the first element and so on
            if(Node2.next == NewNext){		// if the popped element is equal to the next element, just add null 
                NewNext.next = null;
            }else{
                NewNext.next = Node2.next;
            }
            Node2.next = NewNext;		// proceed to 2nd element in the original linkedList
            Node2 = Node2.next.next;
            i++;
            //System.out.println("here");
        }
        
        if (count % 2 == 1) {	// corner case
            Node2.next = null;
        }
    }
}
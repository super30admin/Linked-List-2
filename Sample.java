//Binary Search Tree Iterator
// Time Complexity : O(1)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        dfs(root);
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode current = stack.pop();
        if(current.right != null) {
            dfs(current.right);
        }
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

//---------------------------------------------------------------//
//Reorder List
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
    
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);
        
        slow.next = null;
        slow = head;
        
        while(slow != null && fast != null) {
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
     private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) { 
            return head;
        }
		ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;		
         
		while(fast != null) {										
            
			current.next = prev;										
			prev = current;
			current = fast;
			fast = fast.next;
		}
		current.next = prev;
		return current;											
    }
}


//-------------------------------------------------------------------//
//Intersection of 2 linkedlist
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no



public class Solution {

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

       ListNode curA=headA;

       ListNode curB=headB;

       while(curA!=null && curB!=null){

           curA=curA.next;

           curB=curB.next;

       }

       while(curB!=null){

           curB=curB.next;

           headB=headB.next;

       }

       while(curA!=null){

           curA=curA.next;

           headA=headA.next;

       }

       while(headA!=headB){

           headA=headA.next;

           headB=headB.next;

       }

       return headA;

   }

}
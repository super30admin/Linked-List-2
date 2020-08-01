// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA=0;
        int lengthB=0;
        
         ListNode curr = headA; //pointing curr to head of list A
        
        while(curr!=null) // find length of A
        {
            lengthA++; 
            curr=curr.next;
        }
        
         curr = headB; //pointing curr to head of list B
        
        while(curr!=null) // find length of b
        {
            lengthB++;
            curr=curr.next;
        }
        
        while(lengthA>lengthB) // if list a is greater than b
        {
            headA=headA.next; // moving head of a by the diff of the two list
            lengthA--;
        }
        
         while(lengthB>lengthA)  // if list b is greater than a
        {
            headB=headB.next; // moving head of b by the diff of the two list
            lengthB--;
        }
        
        while(headA!=headB) // till the heads dont meet
        {
            headA = headA.next; // move both heads
            headB = headB.next;
        }
        
        return headA; // return any of the head
        
    }
}

// Time Complexity : O(1) average, worst case O(h) as nodes traversed for a next operation is equal to height 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st = new Stack<>(); // global stack
    public BSTIterator(TreeNode root) {
       
        dfs(root); // calling constructor on root 
    }
    
    /** @return the next smallest number */
    public int next() {
        //when next called, element on top gets popped out ( value to be returned)
        TreeNode node = st.pop();
        dfs(node.right); // then traverse the right of popped node by calling dfs on node.right
        return node.val; // return the popped value
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty(); // if stack is not empty, we have a next value
    }
    
    
    private void dfs(TreeNode root)
    {
        //Constructor -- initializes the state of stack after each next
        while(root!=null) // till we get a null
        {
            st.push(root); // push root to stack
            root = root.left; // go to the left of root
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// Time Complexity : O(3n) = O(n) average
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        //finding the middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null) //  for even and odd list 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        
        //reversal 
        fast = reverse(slow.next); // finding reverse from mid next and pointing fast to it
         
        slow.next = null; // breaking link between two lists
        slow = head; // resetting slow to beginning of list
        
        //merging
        ListNode curr;
        
        while(fast!=null) 
        {
          curr = slow.next; // moving curr to slow next so that we dont loose the link
          slow.next = fast; // pointing slow to fast
          fast = fast.next; //moving fast to next
          slow.next.next = curr; // pointing the next element of slow to curr
          slow = curr; // moving slow to curr
        }
        
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;
        
        while(fast!=null) // till fast reaches null
        {
            curr.next = prev; // pointing curr to prev
            prev = curr; // moving prev to curr 
            curr = fast; // moving curr to fast
            fast = fast.next; // moving fast to fast's next
            
        }
        curr.next = prev; // one element remains so to reverse it
        return curr; // return end of list 
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Worked on geeksforgeeks
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         
         node.data = node.next.data; // copy value from next node to curr node
         node.next = node.next.next; // remove reference to the next node
    }
}
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// 1. Binary Search Tree Iterator
//
//TC O(h) time for next and O(1) for hasNext().
//SC = O(1)
/public class BSTIterator {

    private TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        return nextHelper(root, root);
    }

    private int nextHelper(TreeNode parent, TreeNode node) {
        // a node without a left child is the smallest one -> O(h)
        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        // extract the value
        final int res = node.val;

        // remove the smallest node
        if (node.right != null) {
            node.val = node.right.val;
            node.left = node.right.left;
            node.right = node.right.right;
        }
        else {
            // no parent or a right child => the last node
            if (parent == node) root = null;
            // the parent exist => node must be the left child
            else parent.left = null;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root!=null;
    }
}


//2 . Reorder List
//TC : O(N)
//SC    O(1)
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
        if(head == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        fast = reverseList(fast);
        slow = head;
        
        ListNode temp = slow;
        while(fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseList(ListNode head){
        if(head == null || head.next ==null)
            return head;
        
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
        
        
    }


///3.Delete without head
//TC : O(1)
//SC : O(1))
class GfG
{
    void deleteNode(Node node)
    {   if(node == null || node.next ==null)
            return;
        else{
            node.data = node.next.data;
            node.next = node.next.next;
        }
        
    
         // Your code here
    }
}

// 4. Intersection of Two Linked Lists
//TC : O(n)
//TC O(1)
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
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        int count=0;
        ListNode temp1 = h1, temp2 = h2;
        
        while(h1!=null && h2!=null){
            h1=h1.next;
            h2=h2.next;
        }
        
      if(h1 == null){
          while(h2!=null){
              // diff++;
              temp2=temp2.next;
              h2=h2.next;
          }
      }
        else{
            
          while(h1!=null){
              // diff++;
              temp1=temp1.next;
              h1=h1.next;
          }
            
        }
        
        while (temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
        
    }
}





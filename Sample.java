// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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

// TC O(n) SC O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next ==null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        //reverse the list
        fast = reverse(slow.next);
        // break the first list
        slow.next = null;
        
        slow = head;
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse (ListNode head) {
      if(head == null || head.next == null) return head;
        
       ListNode prev = null;
       ListNode curr = head;
       ListNode fast = head.next;
        
        while(fast != null){
           curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
        
        
    }
        
    
}

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

// TC O(n) SC O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next ==null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        //reverse the list
        fast = reverse(slow.next);
        // break the first list
        slow.next = null;
        
        slow = head;
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse (ListNode head) {
      if(head == null || head.next == null) return head;
        
       ListNode prev = null;
       ListNode curr = head;
       ListNode fast = head.next;
        
        while(fast != null){
           curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
        
        
    }
        
    
}



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
    //TC O(n+m) SC O(1)
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode listA = headA;
        ListNode listB = headB;
        while(listA !=null){
            lenA++;
            listA = listA.next;
            
        }
        
        while(listB !=null){
            lenB++;
            listB = listB.next;
            
        }
        listA = headA;
        while(lenA > lenB){
            listA = listA.next;
            lenA--;
        }
        listB = headB;
        while(lenB > lenA){
            listB = listB.next;
            lenB--;
        }
        while(listA != listB){
            listA = listA.next;
            listB = listB.next;
        }
   return listA; }
}




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

//TC O(1) SC O(h)
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = s.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


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
    Stack<TreeNode> st ;


    public BSTIterator(TreeNode root) {
        
        this.st = new Stack<>();
        dfs(root);
    }
    public void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }

    }
    
    public int next() {
        TreeNode popped = st.pop();
        dfs(popped.right);
        return popped.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

 //-----------------------------------
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
        int lenA = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        int lenB = 0;
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(lenA > lenB){
            p1=p1.next;
            lenA--;
        }
        while(lenB > lenA){
            p2 = p2.next;
            lenB--;
        }
        while(p1 != p2){
            p1 =p1.next;
            p2 =p2.next;
        }
        return p2;
    }
}

//-------------------------------------------


import static java.lang.Integer.reverse;

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
        if(head ==null || head.next ==null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next!= null && fast.next.next!= null) {
            slow= slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head ;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast ;
            fast = fast.next;
            slow.next.next = temp ;
            slow = temp ;
        }

    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node ;
        while(curr != null){
            ListNode temp = curr.next ;
            curr.next = prev;
            prev = curr ;
            curr = temp;
        }
        return prev;

    }
}
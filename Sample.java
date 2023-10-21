// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

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
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
// ## Problem2 (https://leetcode.com/problems/reorder-list/)

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
        if(head == null || head.next == null || head.next.next==null) return;

        ListNode slow = head;
        ListNode fast = head;
        //find middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        //slow will be in middle
        fast = reverse(slow.next);
        slow.next = null;

        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
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

// ## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
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
    List<TreeNode> list;
    int index = 0;
    public BSTIterator(TreeNode root) { //O(n)
        this.list = new ArrayList<>();
        inorder(root);
    }
    private void inorder(TreeNode root){ 
        if(root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    
    public int next() { //O(1)
        TreeNode curr = list.get(index);
        index++;
        return curr.val;
    }
    
    public boolean hasNext() { //O(1)
        return index!= list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// Time Complexity : O(1) average 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

// Iterator Solution
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
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){ 
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() { //O(h)
        TreeNode poppedValue = st.pop();
        dfs(poppedValue.right);
        return poppedValue.val;
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// ## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on geeksforgeeks : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
         del.data = temp.data;
         del.next = temp.next;
         temp = null;
    }
}
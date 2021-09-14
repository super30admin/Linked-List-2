// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
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

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;

    }

    public boolean hasNext() {
        return !st.isEmpty();

    }
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
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
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp = null;
        //merge the 2 list;
        while(fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast =fast.next;
            slow.next.next =temp;
            slow = temp;
        }

    }
    private ListNode reverse(ListNode root){
        if(root == null) return null;
        if(root.next == null) return root;
        ListNode prev = null;
        ListNode curr = root;
        ListNode fast = root.next;
        while(fast!=null){
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA=0;
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        int lenB=0;
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenA<lenB){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA= headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

class Solution
{
    void deleteNode(Node del)
    {
        // Your code here

        del.data = del.next.data;
        del.next = del.next.next;
    }
}


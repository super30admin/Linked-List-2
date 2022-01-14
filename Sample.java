// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        int lenA =0;
        int lenB = 0;
        ListNode listA = headA;
        ListNode listB = headB;
        while(listA != null){
            lenA++;
            listA = listA.next;
        }
        listA = headA;
         while(listB != null){
            lenB++;
            listB = listB.next;
        }
        listB = headB;
        
        while(lenA > lenB){
            listA =listA.next;
            lenA--;
        }
        while(lenB > lenA){
            listB =listB.next;
            lenB--;
        }
        while(listA != listB){
            listA = listA.next;
            listB = listB.next;
        }
        return listA;
    }
}
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count =0;
        while(count < n){
            fast = fast.next;
            count++;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// Time Complexity :O(H) H - is height of the tree
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next(){
        int val = 0;
        if(hasNext()){
        TreeNode node = stack.pop();
            val = node.val;
            dfs(node.right);
        }
        return val;
        
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty()){
            return true;
        }else
            return false;
        
    }
    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
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

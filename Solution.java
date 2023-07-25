// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity : O(1)
// Space Complexity : O(1)
    void deleteNode(Node del){
        del.data = del.next.data;
        del.next = del.next.next;
    }
//    143. Reorder List
// Time Complexity : O(n)
// Space Complexity : O(1)
    public void reorderList(ListNode head) {
        //null
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //finding the mid
        ListNode slow = head, fast = head;
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //reversing the 2nd half of the SLL
        head2 = reverseList(head2);

        //merging to two halves
        while(head2 != null){
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;
        }
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


//160. Intersection of Two Linked Lists
// Time Complexity : O(n)
// Space Complexity : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
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



//173. Binary Search Tree Iterator
// Time Complexity : O(n)
// Space Complexity : O(1)
class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
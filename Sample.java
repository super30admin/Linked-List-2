## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

// Time Complexity : Time complexity for next() is 0(1) elements in the stack in ascending order, popping an element from the stack
//                   and hasNext() is 0(1) checks if the stack is empty or not
// Space Complexity : 0(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);       
    }
    
    public int next() {
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void dfs(TreeNode root) {
        while (root != null) {
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

## Problem2 (https://leetcode.com/problems/reorder-list/)

// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

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
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        slow.next = null;

        // Step 3: Merge the first and second half of the list
        ListNode p1 = head;
        ListNode p2 = prev;

        while (p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            p1.next = p2;
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }
    }
}


## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Time Complexity : 0(m + n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

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
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        int lenB = 0;
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}


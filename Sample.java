// Time Complexity :HasNext : O(1) and next: O(1) 
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class BSTIterator {
      Stack<TreeNode> stack;
    TreeNode currNode = null;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        currNode = root;
    }
    public int next() {
        while(currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        TreeNode top = stack.pop();
        currNode = top.right;
        return top.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty() || currNode != null;
    }
}

//Time complexity : O(n)
//Space complexity: O)1)


class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverse(slow.next);

        slow.next = null;
      while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;

            second = secondNext;
            first = firstNext;
        }
    }

    private ListNode reverse(ListNode node) {

     ListNode prev = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}


//Time complexity: O(1)
//Space complexity:O(1)


class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;          // copy the next node's value into the current node
        node.next=node.next.next;       // connect the current node to the next of next node
        
    }
}








//Time complexity: O(m+n)
//Space complexity: O(1)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if (a == null && b == null) return null;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

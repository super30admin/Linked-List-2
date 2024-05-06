// Problem 1: (https://leetcode.com/problems/binary-search-tree-iterator/)
// Time Complexity : O(1) for next and hasNext
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : In the constructor, it initializes a stack and pushes all left nodes of the BST onto the stack to start the inorder traversal. The next method returns the value of the next smallest node in the BST by popping a node from the stack and pushing all left nodes of its right subtree onto the stack. The hasNext method checks if there are any remaining nodes in the stack, indicating whether there is a next smallest number in the BST.

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        init(root);
    }

    private void init(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        init(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

// Problem 2: (https://leetcode.com/problems/reorder-list/)
// Time Complexity : O(n) where n is the number of nodes in the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I first find
// the middle of the linked list using the slow and fast pointer approach. Then
// I reverse the second half of the linked list. Finally, I merge the two halves
// of the linked list by alternating the nodes of the two halves.
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        while (slow != null && fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

// Problem 3:
// (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : NA

// Your code here along with comments explaining your approach :
class GfG {
    void deleteNode(Node node) {
        // If the node is the last node or is null, we can't delete it
        if (node == null || node.next == null) {
            return;
        }

        // Copy the data from the next node to the current node
        node.data = node.next.data;

        // Delete the next node
        node.next = node.next.next;
    }
}

// Problem 4: (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I first find
// the length of both the linked lists and then move the pointer of the longer
// linked list to the same length as the shorter linked list. Then I move both
// the pointers until they are equal and return the node where they meet.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
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

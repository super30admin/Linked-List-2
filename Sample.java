// Time Complexity:
//   - Constructor: O(h), where h is the height of the tree
//   - next(): Amortized O(1), worst case O(h)
//   - hasNext(): O(1)
// Space Complexity: O(h), for the stack where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We simulate an in-order traversal using a stack to get the next smallest element in a BST.
// The constructor pushes all leftmost nodes onto the stack. Each call to `next()` pops one node, processes its right subtree.
// This approach ensures amortized O(1) time per operation since each node is pushed and popped only once.

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        dfs(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return st.size() > 0;
    }
}


// Time Complexity : O(n), where n is the number of nodes in the list
// Space Complexity : O(1), in-place reordering
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We find the middle of the linked list, reverse the second half, and then merge both halves alternately.

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = findMiddle(head);
        ListNode secondHalf = reverseList(middle.next);
        middle.next = null; // break the list into two halves

        ListNode first = head;
        ListNode second = secondHalf;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}



// Time Complexity : O(m + n), where m and n are the lengths of the two linked lists
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We use two pointers and traverse both lists. When one pointer reaches the end, it's redirected to the head of the other list.
// This ensures both pointers traverse equal length, and they will meet at the intersection or at null if there's no intersection.
// This approach works even when the two lists have different lengths.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null){
                return null;
            }

            if(currA ==null){
                currA = headB;
            }

            if(currB ==null){
                currB = headA;
            }
        }

        return currA;
    }
}
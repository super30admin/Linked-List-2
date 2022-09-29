# Linked-List-2

## Problem1 BST Iterator

```Java
// Time Complexity : O(height) - worst, O(1) - average 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() { //O(height)
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
    }

    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}
```
## Problem2 Reorder List

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        //mid
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //rebverse
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        //merge

        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

## Problem3 Delete node without head

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void deleteNode(ListNode node) {
        ListNode iterate = node;

        //we have to only check the next as not null.
        //Because, we are given that the 'node' is not the last node.

        ListNode prevNode = node;

        while(iterate.next != null){
            int nextVal = iterate.next.val;
            iterate.val = nextVal;
            prevNode = iterate;
            iterate = iterate.next;
        }

        prevNode.next = null;
    }
}
```
## Problem4  Intersection of two linked list 

```Java
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;

        while(curA!=null && curB!=null){
            curA=curA.next;
            curB=curB.next;
        }
        while(curB!=null){
            curB=curB.next;
            headB=headB.next;
        }

        while(curA!=null){
            curA=curA.next;
            headA=headA.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headB;
    }
}
```

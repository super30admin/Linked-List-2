# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
// Time Complexity : O(1);(avg)
// Space Complexity : O(h);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will use a stack to store the elements to give when asked for next();
2. We will return true if there are more elemnts in the stack but false when the stack is empty :  representing that we have traversed through all the elements


class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode popped = stack.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void dfs(TreeNode root){
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

## Problem2 (https://leetcode.com/problems/reorder-list/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will find the mid of the linked list using fast and slow pointer
2. we will reverse the list from mid.next pointer
3. Then we will traverse the List's first and second half together while my second half is not null and I will place the nodes in the second half in bw the first halves nodes

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

        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Cut the list into two halves
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Merge two halves
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity :O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
To delete the node give we will just copy the value of the next node in the del_node and skip the next node whose value we copied

class Solution {
    void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return; // Can't delete the last node using this approach
        }

        node.data = node.next.data;       // Copy data from next node
        node.next = node.next.next;       // Bypass the next node
    }
}

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

1. There are chances that the length of list A and listB is not equal 
2. so we will run a loop while currA != currB 
3. and then if currA reaches the null then it means tha t listA is shorter than b and we will make currA point to headB so that we can skip exactly the same amount of nodes by which B is longer than a
4. Vice versa for B

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode currA = headA, currB = headB;

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null) return null;

            if(currA == null){
                currA = headB;
            }

            if(currB == null){
                currB = headA;
            }
        }

        return currA;
    }
}

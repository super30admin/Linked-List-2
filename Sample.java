// Time Complexity : O(n) for the constructor where n is the number of nodes in the tree. O(h) for next where h is the height of the tree and O(1) for hasnext.
// Space Complexity : O(h) where h is the height of the tree as stack will contain at most h nodes at any point in time.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed course tutorial

// Your code here along with comments explaining your approach
// In this approach during intialization we perform depth-first search to traverse the leftmost path of the tree and we push all the nodes along this path onto a 
// stack. In the next element method we are just simply popping the top node from the stack and this node is the next smallest element in the BST. After popping
// we perform a DFS pn the right subtree of this node to ensure all nodes are correctly positioned into stack. In the hasnext method we simply check if the stack 
// is not empty which indicates that there are elements left in BST.

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
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root!=null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode popped = st.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



// Time Complexity : O(n) where n is number of nodes in linked list
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed course tutorial


// Your code here along with comments explaining your approach
// In this approach we will use slow and fast pointers. We will use slow and fast pointers to get the middle of the linked list. Slow pointer moves one step at a
// time and fast pointer moves two steps at a time. Once we find the middle we will reverse second half f the list starting from the node after middle node is 
// found and then we will merge the first half and reversed second half in an alternating fashion.

import static java.lang.Integer.reverse;

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
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(fast!=null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}


// Time Complexity : O(1) as we are not traversing over the linked list
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed course tutorial


// Your code here along with comments explaining your approach
// In this approach we are deleting the node without any reference to the head pointer. First we will copy the data from the next node to the node to be deleted.
// Then to remove the next node we will simply adjust the next pointer of the current node to skip the next node which will delete it from the list.

/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del_node)
    {
         // Your code here
         if(del_node.next == null) {
             del_node = null;
         }
         
         del_node.data = del_node.next.data;
         Node temp = del_node.next;
         del_node.next = del_node.next.next;
         temp = null;
    }
}



// Time Complexity : O(n+m) where n is length of list A and m is length of list B.
// Space Complexity : O(1) as we have not used any additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
// To find the intersection of two singly linked lists first we have calculated the lengths of both linked list and then we will just adjust the starting pointer
// of longer list so that both lists should have same number of nodes remaining. Once we adjust the pointer we will then simply traverse both lists 
// simultaneously until a common node is found.

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

        ListNode a = headA;
        ListNode b = headB;

        while(a.next != null) {
            lenA++;
            a = a.next;
        }

        while(b.next != null) {
            lenB++;
            b = b.next;
        }

        a = headA;
        b = headB;

        if(lenA > lenB) {
            while(lenA != lenB) {
                a = a.next;
                lenA--;
            }
        } else {
            while(lenB != lenA) {
                b = b.next;
                lenB--;
            }
        }

        while(a != b) {
            a = a.next;
            b = b.next;
        }

        if(a == b) {
            return a;
        }

        return null;
    }
}
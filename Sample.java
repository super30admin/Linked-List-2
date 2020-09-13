// Problem 1 - Binary Search Tree Iterator
// Time Complexity : O(n) where, n = total number of nodes
// Space Complexity : O(n)

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze stack
// 2 - call dfs on root
// 3 - keep pushing root.left to stack
// 4 - on next() pop from stack and check if popped node has right
// 5 - if yes, then call dfs on popped node right
// 6 - for hasNext() just check if stack is empty
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
  // 1
  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    // 2
    dfs(root);
  }

  /** @return the next smallest number */
  public int next() {
    // 4
    TreeNode returnVal = stack.pop();
    if (returnVal.right != null) {
      // 5
      dfs(returnVal.right);
    }

    return returnVal.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    // 6
    return !stack.isEmpty();
  }

  private void dfs(TreeNode root) {
    // 3
    while (root != null) {
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

// Problem 2 - Reorder List
// Time Complexity : O(n) where, n = total number of nodes
// Space Complexity : O(n)

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze slow and fast pointer
// 2 - while condition to get middle node
// 3 - increment slow by 1 node
// 4 - increment fast by 2 nodes
// 5 - reverse from slow's next node
// 6 - terminate slow to null
// 7 - merge reversed list with original 1st half linked list
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
    if (head == null) {
      return;
    }
    // 1
    ListNode slow = head;
    ListNode fast = head;
    // 2
    while (fast != null && fast.next != null) {
      // 3
      slow = slow.next;
      // 4
      fast = fast.next.next;
    }
    // 5
    ListNode h2 = reverse(slow.next);
    // 6
    slow.next = null;

    ListNode h1 = head;
    ListNode temp1;
    ListNode temp2;
    // 7
    while (h2 != null) {
      temp1 = h1.next;
      h1.next = h2;
      temp2 = h2.next;
      h2.next = temp1;
      h2 = temp2;
      h1 = temp1;
    }
  }

  private ListNode reverse(ListNode curr) {
    ListNode prev = null;
    ListNode next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}

// Problem 3 - Delete without head pointer
// Time Complexity : O(1)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
// Algorithm
// 1 - get next node
// 2 - copy value of next node to current node
// 3 - point current node to next.next
import java.util.*;
public class Main {
    
  static ListNode head; 

  static class ListNode {
    int data; 
    ListNode next; 

    ListNode(int d) { 
      data = d; 
      next = null; 
    } 
  }

  public void printList(ListNode node) { 
    while (node != null) { 
      System.out.print(node.data + " "); 
      node = node.next; 
    } 
  } 

  public void deleteNode(ListNode node) {
    // 1
    ListNode next = node.next;
    // 2
    node.data = next.data;
    // 3
    node.next = node.next.next;
  }

   public static void main(String []args){
      Main list = new Main(); 
      list.head = new ListNode(1); 
      list.head.next = new ListNode(12); 
      list.head.next.next = new ListNode(1); 
      list.head.next.next.next = new ListNode(4); 
      list.head.next.next.next.next = new ListNode(1); 

      System.out.println("Before Deleting "); 
      list.printList(head); 

      /* I m deleting the head itself. 
       You can check for more cases */
      list.deleteNode(head.next); 
      System.out.println(""); 
      System.out.println("After deleting "); 
      list.printList(head); 
   }
}

// Problem 4 - Intersection of Two Linked Lists
// Time Complexity : O(n) where n = maxLength
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze size variables and dummies
// 2 - get size of both the linked lists
// 3 - get the diff in size and move pointer to respective greater sized linked list to match other linked list
// 4 - keep comparing nodes from both linked lists until same
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
    // 1
    int sizeA = 0;
    int sizeB = 0;
    ListNode dummyA = headA;
    ListNode dummyB = headB;
    // 2
    while (dummyA != null) {
      sizeA++;
      dummyA = dummyA.next;
    }

    while (dummyB != null) {
      sizeB++;
      dummyB = dummyB.next;
    }

    dummyA = headA;
    dummyB = headB;
    // 3
    if (sizeA > sizeB) {
      while (sizeA != sizeB) {
        dummyA = dummyA.next;
        sizeA--;
      }
    } else {
      while (sizeA != sizeB) {
        dummyB = dummyB.next;
        sizeB--;
      }
    }
    // 4
    while (dummyA != null && dummyB != null) {
      if (dummyA == dummyB) {
        return dummyA;
      }
      dummyA = dummyA.next;
      dummyB = dummyB.next;
    }

    return null;
  }
}

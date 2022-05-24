import java.util.Stack;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BST iterator
// Time Complexity : O(1)
// Space Complexity : O(1)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
      }
  }

class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = stk.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root != null){
            stk.push(root);
            root=root.left;
        }
    }
}

//Reorder List
//Time Complexity : O(N)
//Space Complexity : O(1)
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public void reorderList(ListNode head) {
      //finding mid of linked list
      ListNode slow = head;
      ListNode fast = head;
      while(fast.next != null && fast.next.next != null){
          slow = slow.next;
          fast = fast.next.next;
      }
        //slow pointer will pointing at mid
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        //change the links
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    //reverse function
    private ListNode reverse(ListNode head){
         ListNode previous = null;
         ListNode current = head;
         ListNode ne =null;
        while(current!=null){
            ne = current.next;
			current.next =  previous;
			previous = current;
			current=ne;
            
        }
   
        return previous;
    }
}

//Delete without head pointer
//Time Complexity : O(1)
//Space Complexity : O(1)
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
//Function to delete a node without any reference to head pointer.
class Solution2
{
    void deleteNode(Node del)
    {
         // copy the next node data and remove the element
         del.data=del.next.data;
        del.next=del.next.next;
    }
}

//Intersection of Two Linked Lists
//Time Complexity : O(N+M)
//Space Complexity : O(1)
class Solution3{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current = headA;
        //length of first list headA
        int lenA=0;
        while(current != null){
            current=current.next;
            lenA++;
        }
        current = headB;
        //length of first list headB
        int lenB=0;
        while(current != null){
            current=current.next;
            lenB++;
        }
        //if list B is greater than list A
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        //if list A is greater than list B
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        //till they encounter same node
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
      //return any of heads
        return headA;
    }
}
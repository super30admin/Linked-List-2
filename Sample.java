//Problem 1
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
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
private void dfs( TreeNode root)
{
    while(root!=null)
    {
        s.push(root);
        root=root.left;
    }
}
    public BSTIterator(TreeNode root) {
       s=new Stack<>();
       dfs(root); 
    }
    
    public int next() {
        TreeNode popped=s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 //Problem 2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
        if(head==null||head.next==null) return;
      //1 find middle
      ListNode slow,fast;
      slow=fast=head;
      while(fast.next!=null && fast.next.next!=null)
      {
        fast=fast.next.next;
        slow=slow.next;
      }
      //2 reverse second half

       fast=reverse(slow.next);
      slow.next=null;
slow=head;
      // 3 merge the two half
      while(fast!=null)
      {
ListNode temp=slow.next;
slow.next=fast;
fast=fast.next;
slow.next.next=temp;
slow=temp;

      }

    }
    private ListNode reverse(ListNode head)
    {
        if(head==null|| head.next==null) return head;
        ListNode cur,prev,next;
        prev=next=null;
        cur=head;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}

 //Problem 3
// Time Complexity :O(n+m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
        if(headA==null || headB==null) return null;
        int lenA=0;
        int lenB=0;
        ListNode tempA,tempB;
        tempA=headA;
        tempB=headB;
        while(tempA!=null)
        {
            tempA=tempA.next;
            lenA=lenA+1;
        }
        while(tempB!=null)
        {
            tempB=tempB.next;
            lenB=lenB+1;

        }
        int diff=0;
          tempA=headA;
        tempB=headB;
        if(lenA>lenB)
        {
            diff=lenA-lenB;
            for(int i=0;i<diff;i++)
            {
tempA=tempA.next;
            }
        }
        else{
            diff=lenB-lenA;
            for(int i=0;i<diff;i++)
            {
                tempB=tempB.next;
            }
        }
        while(tempA!=null)
        {
            if(tempA==tempB)
            {
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
      return null;  
    }
}

 //Problem 4
// Time Complexity :O(n1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
         del_node.data=del_node.next.data;
         del_node.next=del_node.next.next;
    }
}

// Time Complexity :Average O(1)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node=st.pop();
        dfs(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
}
---------------------------------------------------------------------------------------------------------
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes


class Solution {
  public void reorderList(ListNode head) {
    if (head == null) return;

    
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    
    ListNode prev = null, curr = slow, tmp;
    while (curr != null) {
      tmp = curr.next;

      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

   
    ListNode first = head, second = prev;
    while (second.next != null) {
      tmp = first.next;
      first.next = second;
      first = tmp;

      tmp = second.next;
      second.next = first;
      second = tmp;
    }
  }
}

--------------------------------------------------------------------------------------------------------------
// Time Complexity :O(m+n)
//where m and n are the number of nodes in the linkedlists
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes


public class Solution {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int countA=0;
        int countB=0;
        int d = 0;
        ListNode a = headA;
        ListNode b = headB;+
        
        while(headA!=null)
        {
            countA++;
            headA = headA.next;
        }
        
        while(headB!=null)
        {
            countB++;
            headB = headB.next;
        }
        if(countA>countB)
        {
            d = countA-countB;
            while(d>0)
            {
                a = a.next;
                d--;
            }
            
            while(a!=b)
            {
                if(a==null||b==null) return null;
                a = a.next;
                b = b.next;
            }
            
            return a;
        }
        else
        {
            d = countB-countA;
            while(d>0)
            {
                b = b.next;
                d--;
            }
            
            while(a!=b)
            {
                if(a==null||b==null) return null;
                a = a.next;
                b = b.next;
            }
            return a;
        }
    }
}

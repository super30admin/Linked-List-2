// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
        
    }
    
    public int next() {
        TreeNode result=st.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
}


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Problem2 (https://leetcode.com/problems/reorder-list/)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)   return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        ListNode curr;
        while(fast!=null)
        {
            curr=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=curr;
            slow=curr;
        }
    }
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while(fast!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}



// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy=node.next;
        node.val=dummy.val;
        node.next=dummy.next;
    }
}



// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Problem4 (https://leetcode.com/problems/intersection-of-two-linked-lists/)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode start1=headA;
        ListNode start2=headB;
        int count1=0;
        int count2=0;
        while(start1!=null)
        {
            start1=start1.next;
            count1++;
        }
        while(start2!=null)
        {
            start2=start2.next;
            count2++;
        }
        while(count2>count1)
        {
            headB=headB.next;
            count2--;
        }
        while(count1>count2)
        {
            headA=headA.next;
            count1--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}


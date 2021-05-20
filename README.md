# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
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
TIME Complexity :O(n),n is the total number of elements in the tree
Space Complexity:O(h) height of the tree

## Problem2 (https://leetcode.com/problems/reorder-list/)
REORDER
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode start=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            start=start.next;
            fast=fast.next.next;
        }
        fast=reverse(start.next);
        start.next=null;
        start=head;
        ListNode curr;
        while(fast!=null)
        {
            curr=start.next;
            start.next=fast;
            fast=fast.next;
            start.next.next=curr;
            start=curr;
            
        }
        
    }
    private ListNode reverse(ListNode head)
    {
            if(head==null) return null;
           ListNode prev=null;
           ListNode curr=head;
           ListNode fast=curr.next;
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
TIME Complexity :O(n)
Space Complexity:O(n) using auxilary space


## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy=node.next;
        node.val=dummy.val;
        node.next=dummy.next;
    }
}

TIME Complexity :O(1)
Space Complexity:O(n) using auxilary space

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode start=headA;
        ListNode fast=headB;
        int count1=0,count2=0,count=0;
            while(start!=null)
            {
                count1++;
                start=start.next;
            }
         while(fast!=null)
            {
                count2++;
                fast=fast.next;
            }
           start=headA;
           fast=headB;
           while(count1>count2)
           {
            start=start.next;
            count1--;
           }
        
            while(count1<count2)
           {
            fast=fast.next;
            count2--;
            }
            while(start!=fast)
            {
                start=start.next;
                fast=fast.next;
            }
        return start;
        
        
        
    }
}
TIME Complexity :O(n)
Space Complexity:O(1) no extra space

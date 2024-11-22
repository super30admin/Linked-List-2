# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
## Solution 1 
## Time Complexity:O(n) Space:O(1)
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        init(root);
    }
    private void init(TreeNode root)
    {
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        
    }
    public int next() {

        TreeNode value=st.pop();
        init(value.right);
        return value.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}


## Problem2 (https://leetcode.com/problems/reorder-list/)
## Solution 2

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;


        slow=head;
        
        while(fast!=null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
      

    }
    

    private ListNode reverse(ListNode head)
    {   if (head==null) return head;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
## Solution 3
## Time and Space Complexity:O(1)
## Here we copy the data of next node to current node and point that node to next node's next pointer.
class Solution {
    void deleteNode(Node node) {
        // Your code here
        Node nextNode=node.next;
        node.data=nextNode.data;
        node.next=nextNode.next;

    }
}

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
## Solution 4

 //Time Complexity:O(m+n)
 //Space Complexity:O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA;
        ListNode currB=headB;
        int countA=0,countB=0;

        while(currA!=null)
        {
           countA++;
           currA=currA.next;
        }
        while(currB!=null)
        {
            countB++;
            currB=currB.next;
        }
        int diff=Math.abs(countA-countB);
        int i=0;
        
        if(countA>countB){
            while(i<diff)
            {
                headA=headA.next;
                i++;
            }
        }
        else if(countA<countB){
            while(i<diff)
            {
                headB=headB.next;
                i++;
            }
        }

        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            return headA;

            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
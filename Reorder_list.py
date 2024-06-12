// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach.
In this problem we traverse to the mid of the linked list and reverse the second half of the linked list.then we take one element from the first half and another one from the reversed second half.we do this till all the elements are traversed.


# Time comlexity --> o(n)
# space complexity --> o(1) --> inorder traversal
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rev(self,f,prev,curr):
        while f!=None:
            f=f.next
            curr.next=prev
            prev=curr
            curr=f
        return prev
    
        
        
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if head==None:
            return None
        s=head
        f=head
        # traverse to point slow to the mid of the linked list
        while(f.next!=None and f.next.next!=None):
            s=s.next
            f=f.next.next
        # point fast to the second part of the list after mid
        f=s.next
        s.next=None
        prev=None
        curr=f
        # reversing the second half of the linked list
        f=self.rev(f,prev,curr)
        slow=head
        
        while(f!=None):
            curr=slow.next
            slow.next=f
            f=f.next
            slow.next.next=curr
            slow=curr  
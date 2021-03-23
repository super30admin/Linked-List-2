#TimeComplexity:O(N) 
#SpaceComplexity: O(1)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if (head==None):
            return None
        def rev(s: ListNode):
            cur=s
            prev=None
            Next=s
            while(cur!=None ):
                Next=cur.next
                cur.next=prev
                prev=cur
                cur=Next
            return prev
                
        cur=head
        s=cur
        f=cur
        while(f!=None and f.next!=None):
            s=s.next
            f=f.next.next
        rev=rev(s.next)
        s.next=None
        f=rev
        cur=head
        while(f!=None and cur!=None):
            s=cur.next
            cur.next=rev
            f=rev.next
            rev.next=s
            cur=s
            rev=f
       
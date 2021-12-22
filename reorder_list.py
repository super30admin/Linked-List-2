# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#time complexity: O(n)
#space complexity: O(1)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None: return 0
        
        def reverse(x):
            prev=None
            fast=x.next
            curr=x
            while(fast!=None):
                curr.next=prev
                prev=curr
                curr=fast
                fast=fast.next
            curr.next=prev
            return curr
        
        slow=head
        fast=head.next
        
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
            
        fast=reverse(slow.next)
        
        slow.next=None
            
        slow=head
        dummy=slow.next
        while(fast!=None):
            slow.next=fast
            fast=fast.next
            slow.next.next=dummy
            slow=dummy
            if dummy==None: break
            dummy=dummy.next
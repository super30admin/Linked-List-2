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
        if head==None or head.next==None or head.next.next==None:
            return head
        
        #traverse half way
        fast=head
        slow=head
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        #point slow to none as this should be end
        head2=slow.next
        slow.next=None
        
        #Reverse head2
        cur=head2
        prev=None
        fast=head2.next
        while(fast!=None):
            cur.next=prev
            prev=cur
            cur=fast
            fast=fast.next
        cur.next=prev
        head2=cur
        #Connect to form correct list
        cur=head
        cur2=head2
        fast=head.next
        fast2=head2.next
        while(cur!=None):
            cur.next=cur2
            cur=fast
            if cur2:
                cur2.next=cur
            cur2=fast2
            if fast!=None:
                fast=fast.next
            if fast2!=None:
                fast2=fast2.next
        
        return head
        #Time O(n)
        #Space O(1)
            

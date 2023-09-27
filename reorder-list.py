#TC:O(N) sc:O(1)
# found middle reverse selcond half. then merge both the half as per need

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        # """
        if not head or not head.next:
            return

        #find the middle of the LL
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        #reverse LL
        
        fast = self.reversedList(slow.next)
        slow.next = None
        slow = head

        #merge the two LL
        while fast != None:
            temp = slow.next
            slow.next = fast   
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reversedList(self,head):
            if not head or not head.next:
               return head
    
            prev=None
            curr=head
            fast=head.next
            while fast!= None:
                curr.next=prev
                prev=curr
                curr=fast
                fast=fast.next
            
            curr.next = prev
            return curr

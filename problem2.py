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
        fast = head
        slow = head
        while (fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next

        fast = self.reordered(slow.next)
        slow.next = None

        slow = head

        while(fast!=None):

            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr

        return slow


    def reordered(self,head):
        if head == None or head.next==None:
            return head
        reversedl = self.reordered(head.next)
        head.next.next = head
        head.next = None
        return reversedl
        

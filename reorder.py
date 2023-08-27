# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None or head.next.next is None:
            return 
        
        slow, fast = head, head

        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head

        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverseList(self,curr):
        prev = None
        fast = curr.next
        while fast != None:
            curr.next = prev
            prev, curr = curr, fast
            fast = fast.next
        curr.next = prev
        return curr




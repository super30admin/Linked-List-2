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
        if head == None or head.next ==None:
            return
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        ##slow pointer is at mid
        fast = self.reverse_list(slow.next)

        slow.next = None
        slow = head
        temp = ""

        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp


    def reverse_list(self,head):
        start  = head
        prev = None
        fast = head.next

        while(fast !=None):
            start.next = prev
            prev = start
            start = fast
            fast = fast.next
        
        start.next = prev

        return start


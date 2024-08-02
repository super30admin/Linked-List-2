#TC O(n) and SC O(1)
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
        if head == None or head.next == None:
            return
        # to find mid of LL
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        #reverse second part of LL
        fast = self.reverse(slow.next)
        slow.next = None

        #merge the 2 LL to get output
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head: Optional[ListNode]) -> ListNode:
        if head == None or head.next == None:
            return head
        prev = None
        curr = head
        fast = head.next
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
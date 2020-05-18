# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#tc:O(n)
#SC:O(1)
#Find the middle node. Reverse the elements from middle. Assign next node accordingly.
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:    return head

        low = fast = head
        while fast and fast.next:
            low = low.next
            fast = fast.next.next

        tmp = low.next
        low.next = None

        # reverse the right half
        tail = cur = tmp
        while cur and cur.next:
            cur = cur.next
            tail.next = cur.next
            cur.next = tmp
            tmp = cur
            cur = tail

        # insert in order
        mid = tmp
        while mid:
            tmp = mid.next
            mid.next = head.next
            head.next = mid
            head = head.next.next
            mid = tmp
        
        

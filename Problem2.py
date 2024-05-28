# T.C: O(n)
# S.C: O(1)

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
        # find the middle
        slow, fast = head, head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # reverse the linkedlist from the mid
        fast = self.reverse(slow.next)
        slow.next = None

        #Merge
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
    def reverse(self, node):
        prev = None
        curr = node
        fast = None

        while curr!= None:
            fast = curr.next
            curr.next = prev
            prev = curr
            curr = fast
        return prev

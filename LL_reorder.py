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
        if not head or not head.next:
            return head
        slow, fast = head, head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        fast = self.reverselist(slow.next)
        slow.next = None
        slow = head
        while(fast):
            curr = slow.next
            slow.next = fast
            fast= fast.next
            slow.next.next = curr
            slow = curr
        
    
    def reverselist(self, node):
        prev, curr, fast = None, node, node.next
        while(fast):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr


#time complexity - O(3n) ~ O(n), traversing, reversing and reordering

#space complexity - O(1)

#all test cases passed
"""
First, I used the slow and fast pointer technique to find the middle node of the linked list. Then, I reversed the second half of the list starting from the middle. After splitting the list into two halves, I merged them in an alternating fashion—taking one node from the first half, then one from the reversed second half—until the list was fully reordered.
Time Complexity: O(n)
Space Complexity: O(1)
"""
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
        if not head or not head.next:
            return
            
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev = None
        curr = slow.next

        while curr:
            tempNode = curr.next
            curr.next = prev
            prev = curr
            curr = tempNode
        slow.next = None
        first = head
        second = prev

        while second:
            temp1 = first.next
            temp2 = second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2 
        
# Time Complexity: O(m+n) # m is length of first LL and n is length of second LL.
# Space Complexity: O(1)

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
        if head is None or head.next is None:
            return

        # Find the middle element. slow is the position of middle element        
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the list
        fast = reverseLL(slow.next)
        slow.next = None

        # Merge two linked lists together
        slow = head
        temp = None
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverseLL(head):
        if head is None and head.next is None:
            return head
        
        prev = None
        curr = head
        fast = head.next

        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev

        return curr
        
        

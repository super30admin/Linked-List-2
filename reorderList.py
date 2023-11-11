
# Time Complexity: O(n)
# Space Complexity: O(1)

# To do the reorder in constant space, we first need to go to the middle of the LL
# We then break the list into 2 halves, and reverse the second half after midpoint.

# Then we need to just point elements in an alternate fashion and we get the solution.

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
            return head
        
        # Find Middle
        slow = self.middleList(head)

        fast = self.reversedList(slow.next)
        slow.next = None

        slow = head

        while(fast is not None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
    def middleList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while (fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next
        
        return slow

    def reversedList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        prev = None
        curr = head
        fast = curr.next

        while(fast is not None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        return curr

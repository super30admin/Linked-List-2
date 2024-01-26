# Approach 1 - Putting list in array. using two pointers accessing array from front and back end and appending nodes to the output list.
# TC: O(N), SC: O(N)

# Approach 2 - With two pointers, we will traverse to the last nod using fast. Then our slow pointer is in the middle. as slow pointer traverse till wend we reverse this second half of the list. Then we reorder list by taking 1 pointer from 1st half and second pointer from another half/end. We can increment first half easily but when it comes to decrease the other pointer, it is hard since it does not info about the previous node. But now, since we have reversed the second half, we can go from n node to n-1 node 

# TC: O(N), SC: O(1)

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

        slow, fast = head, head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # Slow is pointing to middle node

        second = slow.next
        slow.next = None
        # reversing the other half
        prev = None
        while second:
            next = second.next
            second.next = prev
            prev = second
            second = next

        fast = prev
        slow = head

        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp


        



        
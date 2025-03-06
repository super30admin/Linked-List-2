"""
LL Approach
1. Find the mid of the LL using 2p (slow and fast) - make sure odd and even length LL is taken care of
2. Reverse the second part of LL
3. Use an additional pointer (temp) in the first LL
3. Move slow to head of first LL and temp as its next pointer
4. Merge the two LL in required order
TC - n/2 for finding mid + n/2 for reversing half of the LL --> n/2+n/2 = O(n)
SC - O(1)
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
        if head is None and head.next is None: return None

        # set two pointers
        slow = head
        fast = head

        # step 1: find mid (off/even length)
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverseLL(slow.next)
        # break LL
        slow.next = None
        # reset slow to head
        slow = head
        temp = slow.next

        # merge two LL
        while fast is not None:
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            if temp is not None:
                temp = temp.next

        return head

    def reverseLL(self, head):
        if head is None: return

        prev = None
        curr = head
        fast = curr.next

        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        # return head of LL
        return curr
# Time complexity: O(n)
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
        if not head:
            return
        slow = head
        fast = head
        
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        
        ########## Reverse second half, i.e starting from slow #######
        prev = None
        curr = slow
        fast = slow.next
        
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        
        ########################
        ####### Merge two halves #########
        
        first = head # Head of first half
        second = curr # Head of second half
        
        while first:
            # print(first)
            # print(second)
            temp = first.next
            temp2 = second.next
            first.next = second
            second.next = temp
            first = temp
            second = temp2
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Take linkedlist in array, use 2 pointers till l < r
# TC and SC - O(n) and O(n)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        stack = []
        curr = head
        while curr:
            stack.append(curr)
            curr = curr.next
        
        # Reorder the list using two pointers (l and r)
        l, r = 0, len(stack) - 1
        while l < r:
            stack[l].next = stack[r]  # Link left node to right node
            l += 1
            if l >= r:
                break
            stack[r].next = stack[l]  # Link right node to the next left node
            r -= 1
        
        stack[l].next = None
        

        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""
Time Complexity: O(N)

Space Complexity: O(1)
"""

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        slow = fast = head

        while fast.next and fast.next.next: 
            slow = slow.next
            fast = fast.next.next

        # Reverse the next list 

        prev = None 
        curr = slow.next
        slow.next = None # De link the current list 

        # Reverse the list with the pointers curr and prev

        while curr: 
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        ans = curr = head

        # Maintain two temp pointers to store the address of next nodes, apply merging the lists and move curr and prev pointers to next nodes using temps

        while curr != None and prev != None:
            temp = curr.next
            curr.next = prev
            temp2 = prev.next
            prev.next = temp
            curr = temp
            prev = temp2
        
        return head




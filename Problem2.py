# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time Complexity --> O(n) where n is length of the linkedlist
# Space Complexity --> O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Find the mid node of the linkedlist and split into 2 halves
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # reverse the 2nd half of linked list
        curr2 = slow.next
        slow.next = None
        prev = None
        while curr2 is not None:
            temp = curr2.next
            curr2.next = prev
            prev = curr2
            curr2 = temp
        head2 = prev

        curr1 = head
        while curr1 is not None and head2 is not None:
            temp1 = curr1.next 
            curr1.next = head2
            temp2 = head2.next
            head2.next = temp1
            head2 = temp2
            curr1 = temp1 

        

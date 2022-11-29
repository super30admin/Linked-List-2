#Time Complexity :- O(n)
#Space Complexity:- O(1)
#Appraoch :- Divided the linked list in 2 half then reversed the 2nd half and then merged the 2 lists 

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
        slow  = fast =  head 
        while fast.next and fast.next.next:
            slow, fast = slow.next, fast.next.next
        curr = slow.next
        prev = None
        slow.next = None 
        while curr:
            forward = curr.next
            curr.next = prev
            prev = curr
            curr = forward
        curr = prev

        while head.next is not None:
            temp = head.next
            head.next = curr
            curr = curr.next 
            head.next.next = temp
            head = head.next.next
        if curr is not None:
            head.next = curr

             

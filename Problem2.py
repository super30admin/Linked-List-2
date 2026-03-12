#  Reorder List

# Time -> On
# Space -> O1
# Logic, splt the linkedlist into 2 half, and reverse the 2nd half. Then it is just merging of 2 lists

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
        # Found the mid after where the node has to be moved
        slow = head
        fast = head

        while fast!=None and fast.next != None:
            slow = slow.next
            fast=fast.next.next


        #Now break the linkedlist into 2, and reverse the 2nd half
        prev = None
        curr = slow.next
        slow.next = None

        while curr!=None:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp

        # now prev points to the head of revered list(2nd half of orignal) point fast here, and move the slow to the head of 1st list
        slow = head
        fast = prev
        
        while fast != None and slow!= None:
            tmp = slow.next
            slow.next = fast
            fast=fast.next
            slow.next.next=tmp
            slow = tmp
            
        
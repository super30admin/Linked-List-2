#Time complexity: O(n)
# Space complexity: O(1)
# Approach: first find the middle using slow and fast pointers
# secondly, reverse the second part of LL and point the middle to None
# then connect the two separate LL using temp variable


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
        #find middle
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        #reverse second half and detach second half
        prev = None
        curr = slow.next
        if curr and curr.next:
            temp = curr.next
            while(temp != None):
                curr.next = prev
                prev = curr
                curr = temp
                temp = temp.next
            curr.next = prev
            fast = curr
        else:
            fast = curr
        slow.next = None
        # connect two lists
        slow = head
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        #return head
        
        
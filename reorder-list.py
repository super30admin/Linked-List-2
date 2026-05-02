# O(n) time, O(1) space

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
        # 1-2-3-4
        # find the middle
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None: # odd or even length lists
            slow = slow.next
            fast = fast.next.next 
        # 3-4 becomes 4-3
        # reverse 2nd half of list
        fast = self.reverseList(slow.next)

        slow.next = None # break original 
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next=temp
            slow = temp
     

    def reverseList(self, node):
        prev = None
        cur = node
        while cur != None:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev
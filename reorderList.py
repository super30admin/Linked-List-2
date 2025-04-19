# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return 
        
        slow, fast = head,head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        y = slow.next
        slow.next = None

        y = self._reverseList(y)

        x = head

        while y:
            tmp1 = x.next
            tmp2 = y.next

            x.next = y
            y.next = tmp1

            x = tmp1
            y = tmp2
        
    def _reverseList(self,head):
        prev= None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev

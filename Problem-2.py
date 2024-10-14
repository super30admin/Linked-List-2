#T.C = O(n) S.C = O(1)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        while fast!=None and fast.next!=None: 
            slow = slow.next
            fast = fast.next.next

        fast = self.reverseLL(slow.next)
        slow.next = None
        slow = head

        while fast != None: 
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head

    def reverseLL(self,head): 
        prev = None
        curr = head

        while curr !=None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
#LC 143 - Reorder List
#Time Complexity - O(n)
#Space Complxity - O(1)
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
        if not head:
            return head
        def getMerged(head1,head2):
            temp = head1.next
            ans = head1
            while head2.next:
                head1.next = head2
                head2 = head2.next
                head1.next.next = temp
                head1 = temp
                temp = temp.next
            return ans 
        def getReversed(head):
            prev = None
            fast = head.next
            while fast:
                head.next = prev
                prev = head
                head = fast
                fast = fast.next
            head.next = prev
            return head
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        tmp = getReversed(slow)
        return getMerged(head,tmp)
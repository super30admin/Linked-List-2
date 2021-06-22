#Time complexity: O(n)
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        if head is None or head.next is None:
            return
        # find middle
        slowP = head
        fastP = head
        
        while fastP.next is not None and fastP.next.next is not None:
            slowP = slowP.next
            fastP = fastP.next.next
        
        midP = slowP
        
        # reverse second half
        prev = midP
        cur = midP.next
        fast = midP.next.next
        midP.next = None
        
        while fast is not None:
            # cur points to prev to reverse it
            cur.next = prev
            # make prev as cur
            prev = cur
            cur = fast
            #move fast
            fast = fast.next
            
        #merge first simple and second reversed half
        cur.next = prev
        node = head
        while cur is not None and node is not None:
            temp = node.next
            node.next = cur
            cur = cur.next
            node.next.next = temp
            node = temp
        
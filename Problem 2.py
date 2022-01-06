# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time: O(n)
# Space:O(1)
# Algo: Got to the midpint and reversed the second half and inserted them alternatively in the first half
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        prev = slow
        curr = prev.next
        prev.next = None
        while curr != None:
            temp = curr.next
            curr.next = prev
            if temp == None:
                break
            prev = curr
            curr = temp
        #print(curr.val)
        start = head
        while start != None and curr != None:
            temp = start.next
            temp2 = curr.next
            start.next = curr
            curr.next = temp
            if curr == curr.next:
                break
            start = temp
            curr = temp2
        if curr != None:
            curr.next = None
        return head 
            
            
            
        

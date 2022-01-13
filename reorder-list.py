# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        mid = None
        slow = head
        fast = head
        
        # Finding Mid
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        mid = slow.next
        slow.next = None

        # Finding Reverse of second list
        if mid == None:
            return
        curr = mid
        prev = None
        fast = mid.next
        
        while curr != None:
            curr.next = prev
            prev = curr
            curr = fast
            if fast != None: fast = fast.next
        
        head2 = prev
        
        # Merge
        head3 = head
        while head3 != None and head2 != None:
            temp = head3.next
            head3.next = head2
            head2 = head2.next
            head3.next.next = temp
            head3 = temp
        return head
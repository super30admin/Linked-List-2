# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : followed approach from class

class Solution:
    def findMiddle(self, head):
        fast = head
        slow = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        return slow
        
    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
        
    def merge(self, list1, list2):
        tempHead = ListNode(-1)
        curr = tempHead

        l1 = list1
        l2 = list2
        
        while l1 and l2:
            curr.next = l1
            l1 = l1.next
            curr = curr.next
            curr.next = l2
            l2 = l2.next
            curr = curr.next
        
        if not l1:
            curr.next = l2
        if not l2:
            curr.next = l1

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if not head or not head.next or not head.next.next:
            return head
        
        '''At least three nodes in list'''
        
        middle = self.findMiddle(head)
        
        head2 = middle.next
        middle.next = None
        
        head2 = self.reverse(head2)
        
        ret = self.merge(head, head2)
        
        return ret
        
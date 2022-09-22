# TC : O(N)
# SC : O(1)
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
        mid = self.findMid(head)
        mid_next = mid.next
        mid.next = None
        head2 = self.reverse(mid_next)
        head1 = head       
        return self.MergeLL(head1,head2)


        
    def reverse(self,head):        
        prev = None
        curr = head
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        return prev
    
    def findMid(self, head):
        slow = head
        fast = head
        
        while fast.next!= None and fast.next.next!= None:
            fast = fast.next.next
            slow = slow.next            
        
        return slow
    
    def MergeLL(self, head1, head2):
        
        p1 = head1
        p2 = head2       
        
        while p2:
            temp = p1.next
            p1.next = p2
            p2 = p2.next
            p1.next.next = temp
            p1 = temp
            
        return head1
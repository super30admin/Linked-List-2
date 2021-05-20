#time complexity: 0(n)
#space complexity:0(1)  excluding recursive stack of reverse linked list

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    
    def reverse_ll(self,head):
        if head is None or head.next is None:
            return head
        reversedlist = self.reverse_ll(head.next)
        head.next.next = head
        head.next = None
        return reversedlist
    
    def reorderList(self, head):
        
        # find middle
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        fast = slow.next
        slow.next = None
        second_ll = self.reverse_ll(fast)
        
        first_ll = head
        
        while first_ll and second_ll:
            temp = first_ll.next
            first_ll.next = second_ll
            second_ll= second_ll.next
            first_ll.next.next = temp
            first_ll = temp
            
            
            
        return head
            
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        
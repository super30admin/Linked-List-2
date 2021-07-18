
#Time Complexity: O(N).
#Auxiliary Space: O(1)
#Did this code successfully run on Leetcode :Yes


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
        
        #mid point of list
        slow = head
        fast = head
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        
        #reverse list
        def reverse_list(head):
            if head == None or head.next ==None:
                return head
            prev = None
            curr = head
            fast = head.next
            while(fast):
                curr.next = prev
                prev = curr
                curr = fast
                fast = fast.next
            curr.next = prev
            return curr
        
        p2 = reverse_list(slow.next) #
        slow.next = None #break first list 
        p1 = head
        while(p2):
            temp1 = p1.next
            p1.next = p2
            p1 = temp1
            temp2 = p2.next
            p2.next = p1
            p2 = temp2
    
        
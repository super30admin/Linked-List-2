# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    '''Time Complexity: O(n)
    Space Complexity: O(1)'''
    def __reverseList(self,head):
        #Reverse from slow---> slow is at mid position O(n)
        #Three pointers
        prev=None
        curr=head
        fast=head.next
        
        while fast is not None:
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
            
        curr.next=prev
        return curr
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None or head.next.next is None:
            return
        
        #Find mid O(n)
        slow=head
        fast=head
        while fast.next is not None and fast.next.next is not None:
            slow=slow.next
            fast=fast.next.next
            
        #Reverse O(n)
        fast=self.__reverseList(slow.next)
        
        #Reset
        slow.next=None
        
        #Merge O(n)
        slow=head
        while fast is not None:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
            
        
        

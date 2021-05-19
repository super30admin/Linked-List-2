# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        '''
        TC : O(N)
        SC : O(1)
        Approach : 
            Fast and slow pointer is used to reach the center.
            Reverse the second part of the linkedlist 
            Now traverse through both the list simultanously and generate the new list
        '''
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        prev = slow
        ptr = slow.next
        while ptr:
            temp = ptr.next
            ptr.next = prev
            prev = ptr
            ptr = ptr.next
        slow.next = None
        
        ptr1 = head
        while ptr and ptr1:
            temp1 = ptr1.next
            temp2 = ptr.next
            ptr1.next = ptr
            ptr.next = ptr1.next
            ptr1 = temp1
            ptr = temp2
        return head
            
            
            
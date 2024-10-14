#Reorder the list
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
        slow = head
        fast = head

        #middle element

        while fast!=None and fast.next!=None: #T.C -> O(N/2)
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverseLL(slow.next)
        slow.next = None
        slow = head

        #change the connection
        while fast != None: #T.C -> O(N/2)
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head

    def reverseLL(self,head): #T.C -> O(N/2)
        prev = None
        curr = head

        while curr !=None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    

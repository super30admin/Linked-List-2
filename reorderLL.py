# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        
        Time: O(n)
        Space: O(1)
        Missed a thing in logic where I need to set mid.next=None
        """
        
        
        if(head==None or head.next==None):
            return
        # Find middle element
        def middle(ll):
            slow = ll
            fast = ll.next
            while(fast!=None and fast.next!=None):
                slow= slow.next
                fast = fast.next.next
            
            return slow
        
        # reverse the list from middle
        rev = None
        def reverse(mid):
            if(mid.next==None):
                nonlocal rev
                rev = mid
                return
            reverse(mid.next)
            mid.next.next = mid
            mid.next = None
            return
        
        # merge two LL
        def merge(head,rev):
            while(rev!=None):
                temp = head.next
                head.next = rev
                rev = rev.next
                head.next.next = temp
                head = head.next.next
                
        
        
        mid = middle(head)
        # 2 Linked List, upto mid and reversed from end
        reverse(mid.next)
        mid.next=None
        # merge the LL
        
        # reverse LL will be either equal (even length) or one less odd length
        merge(head,rev)

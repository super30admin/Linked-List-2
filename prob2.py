# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        slow = head
       
        fast = head
        while(fast.next != None and fast.next.next != None):
           
            slow = slow.next
            fast = fast.next.next
        
        print(slow.val)
        fast= self.reverse(slow.next)

        slow.next = None
        
        slow = head
        temp = ListNode(-1)
        
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head
        
#         cur = dummy = ListNode(-1)
#         while(list1 and rev):
#             dummy.next =l
#             c = dummy
#             dummy,l =l, l.next
#             c.next = rev
#             d = rev.next
#             rev.next = dummy
            
#             else:
#                 dummy.next = rev
#                 dummy,rev = rev,rev.next
            
#         if(list1 or rev):
#             dummy.next = list1 if list1 else rev

            
        
    
    def reverse(self,List1):
        temp = List1
        prev = None
        if (temp == None):
            return
        while(temp.next):
            after = temp.next
            temp.next = prev
            prev = temp 
            temp = after
        temp.next = prev
        head = temp
        return  head
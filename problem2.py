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
        fast = head
        slow = head
        while fast.next != None and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next
        
        #after breaking out of while loop the slow pointer is at the middle of the list
        
        def reversedList(head):
            if head == None or head.next == None: return head
            dummy = None
            prev = dummy
            curr = head
            nxt = head.next
            
            while nxt != None:
                curr.next = prev
                prev = curr
                curr = nxt
                nxt = nxt.next
           
            
            curr.next = prev
            
            return curr
        

        rptr = reversedList(slow.next)
        slow.next = None
        
        hptr = head
        
        #merge the lists 
        while rptr != None:
            temp = hptr.next
            hptr.next = rptr
            rptr = rptr.next
            hptr.next.next = temp
            hptr = temp
        
#Time complexity is O(n) and space comlexity is O(1)
#2 pointer approach used to find the middle of the list, reverse the second half and then merge the two lists
        
        
        
        
// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: using floys algorithm, after finding mid, we need to revrse the second part of linkelist and compare as 2 separate
lits



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
        if head == None:
            return
        
        slow = head
        fast = head
        
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        
        curr = slow.next
        prev = None
        
        while curr != None:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt    
        #returns prev 
        
        slow.next = None
        temp1 = head
        temp2 = prev
        
        
        while temp2 != None:
            nxt = temp1.next
            temp1.next = temp2
            nxt2 = temp2.next
            temp2.next = nxt
            temp1 = nxt
            temp2 = nxt2
        return temp1

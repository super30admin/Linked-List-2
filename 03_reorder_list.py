'''
Approach
--------
We do this in 3 steps
1. Find the mid of the list
2. reverse the 2nd half of the list
3. reorder the list


Complexity Analysis
-------------------
TC = O(n)
SC = O(1) not storing anything
'''

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
        
        if not head:
            return head
        
        #iterate to find middle of the list
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            

        #reverse the second half    
        second = slow.next
        prev = None
        slow.next = None
        
        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp
        

        #now start merging and reordering
        left = head
        right = prev
        
        while(right and left):
            temp1 = left.next
            temp2 = right.next
            left.next = right
            right.next = temp1
            left = temp1
            right = temp2
# Leetcode problem link : https://leetcode.com/problems/reorder-list/
# Time Complexity : O(n)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n) => Create a new linked list by copying the elements in an array
    
        Optimized approach: O(1) space => The intuition behind this approach is lists can be combined in place by combining various linkedlists algorithms
        1. Find the midpoint as merging needs to be done using two halves
        2. Get midpoint to merge
        3. Reverse second half of the list
        4. Merge one by one for both head
        
'''

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
        if not head:
            return True
        head1 = head
        #1. find midpoint
        mid = self.__findMid(head)
        # 2 . Reverse second half
        head2 = self.__reverse(mid.next)
        mid.next = None
        temp1 = None
        # merge both halves
        while(head2):
            temp1 = head1.next
            head1.next = head2
            temp2 = head2.next
            head2.next = temp1
            head1 = temp1
            head2 = temp2
    
    def __findMid(self,root):
        if not root:
            return None
        slow = root
        fast = root
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def __reverse(self,root):
        if not root:
            return None
        prev = None
        curr = root
        next = None
        while(curr):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev



        
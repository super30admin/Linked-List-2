# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Approach: We need to do the following:
# 1) Locate middle: We will use fast and slow ptr. Fast will move 2 nodes ahead and slow will move 1 node ahead. As soon as fast reaches the end, slow would be at the middle of the list.

# 2) Split into 2 lists from middle: fast will now point to slow.next(2nd half) and slow will again point head(1st half).
# 3) Reverse second list: List pointed by fast will be reversed.
# 4) Rebuild my list: Both lists will be traversed on element at a time and the list will be rebuilded.

# Time Complexity: O(n)
# Space Complexity: O(1)


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None:
            return 
        
        slow = head
        fast = head
        
        while fast!= None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head
        
        # We are considering fast because its the small one
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
    def reverseList(self, head):
        if head == None or head.next == None:
            return head
            
        reversedLs = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return reversedLs
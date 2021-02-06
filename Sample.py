# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    """
    Description: Find the node at which the intersection of 2 singly linked-lists begins
    
    Time Complexicity: O(n)
    Space Complexicity: O(1)
    
    Approach:
    1. find difference in lengths of two list (say d)
    2. depending on whichever list is longer start moving by ignoring first d nodes in longer list
    3. return the matching node
    """
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    
        lenA = 0; lenB = 0
        
        currNode = headA
        while currNode != None:
            currNode = currNode.next
            lenA += 1
        
        currNode = headB
        while currNode != None:
            currNode = currNode.next
            lenB += 1
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
            
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def reorderList(self, head: ListNode) -> None:

        """
        Description: Reorder a linked list
        
        Time Complexicity: O(n)
        Space Complexicity: O(1)
        
        Leetcode Comment:- Do not return anything, modify head in-place instead.
        
        Approach:
        1. Find middle of the linked list
        2. from mid point onwards, reverse the linked list and shorten the orginal linked list until mid point
        3. use both linked list to merge and re-order 
        
        """
        
        if head == None or head.next == None:
            return 
        
        slow = head; fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
    # Function to get reverse linked list
    def reverse(self, head):
        prev = None
        while head:
            temp = head
            head = head.next
            temp.next = prev
            prev = temp
        
        return prev 

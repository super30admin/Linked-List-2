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
        
        Time Complexicity:
        Space Complexicity:
        
        Leetcode Comment:- Do not return anything, modify head in-place instead.
        
        Approach:
        
        """
        slow = head; fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        mirror = self.reverse(slow)
        slow.next = None
        
        slow = head
        while mirror:
            temp = slow.next
            slow.next = mirror
            mirror = mirror.next
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
        

"""
Time Complexity  : O(m+n) where m is the lenght of first LL nad n is the length of second LL
Space Complexity : O(m) where m is the length of the first Linked List
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
#Brute Force
Iterate through the first linked list and append all its nodes address in a set.
Iterate through the second linked list and find if any of the node's address is present in the set.
If yes return the node else return None
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        addFirstLL = set()
        #Store the addresses of all the Nodes of first list in the array
        while headA != None:
            addFirstLL.add(headA)
            headA = headA.next
        
        #Iterate throught the second LL and check if any of the node address is present in FirstLL
        while headB != None:
            if headB in addFirstLL:
                return headB
            headB = headB.next
            
        return None
            
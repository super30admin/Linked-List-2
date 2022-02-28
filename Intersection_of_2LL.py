# TC: O(n); n is the number of nodes in linked list
# SC: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        def length(head):
            l = 0
            while(head!=None):
                l+=1
                head = head.next
            return l
    
        lenA = length(headA)
        lenB = length(headB)
        
        d = abs(lenA-lenB)
        
        if(lenA>lenB):
            first = headA
            second = headB
        else:
            first = headB
            second = headA
        
        while(d>0):
            first = first.next
            d -= 1
            
        while(first!=second):
            first = first.next
            second = second.next
        return first

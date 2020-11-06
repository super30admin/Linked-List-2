"""
Time Complexity O(M+N)
Space Complexity O(1)

-set Ptr1 to HeadA and Ptr2 to HeadB 
-Traverse the list till they reach the end . Once they reach end set them to head of other list 
-Traverse until Ptr1==ptr2. If they meet, return anyof the pointer


"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution_InterNode:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if(headA == None or headB == None):
                return None 
        pt1=headA
        pt2=headB
        
        while(pt1!=pt2):
            if(pt1== None):
                pt1=headB
            elif(pt2==None):
                pt2=headA
            else:
                pt1=pt1.next
                pt2=pt2.next
        return pt1
            
            
            
                
                
            
            
            
        
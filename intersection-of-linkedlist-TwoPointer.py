# Time Complexity : O(n+m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        lenA=0
        lenB=0
        ptr1=headA
        ptr2=headB
       
        while ptr1!=None:
            lenA+=1
            ptr1=ptr1.next          
        while ptr2!=None:
            lenB+=1
            ptr2 = ptr2.next
        diff=abs(lenA-lenB)  

        def ans1(big_list: ListNode,small_list: ListNode,diff: int ):         
            length=0
            ptrB=big_list
            ptrS=small_list
            
            while length<diff:
                ptrB=ptrB.next
                length+=1
            
            while ptrB!=None:
                if ptrB==ptrS:
                    return ptrB
                ptrS=ptrS.next
                ptrB=ptrB.next
            return None
            
        if lenA<lenB:
            return ans1(headB, headA,diff)
            
        else:
            return ans1(headA, headB,diff)
            
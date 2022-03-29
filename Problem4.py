#Time Complexity : O(N + M)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        curr1 = headA
        curr2 = headB
        count1 = 0
        count2 = 0
        
        #FIRST FIND LENGTH OF BOTH LINKED LIST
        while curr1!=None:
            curr1 = curr1.next
            count1+=1
        while curr2!=None:
            curr2 = curr2.next
            count2+=1

        #MOVE THE POINTER OF GREATER LINKEDLIST TO NEXT UNTIL EQUAL LENGTH 
            
        while count1 > count2:
            headA = headA.next
            count1 -=1
            
        while count2 > count1:
            headB = headB.next
            count2 -=1

        #ITERATE BOTH LISTS AND COMPARE 
        curr1 = headA
        curr2 = headB
            
        while curr1 != curr2:
 
            curr1 = curr1.next
            curr2 = curr2.next
        
        return curr1
            
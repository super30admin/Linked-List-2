# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : intutuin behind the lenght and remains in the list and some implementation


# // Your code here along with comments explaining your approach
# count the length of both lists 
# iterate over the bigger list till count becomes same 
# since the length is same till intersection keep moving pointers on both list until they meet and then return the node 

# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA,countB,dummyA,dummyB = 0,0,headA,headB
        while dummyA and dummyA.next:
            dummyA = dummyA.next
            countA+=1
        while dummyB and dummyB.next:
            dummyB = dummyB.next
            countB+=1
  
        while countA > countB:
            headA = headA.next
            countA-=1
        while countB >countA:
            headB = headB.next
            countB-=1

        while headA!=headB:
            headA = headA.next
            headB= headB.next
        return headA
        
        
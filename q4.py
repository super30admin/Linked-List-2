from typing import Optional
# Time Complexity : O(max(len1,len2)), Where len1, len2 is the length of two linked lists given
# Space Complexity : O(max(len1,len2)), Where len1, len2 is the length of two linked lists given
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        hashset=set()
        temp=headA
        is_intersection=False
        #We are iterarting for storing the values of the nodes in one linked list
        while(temp!=None):
            hashset.add(temp)
            temp=temp.next
        #print(hashset)
        temp=headB
        #We are iterating to find the given element is present in the set
        while(temp!=None):
            if(temp in hashset):
                #We are at the place of intersection
                is_intersection=True
                break
            temp=temp.next
        if(is_intersection):
            return temp
        else:
            return None
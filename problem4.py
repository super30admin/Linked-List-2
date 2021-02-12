// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        temp1=headA
        len1=0
        while temp1:        //calculate length of list 1
            len1+=1
            temp1=temp1.next
        
        temp2=headB
        len2=0
        while temp2:        //calculate length of list 2
            len2+=1
            temp2=temp2.next
        
        temp1=headA
        temp2=headB
        
        if len1>len2:       //if len1>len2 =>increment temp1 till both the lists have same number of nodes
            while len1!=len2:
                len1-=1
                temp1=temp1.next
        else:                   //else increment temp2
            while len1!=len2:
                len2-=1
                temp2=temp2.next
            
        while temp1 and temp2 and temp1!=temp2:     //iteratate till end of anyone list or till both the pointers point to same node
            temp1=temp1.next
            temp2=temp2.next
        
        if temp1==temp2:        //if both the pointers point to same node return that node else return null
            return temp1
        else:
            return None
            
        
                
        

#Time Complexity : O(m+n) 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        len1=0
        len2=0
        
        last_of_1st=None
        last_of_2nd=None
        
        cur1=headA
        while cur1!=None:
            len1+=1
            if cur1.next==None:
                last_of_1st=cur1
            cur1=cur1.next
            
        cur2=headB    
        while cur2!=None:
            len2+=1
            if cur2.next==None:
                last_of_2nd=cur2
            cur2=cur2.next
        
        #print(len1, len2)
        #print(last_of_1st, last_of_2nd)
        
        
        if last_of_1st!=last_of_2nd:
            return None
        
        elif len1==len2:
            temp1=headA
            temp2=headB
        
        elif len1!=len2:
            len_diff=abs(len1-len2)
            if len1>len2:
                temp1=headA
                count=0
                while count<len_diff:
                    temp1=temp1.next
                    count+=1
                temp2=headB
                
            elif len2>len1:
                temp2=headB
                count=0
                while count<len_diff:
                    temp2=temp2.next
                    count+=1
                temp1=headA    
        
        #print(temp1,temp2)
        
        
        while temp1!=None:
            if temp1==temp2:
                return temp1
            temp1=temp1.next
            temp2=temp2.next
        return None    
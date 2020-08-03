"""
Problem:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Approach 1: BY making a cycle

1. connect the tail of the list to one of the other head to make a cycle 
2. find the cycle in the list by taking the other head as the head
3. find the point of start of the cycle, this start of cycle will be the intersection point

"""
# Time Complexity : O(max(m,n)) where m and n are the lengths of the lists
# Space Complexity : O(1) amortized cost 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        slow = headA
        fast = headA
        temp = headA
        flag=0
        
        if(headA==None or headB==None):
            return None
        
        while(temp.next!=None):
            temp = temp.next
        
        temp.next = headB
        
        while (fast!=None and fast.next!=None):
            slow = slow.next
            fast = fast.next.next
            if(slow == fast):
                flag=1
                break
        
        if (flag):
            slow = headA
            while(slow!=fast):
                slow= slow.next
                fast = fast.next
            temp.next=None
            return slow   
        else:
            temp.next=None
            return None
        

"""
Problem:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Approach 1: BY finding the lengths of the 2 lists

1. find the lengths of bothe the lists
2. find the difference between the lengths
3. move the head of the bigger list by the difference of lengths
4. move both the heads by 1 step untill they meet, the point where they meet will be the intersection point

"""
# Time Complexity : O(max(m,n)) where m and n are the lengths of the lists
# Space Complexity : O(1) amortized cost 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if (headA==None or headB==None):
            return None
        tempA= headA
        tempB= headB
        countA= 1
        countB= 1
        
        #find lengths of 2 lists
        while(tempA!=None):
            tempA = tempA.next
            countA+=1
        while(tempB!=None):
            tempB = tempB.next
            countB+=1
            
        tempA,tempB=headA,headB
        if countA>countB:
            diff = countA-countB
            count=0
            while(count<diff):
                tempA= tempA.next
                count+=1
                
        if countA<countB:
            diff = countB-countA
            count=0
            while(count<diff):
                tempB=tempB.next
                count+=1
                
        while(tempA!=None ):
            if(tempA==tempB):
                return tempB
            tempA=tempA.next
            tempB= tempB.next
            
        return None
        
    
        
        
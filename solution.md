# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
        class Solution:
            def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
                lenA,lenB=0,0   #Initializing length variables
                cur=headA       #Initializing current pointer
                #Base case: Traversing the entire linked list A
                while(cur!=None):
                    lenA+=1
                    cur=cur.next
                cur=headB
                #Base case: Traversing the entire linked list B
                while(cur!=None):
                    lenB+=1
                    cur=cur.next
                #If Linked list B is shorter, place cur pointer (len+head)
                while(lenB<lenA):
                    headA=headA.next
                    lenA-=1
                #If Linked list A is shorter, place cur pointer (len+head)
                while(lenA<lenB):
                    headB=headB.next
                    lenB-=1
                #Condition: Till both headers meet, keep traversing
                while(headA!=headB):
                    headA=headA.next
                    headB=headB.next
                #Return node when headA==headB   
                return headA
 
 # Problem 2
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :


## Any problem you faced while coding this :


## Your code here along with comments explaining your approach
### Solution:


 # Problem 3
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :


## Any problem you faced while coding this :


## Your code here along with comments explaining your approach
### Solution:

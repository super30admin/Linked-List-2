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
O(1)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Ran successfully on Geeks for geeks.


## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
          def deleteNode(curr_node):
               curr_node.data=curr_node.next.data #Replacing curr value with next node value
               curr_node.next=curr_node.next.next #Removing next node 


 # Problem 3
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
No. /
AttributeError: 'NoneType' object has no attribute 'next'

## Any problem you faced while coding this :
Yes. Cannot solve the error.

## Your code here along with comments explaining your approach
### Solution:
        class Solution:
            def reorderList(self, head: ListNode) -> None:
                """
                Do not return anything, modify head in-place instead.
                """
                #Edge case
                if(not head or not head.next):
                    return None

                slow,fast=head,head #Initializing pointers
                #Finding middle
                while(fast.next!=None and fast.next.next):
                    slow=slow.next
                    fast=fast.next.next

                fast=self._reverse(slow.next)    #Calling reverse function
                slow.next=None
                slow=head
                #Logic
                while(fast!=None):
                    curr=slow.next   #ERROR!
                    slow.next=fast
                    fast=fast.next
                    slow.next.next=curr
                    slow=curr


            def _reverse(self,head):
                curr=head
                prev=None
                fast=head.next
                while(fast!=None):
                    curr.next=prev
                    prev=curr
                    fast=fast.next
                curr.next=prev
                return curr

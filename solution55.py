#Time COmplexity:O(max(m,n))
#Space COmplexity:O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA=0                              #Variable to hold length of ListNode A
        lenB=0                              #Variable to hold length of ListNode B
        curr=headA                          #Assign curr pointer to head of ListNode A
        while(curr):                        #until pointer moves to end of ListNode
            curr=curr.next                  #move to the next pointer and increment the length
            lenA+=1
        curr=headB                          #Assign curr pointer to head of ListNode B
        while(curr):                        #until pointer moves to end of ListNode
            curr=curr.next                  #move to the next pointer and increment the length
            lenB+=1
        while(lenA>lenB):                   #if LinkedList A is Longer 
            headA=headA.next                #move the head until its length is same as LinkedList B
            lenA-=1
        while(lenB>lenA):                   #if LinkedList B is Longer 
            headB=headB.next                #move the head until its length is same as LinkedList A
            lenB-=1
        while(headA!=headB):                #parse starting from both linked list head to find an intersection
            headA=headA.next
            headB=headB.next
        return headA                        #return the intersection point
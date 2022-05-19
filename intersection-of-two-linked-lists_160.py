#Approach1: Find the length of list1 and list2, find the difference and move pointer of bigger link list to that of same length of smaller one
#then move one nodes from both lists step by step if they match there is an intersection or there is no intersection point

#Time Complexity O(M) + O(N) for traversing first Linklist and again distance till intersection, so big O notation is O(M+N)
#Space Complexity O(1) No extra space
#It successfully runs on the leetcode
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = l2= 0
        #Find length of both te list
        curA, curB = headA, headB
        while curA:
            l1+=1
            curA= curA.next
        while curB:
            l2+=1
            curB= curB.next
        #Make both lists of equal size 
        if l1>l2:
            for _ in range(l1-l2):
                headA = headA.next
        if l2>l1:
            for _ in range(l2-l1):
                headB = headB.next

        #Find the intersection   
        while headA!=headB:
            headA = headA.next
            headB = headB.next
            
        return headA


#Approach1: Store all the pointer nodes of link list to headset, then start matching other linklist nodes to hashset 
#the first matching node is an intersection point

#Time Complexity O(M) + O(N) One pass for traversing first Linklist for storing it in hashset and 
#traversing other linklist to check wether there is an intersection or not, so O(M+N)
#Space Complexity O(N) for hashset
#It successfully runs on the leetcode

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s= set()
        cur = headA
        while cur:
            s.add(cur)
            cur= cur.next
        cur = headB
        while cur:
            if cur in s:
                return cur
            cur= cur.next
#Time Complexity : O(N+M)
#Space Complexity : O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        #Pointer to point Head of List A
        currA = headA
        #Pointer to point Head of List B
        currB = headB
        countA = 0
        countB = 0
        #To find the length of List A
        while(currA!=None):
            currA = currA.next
            countA+=1
        #To find the length of List B
        while(currB!=None):
            currB= currB.next
            countB+=1
        #Set the pointer to heads of lists
        currA = headA
        currB = headB
        #To choose which list to traverse based on their length (Bigger one)
        while(countA>countB):
            currA=currA.next
            countA-=1
        while(countB>countA):
            currB=currB.next
            countB-=1
        #The pointer is set at the bigger list now in such a way that both reach their ends at the same time
        while(currA!=currB):
            currA = currA.next
            currB = currB.next
        #When the above while condition is true both pointers are pointing to same node return
        return currA
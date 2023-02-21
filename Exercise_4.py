#Time Complexity : O(M+N), where M and N are the lengths of the arrays.
#Space Complexity : O(1), no additional array is used.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Was a little uncertain with the indices, but
# it ended up running fine. 
#Your code here along with comments explaining your approach in three sentences only
'''Traverse through both arrays and then find the difference in length. Traverse through
the larger array for number of nodes equal to the difference in length. Then, continue
traversing until the nodes equal. 
'''

class Solution:
    # function to get length of array. 
    def getLength(self,head):
        count = 0
        temp = head
        while(temp!=None):
            count = count+1
            temp = temp.next
        return count
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        #obtain the lengths of array. 
        countA = self.getLength(headA)
        countB = self.getLength(headB)

        #obtain difference and traverse the longer array diff number of times. 
        if countA>countB:
            diff = countA-countB
            temp = 0
            while(temp<diff):
                headA = headA.next
                temp = temp+1
        if countB>countA:
            diff = countB-countA
            temp = 0
            while(temp<diff):
                headB = headB.next
                temp = temp+1
        tempA = headA
        tempB = headB

        #traverse through both nodes until the node is equal, then return one of the node. 
        while(tempA!=tempB):
            tempA = tempA.next
            tempB = tempB.next
        return tempA

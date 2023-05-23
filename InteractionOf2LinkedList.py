#TC: O(n)
#SC: O(1)

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def __getLength(self, head):

        count = 0

        if (head == None):
            return count

        currNode = head

        while (currNode != None):
            currNode = currNode.next
            count += 1

        return count

    def getIntersectionNode(self, headA, headB):
        
        if (headA == None or headB == None):
            return None

        countA = self.__getLength(headA)
        countB = self.__getLength(headB)

        if (countA > countB):
            diff = countA - countB
            count = 0

            fastNode = headA
            while (count < diff):
                fastNode = fastNode.next
                count += 1

            slowNode = headB

            while (fastNode != None):
                if (slowNode == fastNode):
                    return slowNode
                slowNode = slowNode.next
                fastNode = fastNode.next

            return None

        else:
            diff = countB - countA
            count = 0

            fastNode = headB
            while (count < diff):
                fastNode = fastNode.next
                count += 1

            slowNode = headA

            while (fastNode != None):
                if (slowNode == fastNode):
                    return slowNode
                slowNode = slowNode.next
                fastNode = fastNode.next

            return None

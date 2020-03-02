'''
Solution
1.  Find lengths of both the LLs. Take the difference
2.  Move forward the pointer on longest LL upto obtained difference number of times.
3.  Move pointers in both LLs at the same pace and check for intersection.

Time Complexity: O(n) and Space Complexity: O(1)

--- Passed all Testcases on Leetcode successfully
'''

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class FindIntersection(object):

    def __getLength(self, head):

        '''
        :param head: head of the LL
        :return: length of the LL
        '''

        count = 0

        if (head == None):
            return count

        currNode = head

        while (currNode != None):
            currNode = currNode.next
            count += 1

        return count

    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """

        #   edge case check
        if (headA == None or headB == None):
            return None

        #   obtain lengths using a private method
        countA = self.__getLength(headA)
        countB = self.__getLength(headB)

        #   if first LL is bigger
        if (countA > countB):
            diff = countA - countB
            count = 0

            #   initialize fast pointer to head of LinkedList-A and move it upto the difference
            fastNode = headA
            while (count < diff):
                fastNode = fastNode.next
                count += 1

            #   initialize slow pointer to head of LinkedList-B
            slowNode = headB

            #   move both the pointers until they intersect or reach the end.
            while (fastNode != None):
                if (slowNode == fastNode):
                    return slowNode
                slowNode = slowNode.next
                fastNode = fastNode.next

            return None

        #   if second LL is bigger
        else:
            diff = countB - countA
            count = 0

            #   initialize fast pointer to head of LinkedList-B and move it upto the difference
            fastNode = headB
            while (count < diff):
                fastNode = fastNode.next
                count += 1

            #   initialize slow pointer to head of LinkedList-B
            slowNode = headA

            #   move both the pointers until they intersect or reach the end.
            while (fastNode != None):
                if (slowNode == fastNode):
                    return slowNode
                slowNode = slowNode.next
                fastNode = fastNode.next

            return None


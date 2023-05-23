#TC: O(n)
#SC: O(1)

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def __reverse(self, head):
        
        prevNode = None
        currNode = head
        nextNode = head.next

        while (nextNode != None):
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            nextNode = nextNode.next

        currNode.next = prevNode
        return currNode

    def reorderList(self, head):
        
        if (head == None or head.next == None or head.next.next == None):
            return head

        slowNode = head
        fastNode = head.next

        while (fastNode != None and fastNode.next != None):
            slowNode = slowNode.next
            fastNode = fastNode.next.next

        fastNode = self.__reverse(slowNode.next)
        slowNode.next = None
        slowNode = head

        while (fastNode != None):
            tempNode = slowNode.next
            slowNode.next = fastNode
            slowNode = tempNode
            tempNode = fastNode.next
            fastNode.next = slowNode
            fastNode = tempNode

        return
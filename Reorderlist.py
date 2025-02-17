class Solution:
    def __reverse(self, head):
        '''
        :param head: head of the Linked list
        :return: reversed Linked List
        '''
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
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
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
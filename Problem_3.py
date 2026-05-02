class Solution:
    def deleteNode(self, del_node):
        nextNode = del_node.next
        del_node.data = nextNode.data
        del_node.next = nextNode.next
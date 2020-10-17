class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def deleteNode(curr_node):
    #code here
    if curr_node.next:
        curr_node.val = curr_node.next.val
        curr_node.next = curr_node.next.next
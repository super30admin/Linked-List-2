'''
Time complexity --> O(n)

Space Complexity --> O(1)
'''

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def DeleteNode(node):
    curr = node
    while curr.next:
        curr.val, curr.next.val = curr.next.val, curr.val
    del(curr)

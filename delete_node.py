"""
    You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes.
    The task is to delete the node. Pointer/ reference to head node is not given.
    Note: No head reference is given to you.
"""


def deleteNode(node):
    """
        // Time Complexity : O(1)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : N/A
        // Three line explanation of solution in plain english :
            - Copy value of the next node val to the cur node (to which reference is given)
            - Change pointer of the cur.next node to cur.next.next
    """
    if node.next:
        node.val = node.next.val
        node.next = node.next.next
    else:
        node = None

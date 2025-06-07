# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def deleteNode(del_node):
    """
    Deletes the given node (except the tail) from the linked list.
    :type del_node: ListNode
    :rtype: void Do not return anything, modify del_node in-place instead.
    """
    if del_node is None or del_node.next is None:
        raise Exception("Cannot delete the last node or a null node with this method.")
    del_node.val = del_node.next.val
    del_node.next = del_node.next.next

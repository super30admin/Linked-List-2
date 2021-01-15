'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Not on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Swap Current node's value with the next node.
        And, then delete the last node.
'''
def deleteNode(curr_node):
    prev = None
    while curr_node.next:
        curr_node.data = curr_node.next.data
        prev = curr_node
        curr_node = curr_node.next

    if prev:
        prev.next = None

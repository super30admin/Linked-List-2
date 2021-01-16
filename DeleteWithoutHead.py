'''
    Time Complexity:
        O(1)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Not on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Swap current node's value with the next node.
        Set the current node's next to current node's next's next.
'''
def deleteNode(curr_node):
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next

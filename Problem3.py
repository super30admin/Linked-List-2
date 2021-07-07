#
# Time Complexity = O(n)
# Space Complexity = O(1)
#

def delete_node(node):
    if not node:
        return
    while node.next:
        node.data = node.next.data
        prev = node
        node = node.next
    prev.next = None

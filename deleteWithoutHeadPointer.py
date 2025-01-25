def deleteWithoutHeadPointer(node:Optional[ListNode]):
    # TC : O(1)
    # SC : O(1)
    if node is None:
        return
    node.val = node.next.val
    node.next = node.next.next
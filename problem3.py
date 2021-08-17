#delete without head pointer
#delete without head pointer
#time compleixty: O(1)
#space complexity: O(1)
def deletenode(curr):
    if curr is None:
        return
    if curr.next is None:
        curr.data = None
        return
    elif curr.next.next is None:
        curr.data = curr.next.data
        curr.next = None
        return
    curr.data = curr.next.data
    deletenode(curr.next)
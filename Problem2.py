#Not sure if this solution will work

def del_func(node):
    if node is None:
        return
    if node.next is None:
        node.val = None
    while node:
        node.val = node.next.val
        node = node.next
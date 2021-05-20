# time complexity : 0(1)
#space cmplexity: 0(1)

class node:
    def __init__(self,data):
        self.data = data
        self.next - None


def delete_node(node_ptr):
    temp = node_ptr.next
    node_ptr.data = temp.data
    node_ptr.next = temp.next


head = node(1)
head.next  = node(2)
head.next = node(3)
head.next.next = node(4)




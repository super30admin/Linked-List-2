class ListNode:
    def __init__(self, x=None, next=None):
        self.val = x
        self.next = next

    def __str__(self):
        node = self
        result = ""
        while node:
            result += f"{node.val},"
            node = node.next
        result += "None"
        return result

    def to_array(self):
        node = self
        result = []
        while node and node.val:
            result.append(node.val)
            node = node.next
        #result += "None"
        return result

    def append(self, value):
        node = self
        if not node.val:
            node.val = value
        else:
            new = ListNode(value)
            while node.next:
                #result += f"{node.value} -> "
                node = node.next
            node.next = new

def build_linked_list(values):
    linked_list = ListNode()
    for v in values:
        linked_list.append(v)
    return linked_list
//approach - if next of given node is not null, copy the value of next node to current node and make current's next point to next's next
//if the next of given node is null, make current node null

//time - constant
//space - consatnt

public void deleteNode(ListNode node) {
  if(node.next == null)
  {
    node = null;
  }
  else
  {
    node.val = node.next.val;
    node.next = node.next.next;
  }
  return;
}

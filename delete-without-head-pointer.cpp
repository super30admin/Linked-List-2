//Time complexity - O(n)
//space complexity- O(1)

void deleteNode(Node *node)
{
   // Your code here
   Node* prev;
   while(node && node->next){
       node->data = node->next->data;
       prev = node;
       node = node->next;
   }
   prev->next = NULL;
}
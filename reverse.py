class Solution:
    def reverseKGroup(self, head, k):
        # 1. Check if there are at least k nodes remaining
        curr = head
        for _ in range(k):
            if not curr:
                return head
            curr = curr.next
        
        # 2. Reverse the current group of k nodes
        prev = None
        curr_node = head
        for _ in range(k):
            nxt = curr_node.next
            curr_node.next = prev
            prev = curr_node
            curr_node = nxt
        
        # 3. Reconnect and recurse
        # 'head' is now the tail of this reversed group
        head.next = self.reverseKGroup(curr_node, k)
        
        return prev

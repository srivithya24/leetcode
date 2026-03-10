class Solution(object):
    def isValid(self, s):
        # A stack to keep track of opening brackets
        stack = []
        
        # A map to easily match closing brackets to their opening counterparts
        mapping = {")": "(", "}": "{", "]": "["}

        for char in s:
            # If the character is a closing bracket
            if char in mapping:
                # Pop the top element from stack if it's not empty, otherwise use a dummy
                top_element = stack.pop() if stack else '#'
                
                # Check if the popped opening bracket matches the required mapping
                if mapping[char] != top_element:
                    return False
            else:
                # If it's an opening bracket, push it onto the stack
                stack.append(char)

        # If the stack is empty, all brackets were matched correctly
        return not stack

# Example usage to verify the cases:
sol = Solution()
print(sol.isValid("()"))      # True
print(sol.isValid("()[]{}"))  # True
print(sol.isValid("(]"))      # False
print(sol.isValid("([])"))    # True
print(sol.isValid("([)]"))    # False
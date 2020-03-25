class BinaryTree:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

    def display(self):
        lines, _, _, _ = self._display_aux()
        for line in lines:
            print(line)

    def __str__(self):
        return str(self.val)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.val
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2

def get_sample_binary_tree():
    root = BinaryTree(1)
    root.left = BinaryTree(2)
    root.right = BinaryTree(3)
    root.left.left = BinaryTree(4)
    root.left.right = BinaryTree(5)
    root.display()
    return root

def get_sample_bst():
    root = BinaryTree(15)

    root.left = BinaryTree(10)
    root.left.parent = root 
    root.left.left = BinaryTree(9)
    root.left.left.parent = root.left
    root.left.right = BinaryTree(12)
    root.left.right.parent = root.left
    root.left.right.left = BinaryTree(11)
    root.left.right.left.parent = root.left.right
    root.left.right.right = BinaryTree(13)
    root.left.right.right.parent = root.left.right

    root.right = BinaryTree(30)
    root.right.parent = root
    root.right.left = BinaryTree(16)
    root.right.left.parent = root.right
    root.right.right = BinaryTree(33)
    root.right.right.parent = root.right
    root.right.right.left = BinaryTree(32)
    root.right.right.left.parent = root.right.right
    root.right.right.right = BinaryTree(35)
    root.right.right.right.parent = root.right.right

    root.display()
    return root

  
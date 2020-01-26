from binary_tree import BinaryTree,get_sample_binary_tree

balanced = True

def check_balance(bt):
    height(bt)
    return balanced

def is_leaf_node(bt):
    return bt.left is None and bt.right is None

def height(bt):
    global balanced
    if bt is None or is_leaf_node(bt) or not balanced:
        return 0

    lh = height(bt.left)
    rh = height(bt.right)

    if(abs(lh - rh) > 1):
        balanced = False
        return 0

    return max(lh,rh) + 1

def main():
    bt = get_sample_binary_tree()
    node = BinaryTree(6)
    bt.left.left.left = node
    bt.display()
    print check_balance(bt)



if __name__ == '__main__':
    main()
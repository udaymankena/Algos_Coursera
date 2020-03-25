# first common ancestor in a binary tree

from binary_tree import get_sample_binary_tree

def has_node(bt,node):
    if bt is None:
        return False
    if(bt.val == node.val):
        return True
    # if has_node(bt.left,node):
    #     return True
    # else:
    #     return has_node(bt.right,node)
    return has_node(bt.left,node) or has_node(bt.right,node)


def commn_ancstr(bt, n1, n2):
    if n1.val == bt.val or n2.val == bt.val:
        return None
    # n1 is on left? if not it's on right
    n1_on_left = has_node(bt.left,n1)
    n2_on_left = has_node(bt.left,n2)
    
    if n1_on_left != n2_on_left:
        return bt
    else:
        if n1_on_left:
            if bt.left.val == n1.val or bt.left.val == n2.val:
                return bt
            return commn_ancstr(bt.left,n1,n2)
        else:
            if bt.right.val == n1.val or bt.right.val == n2.val:
                return bt
            return commn_ancstr(bt.right,n1,n2)
    


def main():
    bt = get_sample_binary_tree()
    print("common ancestor: ", commn_ancstr(bt, bt.left.left, bt.left.right))


if __name__ == "__main__":
    main()

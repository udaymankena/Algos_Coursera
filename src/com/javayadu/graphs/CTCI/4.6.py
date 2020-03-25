# inorder successor of a node in BST

from binary_tree_wt_prnt import get_sample_bst

def rt_inordr(node):
    if(node.left is None):
        return node
    else:
        rt_inordr(root.left)

def prnt_bkwrds(node):
    prnt = node.parent
    if(prnt is None): # node is root
        return None

    # if node is left to the parent then parent is the successor
    if(node.val < prnt.val):
        return prnt
    prnt_bkwrds(prnt)


def inordr_sucsr(node):
    # if the node has a right subtree
    if(node.right is not None):
        return rt_inordr(node.right)
    else:
        return prnt_bkwrds(node)



def main():
    bst = get_sample_bst()
    node = bst.right.right.left
    print("node : " + str(node))
    print( str( inordr_sucsr(node) ) )

if __name__ == "__main__":
    main()
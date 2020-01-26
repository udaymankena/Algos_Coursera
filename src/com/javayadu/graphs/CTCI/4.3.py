from binary_tree import BinaryTree, get_sample_binary_tree

# time complexity
"""
say depth of tree = d
"""

level_nodes = {}

def inorder(node,level):
    #print("level: " + str(level))
    if(node is None):
        return
    inorder(node.left,level+1)
    if not level_nodes.has_key(level):
        l = []
        l.append(node)
        level_nodes[level] = l
    else:
        l = level_nodes[level]
        l.append(node)
        level_nodes[level] = l

    inorder(node.right,level+1)


def ll_at_each_depth(bt):
    inorder(bt,0)

def main():
    bt = get_sample_binary_tree()
    ll_at_each_depth(bt)
    for level in level_nodes:
        print(str(level) + ":")
        for node in level_nodes[level]:
            print str(node)



if __name__ == '__main__':
    main()
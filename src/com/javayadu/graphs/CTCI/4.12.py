from binary_tree import get_sample_binary_tree,get_sample_bst

def is_leaf(node):
    return node.left is None and node.right is None

def get_new_paths(curr_paths, child_val, root_val):
    paths = []
    for path in curr_paths:
        if path[len(path)-1] == child_val:
            new_path = []
            new_path.extend(path)
            new_path.append(root_val)
            paths.append(new_path)
    return paths

def get_paths(root):
    if is_leaf(root):
        return [[root.val]]
    paths = []
    paths.append([root.val])
    lp = get_paths(root.left)
    rp = get_paths(root.right)
    lp_new = get_new_paths(lp,root.left.val,root.val)
    rp_new = get_new_paths(rp,root.right.val,root.val)
    
    paths.extend(lp)
    paths.extend(rp)
    paths.extend(lp_new)
    paths.extend(rp_new)
    return paths
    

def paths_with_sum(bt,gvn_sum):
    tot_paths = get_paths(bt)
    cnt = 0
    for path in tot_paths:
        if sum(path) == gvn_sum:
            print(path)
            cnt = cnt+1
    return cnt

def main():
    bt = get_sample_binary_tree()
    print( paths_with_sum(bt,3) )

if __name__ == '__main__':
    main()
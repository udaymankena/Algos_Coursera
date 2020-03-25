# Do a level order traversal of the bst. At each level, get the possible element combinations
# cross join of all the levels would be all the possible ways to express the BST as an array

from binary_tree import get_sample_bst

def combs(arr):
    tot_combs= []
    for i in range(len(arr)):
        tot_combs = combs_wt_elmt(arr[i],tot_combs)
    return tot_combs

def combs_wt_elmt(elmt, prev_combs):
    if len(prev_combs) == 0:
        return [[elmt]]
    combs = []
    for prev_comb in prev_combs:
        prev_comb.append(elmt)
        combs.append(prev_comb.copy())
        i = len(prev_comb) - 1
        while(i > 0):
            k = prev_comb[i]
            prev_comb[i] = prev_comb[i-1]
            prev_comb[i-1] = k
            combs.append(prev_comb.copy())
            i = i-1
    return combs


def lot(bst):
    #lot - Level order traversal
    levels = [[bst]]
    lvl_combs = [[[bst]]]
    curr_list = [bst]
    while len( levels[len(levels)-1] ) > 0:
        next_lvl = []
        for node in curr_list:
            if node.left is not None:
                next_lvl.append(node.left)
            if node.right is not None:
                next_lvl.append(node.right)
        curr_list = next_lvl
        levels.append(next_lvl)
        lvl_combs.append(combs(next_lvl))
    #print("level combs: ", lvl_combs)
    return lvl_combs


"""
[
    [ [] ]
    [ [], [] ]
    [ [], [], [], [], [], [] ]
    
]
"""
def merge_paths(l1, l2):
    if l2 is None or len(l2) == 0:
        return l1
    paths = []
    for i in range(len(l1)):
        for j in range(len(l2)):
            l = l1[i].copy()
            l.extend(l2[j])
            paths.append(l)
    #print("paths: ", paths)
    return paths


def arr_combs(bst):
    lvl_combs = lot(bst)
    finl_paths = lvl_combs[0]
    # print("finl paths: ", finl_paths)
    for i in range(1,len(lvl_combs)):
        finl_paths = merge_paths(finl_paths,lvl_combs[i])
    return finl_paths

def main():
    bst = get_sample_bst()
    for comb in arr_combs(bst):
        print( [node.val for node in comb])

if __name__ == '__main__':
    main()


# l = [1,2,3,4]
# b = l.copy()
# b.append(10)
# print(b)

# first common ancestor in a binary tree

from binary_tree import get_sample_binary_tree


def path(bt, ancestors, node):
    if bt is None:
        return None
    if bt.val == node.val:
        return ancestors
    la = ancestors.copy()
    la.append(bt)
    lp = path(bt.left, la, node)
    if lp is not None:
        return lp
    ra = ancestors.copy()
    ra.append(bt)
    rp = path(bt.right, ra, node)
    return rp


def commn_ancstr(bt, n1, n2):
    if n1.val == bt.val or n2.val == bt.val:
        return bt
    p1 = path(bt, [], n1)
    p2 = path(bt, [], n2)

    for i in range(len(p1)):
        if i > len(p2) - 1 or p1[i].val != p2[i].val:
            return p1[i - 1]

    return p2[len(p2) - 1]


def main():
    bt = get_sample_binary_tree()
    print("common ancestor: ", commn_ancstr(bt, bt.left, bt.right))


if __name__ == "__main__":
    main()

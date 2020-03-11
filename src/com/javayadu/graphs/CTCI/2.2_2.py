# kth element from the last

from linked_list import get_sample_ll

def len_of_ll(ll):
    if ll is None:
        return 0
    l = 0
    while(ll is not None):
        l = l + 1
        ll = ll.next
    return l

def kth_from_last(ll,k):
    if ll is None:
        return (0,None)
    tup = kth_from_last(ll.next,k)
    print(tup)
    index = tup[0] + 1
    if index == k:
        return(index,ll)
    if tup[1] is not None:
        return (index,tup[1])
    return (index,None)

def main():
    ll = get_sample_ll()
    k = 4
    print(kth_from_last(ll,k)[1].val)

if __name__ == '__main__':
    main()
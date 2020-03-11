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
    k_ind = len_of_ll(ll) - k
    while(k_ind > 0 ):
        if k_ind == 1:
            return ll
        ll = ll.next
        k_ind = k_ind - 1

def main():
    ll = get_sample_ll()
    k = 5
    print(kth_from_last(ll,k).val)

if __name__ == '__main__':
    main()
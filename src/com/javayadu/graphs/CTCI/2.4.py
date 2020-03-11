from linked_list import get_sample_ll,get_sample_ll2

def partition(ll,p):
    l = None
    prev = None
    r = None
    while(ll is not None):
        if ll.val < p:
            if l is None:
                if r is not None:
                    l = ll
                    prev.next = ll.next
                    l.next = r
                    ll = prev.next
                else:
                    l = ll
                    prev = ll
                    ll = ll.next
            else:
                prev.next = ll.next
                ll.next = l
                l = ll
                ll = prev.next
        elif ll.val >= p:
            if r is None and l is None:
                r = ll
            prev = ll
            ll = ll.next
    return l

def display_ll(ll):
    ll_str = ""
    while(ll is not None):
        ll_str = ll_str + str(ll.val) + " --> "
        ll = ll.next
    print(ll_str)

def main():
    ll = get_sample_ll2()
    p = 3
    pl = partition(ll,p)
    display_ll(pl)

if __name__ == '__main__':
    main()
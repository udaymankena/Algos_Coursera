from linked_list import get_sample_ll,display_ll,len_of_ll,get_sample_ll2

def node_at_ind(ll,ind):
    if ind == 1:
        return ll
    while(ind > 1):
        ll = ll.next
        ind = ind - 1
    return ll

def palindrome(ll):
    len = len_of_ll(ll)
    l = 0 
    r = 0
    if len % 2 == 0:
        l = len//2
        r = l+1
    else:
        l = len//2
        r = l + 2
    r_n = node_at_ind(ll,r)
    while(l != 0 and r_n is not None):
        l_n = node_at_ind(ll,l)
        if l_n.val != r_n.val:
            return False
        l = l-1
        r_n = r_n.next
    return True



def main():
    ll = get_sample_ll2()
    print(palindrome(ll))

if __name__ == '__main__':
    main()
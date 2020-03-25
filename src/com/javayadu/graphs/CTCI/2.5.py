from linked_list import get_sample_ll,get_sample_ll2,LinkedList

def len_of_ll(ll):
    if ll is None:
        return 0
    l = 0
    while(ll is not None):
        l = l + 1
        ll = ll.next
    return l

def add_ll_helper(l1,l2):
    if(l1.next is None and l2.next is None):
        curr_sum = l1.val + l2.val
        carry = curr_sum//10
        sum_digit = curr_sum % 10
        l1.val = sum_digit
        return carry
    prev_carry = add_ll_helper(l1.next,l2.next)
    curr_sum = l1.val + l2.val + prev_carry
    curr_carry = curr_sum // 10
    sum_digit = curr_sum % 10
    l1.val = sum_digit
    return curr_carry

def append_zeros_ll(ll,num_of_zeros):
    ll_tail = ll
    while(ll_tail.next is not None):
        ll_tail = ll_tail.next
    while num_of_zeros > 0:
        ll_tail.append(LinkedList(0))
        num_of_zeros = num_of_zeros - 1


def add_two_lls(l1,l2):
    l1_len = len_of_ll(l1)
    l2_len = len_of_ll(l2)
    diff = l1_len - l2_len
    if(diff > 0):
        append_zeros_ll(l2, diff)
    else:
        append_zeros_ll(l1, diff * -1)
    carry  = add_ll_helper(l1,l2)
    if carry != 0:
        cnode = LinkedList(carry)
        cnode.next = l1
        return cnode
    else:
        return l1

def display_ll(ll):
    ll_str = ""
    while(ll is not None):
        ll_str = ll_str + str(ll.val) + " --> "
        ll = ll.next
    print(ll_str)

def main():
    l1 = get_sample_ll()
    l2 = get_sample_ll2()
    sum = add_two_lls(l1,l2)
    display_ll(sum)

if __name__ == '__main__':
    main()
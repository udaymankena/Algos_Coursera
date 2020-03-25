class LinkedList():

    root = None

    def __init__(self,val):
        self.val = val
        self.next = None
        if LinkedList.root is None:
            LinkedList.root = self
    
def del_node(curr,prev):
    if prev is None: # if self is a root
        LinkedList.root = curr.next
        curr = None
    elif curr.next is None: # self is the last node
        prev.next = None
    else:
        prev.next = curr.next
        curr = None

def len_of_ll(ll):
    if ll is None:
        return 0
    l = 0
    while(ll is not None):
        l = l + 1
        ll = ll.next
    return l

def display_ll(ll):
    ll_str = ""
    while(ll is not None):
        ll_str = ll_str + str(ll.val) + " --> "
        ll = ll.next
    print(ll_str)

def get_sample_ll():
    ll = LinkedList(1)
    ll.next = LinkedList(2)
    ll.next.next = LinkedList(1)
    # ll.next.next.next = LinkedList(3)
    # ll.next.next.next.next = LinkedList(7)
    # ll.next.next.next.next.next = LinkedList(1)
    display_ll(ll)
    return ll
    
def get_sample_ll2():
    ll = LinkedList(1)
    ll.next = LinkedList(1)
    ll.next.next = LinkedList(1)
    ll.next.next.next = LinkedList(1)
    ll.next.next.next.next = LinkedList(1)
    ll.next.next.next.next.next = LinkedList(1)
    display_ll(ll)
    return ll
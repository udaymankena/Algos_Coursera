from linked_list import get_sample_ll,display_ll,del_node

def remove_dups(ll):
    while ll is not None:
        print("ll: ", ll.val)
        curr_val = ll.val
        curr_node = ll.next
        prev_node = ll
        while(curr_node is not None):
            #print("curr_node: ", curr_node.val)
            if curr_node.val == curr_val:
                del_node(curr_node,prev_node)
                curr_node = prev_node.next
            else:
                prev_node = curr_node
                curr_node = curr_node.next
        ll = ll.next
        

def main():
    ll = get_sample_ll()
    remove_dups(ll)
    display_ll()

if __name__ == "__main__":
    main()
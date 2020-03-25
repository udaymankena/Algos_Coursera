class Element():
    def __init__(self,val):
        self.val = val
    
    def set_min(self,min_val):
        self.min = min_val
    
    def get_min(self):
        return self.min


class Stack():
    def __init__(self):
        self.list = []

    def push(self,elmt):
        if len(self.list) > 0:
            prev_min_el = self.peek()
            if elmt.val < prev_min_el.get_min():
                elmt.set_min(elmt.val)
            else:
                elmt.set_min(prev_min_el.get_min())
        else:
            elmt.set_min(elmt.val)
        self.list.append(elmt)

    def pop(self):
        return self.list.pop()

    def peek(self):
        return self.list[len(self.list) - 1]

    def min(self):
        return self.peek().get_min()


def main():
    l = [7,2,9,1]
    el = [Element(x) for x in l]
    st = Stack()
    for elmt in el:
        st.push(elmt)
    
    print(st.min())
    print(st.pop().val)
    print(st.min())
    print(st.pop().val)
    print(st.min())
    print(st.pop().val)

if __name__ == '__main__':
    main()
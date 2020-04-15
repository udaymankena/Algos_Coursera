from stack import Stack


def sort(st):
    sorted = Stack()
    while not st.isEmpty():
        st_curr = st.pop()
        while not sorted.isEmpty() and sorted.peek() < st_curr:
            st.push(sorted.pop())
        sorted.push(st_curr)
    return sorted


def main():
    st = Stack()
    for i in [7,8,9,5,3,11,3]:
        st.push(i)
    st_sort = sort(st)
    while(not st_sort.isEmpty()):
        print(st_sort.pop())

if __name__ == '__main__':
    main()
from stack import Stack

class StackOfStacks():
    def __init__(self,thresh):
        self.lst = []
        self.thresh = thresh
    
    def push(self,elmt):
        if len(self.lst) == 0 or self.lst[-1].len() >= self.thresh:
            self.lst.append(Stack())
        self.lst[-1].push(elmt)

    def pop(self):
        curr_st = self.lst[len(self.lst)-1]
        if curr_st.len() == 0:
            self.lst.pop()
            if self.isEmpty():
                return None
            curr_st = self.lst[len(self.lst)-1]
        return curr_st.pop()

    def pop_at_index(self,index):
        st_num = index // self.thresh
        ind_on_st = (index+1) % self.thresh - 1
        popped_elmt = self.lst[st_num].pop(ind_on_st)
        while st_num < len(self.lst) - 1:
            curr_st = self.lst[st_num]
            next_st = self.lst[st_num + 1]
            popped = next_st.pop(0)
            curr_st.push(popped)
            st_num = st_num + 1
        return popped_elmt
            
    
    def isEmpty(self):
        return len(self.lst) < 1

def main():
    sos = StackOfStacks(5)
    for i in range(15):
        sos.push(i)
    
    print("sos.pop_at_index(6)", sos.pop_at_index(6))

    while(not sos.isEmpty()):
        print(sos.pop())
    
    

if __name__ == '__main__':
    main()
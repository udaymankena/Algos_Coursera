class Stack():
    def __init__(self):
        self.lst = []

    def push(self,elmt):
        self.lst.append(elmt)

    def pop(self, index=None):
        if index is not None:
            return self.lst.pop(index)
        return self.lst.pop()

    def peek(self):
        return self.lst[len(self.lst) - 1]
    
    def len(self):
        return len(self.lst)
    
    def isEmpty(self):
        return len(self.lst) == 0
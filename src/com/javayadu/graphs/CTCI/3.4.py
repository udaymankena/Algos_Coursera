from stack import Stack

class Queue():

    def __init__(self):
        self.st1 = Stack()
        self.st2 = Stack()

    def __pop_to_stack(self,s1,s2):
        while s1.len() > 0:
            s2.push(s1.pop())

    def enqueue(self,elmt):
        if(self.st1.len() == 0):
            self.__pop_to_stack(self.st2,self.st1)
        self.st1.push(elmt)

    def dequeue(self):
        if(self.st2.len() == 0):
            self.__pop_to_stack(self.st1,self.st2)
        return self.st2.pop()

def main():
    q = Queue()
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    print(q.dequeue())
    #q.enqueue(4)
    print(q.dequeue())

if __name__ == "__main__":
    main()
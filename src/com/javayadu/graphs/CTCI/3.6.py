
cnt = 0
DQ = None
CQ = None
class Dog():
    def __init__(self):
        pass

class Cat():
    def __init__(self):
        pass

class Node():
    def __init__(self,anml,timecnt):
        self.anml = anml
        self.timecnt = timecnt
        self.next = None

def is_dog(anml):
    return anml.__class__.__name__ == 'Dog'

def enqueue(anml):
    global cnt,DQ,CQ
    cnt = cnt + 1
    if( is_dog(anml) ):
        dn = Node(anml,cnt)
        if DQ is None:
            DQ = dn
        else:
            dn.next = DQ
            DQ = dn
    else:
        cn = Node(anml,cnt)
        if CQ is None:
            CQ = cn
        else:
            cn.next = CQ
            CQ = cn


def deqany():
    global DQ,CQ
    if(DQ.timecnt < CQ.timecnt):
        curr = DQ
        DQ = DQ.next
        return curr
    else:
        curr = CQ
        CQ = CQ.next
        return curr

def deq_dog():
    global DQ
    curr = DQ
    DQ = DQ.next
    return curr

def deq_cat():
    global CQ
    curr = CQ
    CQ = CQ.next
    return curr

def main():
    d1 = Dog()
    d2 = Dog()
    d3 = Dog()
    d4 = Dog()
    c1 = Cat()
    c2 = Cat()
    c3 = Cat()
    c4 = Cat()
    enqueue(d1)
    enqueue(d2)
    enqueue(c1)
    enqueue(c2)
    
    print(deqany().anml.__class__.__name__)
    print(deq_cat().anml.__class__.__name__)
    print(deqany().anml.__class__.__name__)
    

if __name__ == '__main__':
    main()
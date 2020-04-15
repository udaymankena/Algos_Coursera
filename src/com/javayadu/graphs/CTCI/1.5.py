
def ins_rem(str1, str2):
    if abs(len(str1) - len(str2)) > 1:
        return False
    i=0 
    j=0 
    edits=0
    smaller = None 
    bigger = None
    if len(str1) < len(str2):
        smaller = str1
        bigger = str2
    else:
        smaller = str2
        bigger = str1
    while i < len(smaller):
        if smaller[i] != bigger[j]:
            edits = edits + 1
            j = j+1
        else:
            i = i+1
            j = j+1
        if edits > 1:
            return False
    return True

def replace(str1,str2):
    if len(str1) != len(str2):
        return False
    i=0 
    edits = 0
    while i < len(str1):
        if str1[i] != str2[i]:
            edits = edits + 1
        if edits > 1:
            return False
        i = i+1
    return True

def main():
    str1 = "carb"
    str2 = "cardbm"
    if ins_rem(str1,str2):
        print(True)
    else:
        print(replace(str1,str2))

if __name__ == '__main__':
    main()
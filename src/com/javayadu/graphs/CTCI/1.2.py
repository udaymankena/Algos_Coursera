# check if one string is a permutation of the other

def is_permutation(str1,str2):
    # if len(str1) != len(str2):
    #     return False
    # str1 = ''.join(sorted(str1))
    # str2 = ''.join(sorted(str2))
    # for i in range(len(str1)):
    #     if str1[i] != str2[i]:
    #         return False
    # return True
    chs = {ch: 0 for ch in str1}
    print(chs)
    for ch in str2:
        if ch not in chs:
            return False
    return True



def main():
    print(is_permutation('abcd','dbca'))

if __name__ == '__main__':
    main()
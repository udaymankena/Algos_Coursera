# Below is my solution which is not exactly confining to the question
# CTCI had a better solution - find if s2 is a substr of s1+s1

def is_rotation(s1,s2):
    rot_pnt = None
    for i in range(1,len(s1)):
        curr_substr = s1[i:]
        if curr_substr == s2[0:len(s1[i:])]:
            rot_pnt = i
            break
    if rot_pnt is None:
        return False
    else:
        print("s1[:rot_pnt] - ", s1[:rot_pnt])
        print("s2[len(s1[:rot_pnt])-1:] - ", s2[len(s1[rot_pnt:]):]) 
        return s1[:rot_pnt] == s2[len(s1[rot_pnt:]):]


def main():
    s1 = "waterbottle"
    s2 = "erbottlewat"
    print(is_rotation(s1,s2))

if __name__ == '__main__':
    main()

def is_perm_of_plndrm(str):
    letr_cnt = {} # attempting dict comprhnsn - {ch:letr_cnt.get(ch,0) for ch in str}
    for ch in str:
        letr_cnt[ch] = letr_cnt.get(ch,0) + 1
    odd_cnt = 0
    if(len(str) % 2 == 0):
        for cnt in letr_cnt.values():
            if cnt % 2 != 0:
                return False
    else:
        for cnt in letr_cnt.values():
            if odd_cnt > 1:
                return False
            if cnt % 2 != 0:
                odd_cnt = odd_cnt + 1
    return True



def main():
    str = "abcdadcba"
    print(is_perm_of_plndrm(str))

if __name__ == '__main__':
    main()
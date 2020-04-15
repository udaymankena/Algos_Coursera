
def compress(a):
    diff = 0
    letr_cnt = 1
    compr = ""
    for i in range(1,len(a)+1):
        if i == len(a):
            compr = compr + a[i-1] + str(letr_cnt)
            if letr_cnt == 1:
                diff = diff - 1
            elif letr_cnt > 2:
                diff = diff + letr_cnt - 2
        elif a[i] == a[i-1]:
            letr_cnt = letr_cnt + 1
        else:
            compr = compr + a[i-1] + str(letr_cnt)
            if letr_cnt == 1:
                diff = diff - 1
            elif letr_cnt > 2:
                diff = diff + letr_cnt - 2
            letr_cnt = 1
    if diff <= 0:
        return a
    return compr

def main():
    a = "abcd"
    print(compress(a))

if __name__ == '__main__':
    main()
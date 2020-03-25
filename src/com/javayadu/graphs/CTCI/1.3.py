

def move_two_right(str,i):
    k = len(str) - 1
    while(k > i):
        str[k] =  str[k-2]

def str_repl(str):
    for i in range(len(str)):
        if str[i] == ' ':
            move_two_right(str,i)
            str[i] = '%'
            str[i+1] = '2'
            str[i+2] = '0'
            i = i + 3

def main():
    str = "john ken smith    "
    str[0] = '1'
    str_repl(str)
    print(str)

if __name__ == '__main__':
    main()
            
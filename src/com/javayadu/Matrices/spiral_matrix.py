
def spiral(mat):
    i = 0
    j = 0
    M = len(mat)
    N = len(mat[0])
    print('M,N', M, N)
    while i < M:
        # print('i,j', i, j)
        if j > N-1:
            j= N-1
        if j < 0:
            j=0
        if(j == 0):
            while j <= N-1:
                print(mat[i][j], end = ' ')
                j = j+1
        elif(j == N-1):
            while j >= 0:
                print(mat[i][j], end = ' ')
                j = j-1
        i = i+1
        print()

def main():
    mat = [[1,2,3],[4,5,6],[7,8,9],[10,11,12]]
    spiral(mat)

if __name__ == '__main__':
    main()
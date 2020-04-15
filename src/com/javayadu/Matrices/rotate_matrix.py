
def rotate(mat):
    # maintain four place holders for four corners to keep track of the ..
    # .. boundary of the current loop
    top = 0 # first row of the matrix
    bot = len(mat) - 1 # last row of the matrix
    left = 0 #
    right = len(mat[0]) - 1 # last column of the matrix

    # looping over each square/rectangle of the matrix
    while top < bot and left < right:
        prev = mat[top][left]
        # moving top row elements to the right
        for i in range(left+1,right+1):
            curr = mat[top][i]
            mat[top][i] = prev
            prev = curr
        
        # moving the right most elements one row down
        for i in range(top+1,bot+1):
            curr = mat[i][right]
            mat[i][right] = prev
            prev = curr
        
        # moving the right bottom elements to left
        i = right-1
        while i >= left:
            curr = mat[bot][i]
            mat[bot][i] = prev
            prev = curr
            i = i-1
        
        # moving bottom left to onew row high
        i = bot - 1
        while i >= top:
            curr = mat[i][left]
            mat[i][left] = prev
            prev = curr
            i = i-1
        
        # adjust the boundaries for the inner square/rectangle
        top = top+1
        bot = bot-1
        left = left+1
        right = right-1
    
def print_matrix(mat):
    for row in mat:
        print(row)

def main():
    mat = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    print_matrix(mat)
    print()
    rotate(mat)
    print_matrix(mat)


if __name__ == '__main__':
    main()
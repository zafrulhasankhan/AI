print ("Enter the number of queens")
N = int(input())

#NxN matrix with all elements 0
board = [[0]*N for _ in range(N)]
n=N
def is_attack(i,j):
    for l in range(n):
        for m in range(n):
            if (l==i and board[l][m]==1) or (m==j and board[l][m]==1) or(l+m==i+j and board[l][m]==1) or (l-m==i-j and board[l][m]==1):
                return True
    return False
def N_queen(n):
    if n==0:
        return True
    for i in range(0,N):
        for j in range(0,N):

            if (not(is_attack(i,j))) and (board[i][j]==0):
                board[i][j] = 1
                #recursion
                #wether we can put the next queen with this arrangment or not
                if N_queen(n-1)==True:
                    return True
                board[i][j] = 0

    return False


N_queen(n)
for i in board:
    print (i)
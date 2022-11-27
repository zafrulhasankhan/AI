#iterative deepening dfs
graph={
    'a':['b','c'],
    'b':['d','e'],
    'c':[],
    'd':[],
    'e':['f','g'],
    'f':[],
    'g':[]
}
def dfs(currentNode,destinationNode,graph,maxdepth):
    print(currentNode,end=' ')
    if currentNode==destinationNode:
        return True
    if maxdepth<=0:
        return False

    for node in graph[currentNode]:
        if dfs(node,destinationNode,graph,maxdepth-1):
            return True
    return False

def iterativeDDFS(currentNode,destinationNode,graph,maxdepth):
    for i in range(maxdepth):
        if dfs(currentNode,destinationNode,graph,i):
            return True
    return  False
if iterativeDDFS('a','c',graph,9):
    print('is the path ')
else:
    print('path not exists')
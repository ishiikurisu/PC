def read():
    return raw_input().split(' ')

def bfs(graph, vertex):
    found = set()
    queue = []

    queue.append(vertex)
    while queue:
        vertex = queue.pop(0)
        edges = graph[vertex]
        for edge in edges:
            if edge not in found:
                queue.append(edge)
                found.add(vertex)
            else:
                return True

    return False

def setup():
    global graph

    N, M = map(int, read())
    graph = dict()
    for m in xrange(M):
        A, B = read()
        if not graph.has_key(A):
            graph[A] = set()
        if not graph.has_key(B):
            graph[B] = set()
        graph[A].add(B)

def draw():
    global graph

    for vertex in graph:
        if bfs(graph, vertex) == True:
            return 'SIM'
    else:
        return 'NAO'

if __name__ == '__main__':
    for T in xrange(input()):
        setup()
        print draw()

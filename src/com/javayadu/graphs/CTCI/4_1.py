

# Two ways with dfs and bfs

from graph import Graph,Node,get_sample_graph
def path_two_nodes(graph,n1,n2):
    visited = {}
    return bfs(graph,n1,n2,visited)

def dfs(graph,n1,n2,visited):
    if n1.val == n2.val:
        return True
    print(n1)
    visited[n1] = True
    curr_edges = n1.get_adj()
    print("curr_edges: " + str(curr_edges))
    for v in curr_edges:
        print("parent: " + str(n1) + " curr_edge: " + str(v))
        has_path = False
        if not visited.has_key(v):
            has_path = dfs(graph, v, n2, visited)
        if has_path:
            return True
    return False


def bfs(graph,n1,n2,visited):
    q = [] # list operating as a queue, enqueue => append, dequeue => pop(0)
    q.append(n1)
    while len(q) > 0:
        curr_node = q.pop(0)
        if not visited.has_key(curr_node):
            visited[curr_node] = True
            if curr_node.val == n2.val:
                return True
            else:
                q.extend(curr_node.get_adj())

    return False


def main():
    graph = get_sample_graph()
    print(path_two_nodes(graph,graph.nodes[4],graph.nodes[0]))

if(__name__ == "__main__"):
    main()
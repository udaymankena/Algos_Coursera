# detecting cycle in a directed graph

from graph import get_sample_graph

def dfs(node,visited,hier): # returns true if a cycle is found
    if node in hier:
        return True
    visited.append(node)
    hier.append(node)
    print("current node: ", str(node))
    print("visited: ",[n.val for n in visited ] )
    print("hier: ", [n.val for n in hier])
    for connection in node.adj:
        has_cycle = dfs(connection,visited,hier)
        if has_cycle:
            return True

def main():
    graph = get_sample_graph()
    nodes = graph.nodes
    graph.add_edge(nodes[4],nodes[0])
    visited = []
    for node in nodes:
        if node not in visited:
            if dfs(node,visited,[]):
                print("projects can't be completed")
                return
    print("No cyclic dependencies - all projects can be completed")

if __name__ == "__main__":
    main()
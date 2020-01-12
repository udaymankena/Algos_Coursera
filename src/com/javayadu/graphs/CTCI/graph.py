

class Graph():
    #nodes = None

    def __init__(self,nodes,digraph=False):
        self.nodes = nodes
        self.digraph = digraph

    def add_edge(self,n1,n2):
        n1.add_adj_elmt(n2)
        if not self.digraph:
            n2.add_adj_elmt(n1)

    def is_an_edge(self,n1,n2):
        pass

    def add_node(self,node):
        self.nodes.append(node)




class Node():

    def __init__(self,value):
        self.val = value
        self.adj = [] # (self,value,adj=[]) => why doesn't this work?
        # adj should be a set instead of a list? there are implementations with dict as well

    def add_adj_elmt(self, node):
        #print("node " + str(self) + "....adding node " + str(node))
        self.adj.append(node)

    def get_adj(self):
        return self.adj

    def __str__(self):
        return str(self.val)



def get_sample_graph():
    nodes = []
    # creating nodes
    for i in range(10):
        node = Node(i)
        nodes.append(node)

    graph = Graph(nodes, True)
    graph.add_edge(nodes[0], nodes[1])
    graph.add_edge(nodes[0], nodes[3])
    graph.add_edge(nodes[1], nodes[4])
    graph.add_edge(nodes[5], nodes[8])

    return graph

def main():
    g = get_sample_graph()
    #g.nodes[5] = 5
    # for n in g.nodes:
    #     print(n)
    # print(g.digraph)
    for n in g.nodes[9].adj:
        print n.val


if __name__ == '__main__':
    main()
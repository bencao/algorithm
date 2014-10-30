class Vertex
  attr_reader :value

  def initialize(value)
    @value = value
  end
end

class DirectionalGraph
  attr_accessor :vertexes
  attr_accessor :edges

  def initialize
    @vertexes = []
    @edges    = {}
  end

  def add_vertex(vertex)
    @vertexes.push(vertex)
    @edges[vertex] = []
  end

  def add_edge(from_vertex, to_vertex)
    @edges[from_vertex].push(to_vertex)
  end

  def bfs(&block)
    vertexes_in = {}
    @vertexes.each{ |v| vertexes_in[v] = 0 }
    @vertexes.each do |v|
      @edges[v].each{ |adj| vertexes_in[adj] += 1 }
    end
    queue = @vertexes.select{ |v| vertexes_in[v] == 0 }

    bfs_visited = {}
    @vertexes.each do |v|
      bfs_visited[v] = false
    end

    until queue.empty?
      v = queue.shift
      next if bfs_visited[v]
      bfs_visited[v] = true
      yield v unless block.nil?
      @edges[v].each do |adj|
        next if bfs_visited[adj]
        queue << adj
      end
    end
  end

  def dfs(&block)
    dfs_status = {}
    @vertexes.each do |v|
      dfs_status[v] = :not_visited
    end

    @vertexes.each do |v|
      dfs_visit(dfs_status, v, &block)
    end
  end

  def dfs_visit(dfs_status, vertex, &block)
    return if dfs_status[vertex] == :visited || dfs_status[vertex] == :discovered
    dfs_status[vertex] = :discovered
    yield vertex unless block.nil?
    @edges[vertex].each do |adj|
      dfs_visit(dfs_status, adj, &block)
    end
    dfs_status[vertex] = :visited
  end

  def topo_sort(&block)
    vertexes_in = {}
    @vertexes.each{ |v| vertexes_in[v] = 0 }
    @vertexes.each do |v|
      @edges[v].each{ |adj| vertexes_in[adj] += 1 }
    end
    queue = @vertexes.select{ |v| vertexes_in[v] == 0 }
    visited = []
    until queue.empty?
      v = queue.shift
      visited << v
      @edges[v].each do |adj|
        vertexes_in[adj] -= 1
        queue << adj if vertexes_in[adj] == 0
      end
    end
    raise "unable to do topo sort because cycle founded in graph" if visited.size != @vertexes.size
    visited.each(&block)
  end
end

g = DirectionalGraph.new

v1 = Vertex.new('campaign')
v2 = Vertex.new('insertion_order')
v3 = Vertex.new('placement')
v4 = Vertex.new('sub_order')
v5 = Vertex.new('sub_order_placement_assignment')
v6 = Vertex.new('targeting_criteria')

g.add_vertex(v1)
g.add_vertex(v2)
g.add_vertex(v3)
g.add_vertex(v4)
g.add_vertex(v5)
g.add_vertex(v6)

g.add_edge(v1, v2)
g.add_edge(v2, v3)
g.add_edge(v2, v4)
g.add_edge(v3, v5)
g.add_edge(v4, v5)
g.add_edge(v6, v3)

puts "===TOPO SORT==="
g.topo_sort do |v|
  puts v.value
end

puts "===DFS==="
g.dfs do |v|
  puts v.value
end

puts "===BFS==="
g.bfs do |v|
  puts v.value
end

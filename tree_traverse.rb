class TreeNode
  attr_accessor :parent
  attr_accessor :left_child
  attr_accessor :right_child
  attr_accessor :value

  def initialize(value)
    @value = value
  end

  def has_left_child?
    ! @left_child.nil?
  end

  def has_right_child?
    ! @right_child.nil?
  end

  def bfs(&block)
    queue = [self]
    while queue.size > 0 do
      node = queue.shift
      queue.push(node.left_child) if node.has_left_child?
      queue.push(node.right_child) if node.has_right_child?
      yield node unless block.nil?
    end
  end

  def dfs(&block)
    yield self unless block.nil?
    @left_child.dfs(&block) unless @left_child.nil?
    @right_child.dfs(&block) unless @right_child.nil?
  end
end

root = TreeNode.new("1")

root.left_child = TreeNode.new("2_1")
root.right_child = TreeNode.new("2_2")

root.left_child.left_child = TreeNode.new("3_1_1")
root.left_child.right_child = TreeNode.new("3_1_2")

root.right_child.left_child = TreeNode.new("3_2_1")
root.right_child.right_child = TreeNode.new("3_2_2")

puts "===BFS==="
root.bfs do |node|
  puts node.value
end

puts "===DFS==="
root.dfs do |node|
  puts node.value
end

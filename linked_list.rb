class LinkedListNode
  attr_accessor :next, :data

  def initialize(data)
    @data = data
    @next = nil
  end
end

class LinkedList
  attr_accessor :head

  def initialize(head)
    @head = head
  end

  def insert(node)
    node.next = @head  
    @head     = node
  end

  def each(&block)
    current = @head
    until current.nil?
      yield current unless block.nil?
      current = current.next
    end
  end
end

head = LinkedListNode.new(weight: 10)

list = LinkedList.new(head)
list.insert(LinkedListNode.new(weight: 9))
list.insert(LinkedListNode.new(weight: 8))
list.each do |node|
  puts node.data[:weight]
end

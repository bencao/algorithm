def bucket_sort(array, range_low, range_high)
  bucket = {}
  (range_low..range_high).each do |value|
    bucket[value] = []
  end
  array.each do |item|
    if item.value < range_low || item.value > range_high
      raise "out of bound value #{item.value}"
    end
    bucket[item.value] << item
  end
  result = []
  (range_low..range_high).each do |value|
    result += bucket[value]
  end
  result
end

class Item
  attr_accessor :value

  def initialize(value)
    @value = value
  end

end

puts bucket_sort([
  Item.new(0),
  Item.new(24),
  Item.new(255),
  Item.new(32),
  Item.new(44)
], 0, 255).map(&:value).join(" ")

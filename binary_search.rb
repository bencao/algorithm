def binary_search(array, p, r, value)
  return nil if r < p
  q = ((p + r) / 2).floor
  return q if array[q] == value
  if array[q] > value
    binary_search(array, p, q - 1, value)
  else
    binary_search(array, q + 1, r, value)
  end
end

array = [ 1, 3, 5, 6, 6, 7, 8, 9, 10, 12, 16, 17 ]

puts binary_search(array, 0, array.size - 1, array[9])
puts binary_search(array, 0, array.size - 1, 2)
puts binary_search(array, 0, array.size - 1, array[0])
puts binary_search(array, 0, array.size - 1, array[array.size - 1])
puts binary_search(array, 0, array.size - 1, array[5])

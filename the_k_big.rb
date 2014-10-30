def the_k_big(array, p, r, k)
  q = partition(array, p, r)
  return array[q] if q == k
  if q > k
    the_k_big(array, p, q - 1, k)
  else
    the_k_big(array, q + 1, r, k - q)
  end
end

def partition(array, p, r)
  x = array[r]
  i = p - 1
  j = p
  while j < r do
    if array[j] <= x
      i = i + 1
      exchange(array, i, j)
    end
    j = j + 1
  end
  exchange(array, i + 1, r)
  i + 1
end

def exchange(array, i, j)
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
end

array1 = [9, 8, 7, 6, 5]
array2 = [4, 6, 1, 6, 9]
array3 = [7, 4, 8, 6, 1, 6, 40, 9, 10, 31]

puts the_k_big(array1, 0, array1.size - 1, 0)
puts the_k_big(array2, 0, array2.size - 1, 4)
puts the_k_big(array3, 0, array3.size - 1, 6)

class Ad
  attr_accessor :value
  attr_accessor :duration

  def initialize(attrs = {})
    @value    = attrs[:value] || 0
    @duration = attrs[:duration] || 0
  end

  def to_s
    "value=#{@value} duration=#{@duration}"
  end
end

class AdSlot
  attr_accessor :max_duration

  def initialize(attrs = {})
    @max_duration = attrs[:max_duration] || 0
  end

  def most_profitable_ads(ads, &block)
    max_profit = {}

    # init max_profits
    (0..@max_duration).each do |d|
      max_profit[d] = {}
      (0..ads.size).each do |n|
        max_profit[d][n] = 0
      end
    end

    (1..@max_duration).each do |d|
      (1..ads.size).each do |n|
        ad = ads[n - 1]
        if d >= ad.duration
          max_profit[d][n] = [
            max_profit[d - ad.duration][n - 1] + ad.value,
            max_profit[d][n - 1]
          ].max
        else
          max_profit[d][n] = max_profit[d][n - 1]
        end
      end
    end

    get_most_profitable_ads(max_profit, ads, @max_duration, ads.size).each do |ad|
      yield ad unless block.nil?
    end
  end

  def get_most_profitable_ads(max_profit, ads, d, n)
    return [] if d == 0 || n == 0

    ad = ads[n - 1]
    if d >= ad.duration &&
        max_profit[d][n] == max_profit[d - ad.duration][n - 1] + ad.value
      [ad] + get_most_profitable_ads(max_profit, ads, d - ad.duration, n - 1)
    else
      get_most_profitable_ads(max_profit, ads, d, n - 1)
    end
  end

end

ads = [
  Ad.new({:value => 8,  :duration => 10}),
  Ad.new({:value => 15, :duration => 20}),
  Ad.new({:value => 20, :duration => 21}),
  Ad.new({:value => 4,  :duration => 9})
]

ad_slot = AdSlot.new(:max_duration => 30)

ad_slot.most_profitable_ads(ads).each do |ad|
  puts "Picking #{ad}"
end

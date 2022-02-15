# BloomFilter

<blockquote>
"A Bloom filter is a space-efficient probabilistic data structure that is used to test whether an element is a member of a set. False positive matches are possible, but false negatives are not. In other words, a query returns either “possibly in set” or “definitely not in set”. Elements can be added to the set, but not removed,” says Wikipedia.

Bloom filter 是由 Howard Bloom 在 1970 年提出的二进制向量数据结构，它具有很好的空间和时间效率，被用来检测一个元素是不是集合中的一个成员。如果检测结果为是，该元素不一定在集合中；但如果检测结果为否，该元素一定不在集合中。因此Bloom filter具有100%的召回率。这样每个检测请求返回有“在集合内（可能错报）”和“不在集合内（绝对不在集合内）”两种情况，可见 Bloom filter 是牺牲了正确率和时间以节省空间。 引自 百度百科
</blockquote>

### 简而言之，Bloom filter是:
- 优化内存占用， 当整个集合太大而不能全部放到内存中。Optimization for memory. It comes into play when you cannot put whole set into memory.
- 解决成员存在性的问题。它可以回答下面的问题：一个元素属于一个集合还是不属于？
- 概率(有损)数据结构。它可以返回一个元素有多大的概率属于一个集合

布隆过滤器

适合大数据判重的场景，如网络爬虫中判断一个URL是否已经爬取过，判断一个用户是否在黑名单中，判断一个邮件是否是垃圾邮件，等等。

- 优点：占用空间小，效率高，简而言之，就是以正确率换空间和时间。
- 缺点：有一定的误判率，一个URL经过布隆过滤器判断没爬取过，那么一定没爬取过，一个URL经过布隆过滤器判断爬取过，可能并没有爬取过，这种情况会有误判。

布隆过滤器本身是基于位图的，是对位图的一种改进，位图在java中的实现就是BitSet。

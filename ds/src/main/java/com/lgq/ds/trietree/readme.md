# TrieTree

Ansj分词最基本的数据结构——Trie树。

Trie树也称字典树，能在常数时间O(len)内实现插入和查询操作，是一种以空间换取时间的数据结构，广泛用于词频统计和输入统计领域。

字典树, 简单补充一下个人理解： 它实际上相当于把单词的公共部分给拎出来，这样一层一层往上拎直到得到每个节点都是不可分的最小单元！

比如网上一个例子 一组单词，inn, int, at, age, adv, ant, 我们可以得到下面的Trie：

[Trie-tree](./img/trietree.png)

### Trie树有什么好处呢

它是一种非常快的单词查询结构，当然，对于单词去重统计也是非常好的选择！ 比如搜索引擎的关键词联想功能很好的一种选择就是使用Trie树了！比如你输入了in，通过上面的图我们应该提示inn和int ，这样可以轻松实现！ 

另外，对于单词出现的频率统计， 以及查找公共前缀等问题，都可以很好的解决！

### 工具
工具：hankcs(double array trie)

应用：反垃圾文本，词库检查，  词典、黑名单。

#### Trie树分词

From [Trie树分词](https://www.hankcs.com/program/java/tire-tree-participle.html)

#### 双数组Trie树(DoubleArrayTrie)

双数组Trie树(DoubleArrayTrie)是一种空间复杂度低的Trie树，应用于字符区间大的语言（如中文、日文等）分词领域。

<blockquote>
双数组Trie (Double-Array Trie)结构由日本人JUN-ICHI AOE于1989年提出的，是Trie结构的压缩形式，仅用两个线性数组来表示Trie树，该结构有效结合了数字搜索树(Digital Search Tree)检索时间高效的特点和链式表示的Trie空间结构紧凑的特点。双数组Trie的本质是一个确定有限状态自动机（DFA），每个节点代表自动机的一个状态，根据变量不同，进行状态转移，当到达结束状态或无法转移时，完成一次查询操作。在双数组所有键中包含的字符之间的联系都是通过简单的数学加法运算表示，不仅提高了检索速度，而且省去了链式结构中使用的大量指针，节省了存储空间。

——《基于双数组Ｔｒｉｅ树算法的字典改进和实现》
</blockquote>

from : [双数组Trie树(DoubleArrayTrie)Java实现](http://www.hankcs.com/program/java/%e5%8f%8c%e6%95%b0%e7%bb%84trie%e6%a0%91doublearraytriejava%e5%ae%9e%e7%8e%b0.html)

#### Aho Corasick自动机结合DoubleArrayTrie极速多模式匹配

From [Aho Corasick自动机结合DoubleArrayTrie极速多模式匹配](http://www.hankcs.com/program/algorithm/aho-corasick-double-array-trie.html#google_vignette)

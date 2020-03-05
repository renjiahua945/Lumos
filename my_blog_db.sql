/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : my_blog_db

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 05/03/2020 21:06:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user`  (
  `admin_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员登陆名称',
  `login_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员登陆密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员显示昵称',
  `locked` tinyint(4) NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
  PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin_user
-- ----------------------------
INSERT INTO `tb_admin_user` VALUES (1, 'renjiahua', '027d3922dd6fa2060d6a9c1bbf69e122', '不会敲代码的小白', 0);

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;
CREATE TABLE `tb_blog`  (
  `blog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
  `blog_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_sub_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客自定义路径url',
  `blog_cover_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客封面图',
  `blog_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客内容',
  `blog_category_id` int(11) NULL DEFAULT NULL COMMENT '博客分类id',
  `blog_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客分类(冗余字段)',
  `blog_tags` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标签',
  `blog_status` tinyint(4) NULL DEFAULT 0 COMMENT '0-草稿 1-发布',
  `blog_views` bigint(20) NULL DEFAULT 0 COMMENT '阅读量',
  `enable_comment` tinyint(4) NULL DEFAULT 0 COMMENT '0-允许评论 1-不允许评论',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog
-- ----------------------------
INSERT INTO `tb_blog` VALUES (21, 'dasdasd', 'da', 'http://localhost/admin/dist/img/rand/37.jpg', 'dasdadasdad', 25, NULL, 'dasdsada', 1, 8, 0, 1, '2020-01-21 11:07:58', '2020-01-21 11:07:58');
INSERT INTO `tb_blog` VALUES (22, 'dadad', '', 'https://localhost/admin/dist/img/rand/24.jpg', 'dadadadad', 25, NULL, 'dada', 1, 6, 0, 0, '2020-02-01 13:15:31', '2020-02-01 13:15:31');
INSERT INTO `tb_blog` VALUES (23, 'dada', 'adada', 'https://localhost/admin/dist/img/rand/1.jpg', 'dadadadadada', 25, NULL, 'dada', 1, 6, 0, 0, '2020-02-01 13:16:16', '2020-02-01 13:16:16');
INSERT INTO `tb_blog` VALUES (24, 'Map 综述（一）：彻头彻尾理解 HashMap', '', 'https://localhost/admin/dist/img/rand/34.jpg', '摘要：\n\n　　HashMap是Map族中最为常用的一种，也是 Java Collection Framework 的重要成员。本文首先给出了 HashMap 的实质并概述了其与 Map、HashSet 的关系，紧接着给出了 HashMap 在 JDK 中的定义，并结合源码分析了其四种构造方式。最后，通过对 HashMap 的数据结构、实现原理、源码实现三个方面的剖析，深入到它底层 Hash 存储机制，解释了其底层数组长度总是 2 的 n 次方的原因，也揭示了其快速存取、扩容及扩容后的重哈希的原理与实现。\n\n友情提示：\n\n　　本文所有关于HashMap的源码都是基于 JDK 1.6 的，不同 JDK 版本之间也许会有些许差异，但不影响我们对 HashMap 的数据结构、原理等整体的把握和了解。\n\n　　HashMap 的直接子类LinkedHashMap继承了HashMap的所用特性，并且还通过额外维护一个双向链表保持了有序性, 通过对比LinkedHashMap和HashMap的实现有助于更好的理解HashMap。关于LinkedHashMap的更多介绍，请参见我的另一篇博文《Map 综述（二）：彻头彻尾理解 LinkedHashMap》，欢迎指正~\n\n版权声明：\n\n本文原创作者：书呆子Rico\n作者博客地址：http://blog.csdn.net/justloveyou_/\n\n一. HashMap 概述\n　　Map 是 Key-Value 对映射的抽象接口，该映射不包括重复的键，即一个键对应一个值。HashMap 是 Java Collection Framework 的重要成员，也是Map族(如下图所示)中我们最为常用的一种。简单地说，HashMap 是基于哈希表的 Map 接口的实现，以 Key-Value 的形式存在，即存储的对象是 Entry (同时包含了 Key 和 Value) 。在HashMap中，其会根据hash算法来计算key-value的存储位置并进行快速存取。特别地，HashMap最多只允许一条Entry的键为Null(多条会覆盖)，但允许多条Entry的值为Null。此外，HashMap 是 Map 的一个非同步的实现。\n　　　　　　　　　　　　\n\n　　同样地，HashSet 也是 Java Collection Framework 的重要成员，是 Set 接口的常用实现类，但其与 HashMap 有很多相似之处。对于 HashSet 而言，其采用 Hash 算法决定元素在Set中的存储位置，这样可以保证元素的快速存取；对于 HashMap 而言，其将 key-value 当成一个整体(Entry 对象)来处理，其也采用同样的 Hash 算法去决定 key-value 的存储位置从而保证键值对的快速存取。虽然 HashMap 和 HashSet 实现的接口规范不同，但是它们底层的 Hash 存储机制完全相同。实际上，HashSet 本身就是在 HashMap 的基础上实现的。因此，通过对 HashMap 的数据结构、实现原理、源码实现三个方面了解，我们不但可以进一步掌握其底层的 Hash 存储机制，也有助于对 HashSet 的了解。\n\n　　必须指出的是，虽然容器号称存储的是 Java 对象，但实际上并不会真正将 Java 对象放入容器中，只是在容器中保留这些对象的引用。也就是说，Java 容器实际上包含的是引用变量，而这些引用变量指向了我们要实际保存的 Java 对象。\n\n二. HashMap 在 JDK 中的定义\n　　HashMap实现了Map接口，并继承 AbstractMap 抽象类，其中 Map 接口定义了键值映射规则。和 AbstractCollection抽象类在 Collection 族的作用类似， AbstractMap 抽象类提供了 Map 接口的骨干实现，以最大限度地减少实现Map接口所需的工作。HashMap 在JDK中的定义为：\n\npublic class HashMap<K,V>\n    extends AbstractMap<K,V>\n    implements Map<K,V>, Cloneable, Serializable{\n...\n}\n1\n2\n3\n4\n5\n三. HashMap 的构造函数\n　　HashMap 一共提供了四个构造函数，其中 默认无参的构造函数 和 参数为Map的构造函数 为 Java Collection Framework 规范的推荐实现，其余两个构造函数则是 HashMap 专门提供的。\n\n1、HashMap()\n\n　　该构造函数意在构造一个具有> 默认初始容量 (16) 和 默认负载因子(0.75) 的空 HashMap，是 Java Collection Framework 规范推荐提供的，其源码如下：\n\n     /**\n     * Constructs an empty HashMap with the default initial capacity\n     * (16) and the default load factor (0.75).\n     */\n    public HashMap() {\n\n        //负载因子:用于衡量的是一个散列表的空间的使用程度\n        this.loadFactor = DEFAULT_LOAD_FACTOR; \n\n        //HashMap进行扩容的阈值，它的值等于 HashMap 的容量乘以负载因子\n        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[DEFAULT_INITIAL_CAPACITY];\n\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n2、HashMap(int initialCapacity, float loadFactor)\n\n　　该构造函数意在构造一个 指定初始容量 和 指定负载因子的空 HashMap，其源码如下：\n\n    /**\n     * Constructs an empty HashMap with the specified initial capacity and load factor.\n     */\n    public HashMap(int initialCapacity, float loadFactor) {\n        //初始容量不能小于 0\n        if (initialCapacity < 0)\n            throw new IllegalArgumentException(\"Illegal initial capacity: \" + initialCapacity);\n\n        //初始容量不能超过 2^30\n        if (initialCapacity > MAXIMUM_CAPACITY)\n            initialCapacity = MAXIMUM_CAPACITY;\n\n        //负载因子不能小于 0            \n        if (loadFactor <= 0 || Float.isNaN(loadFactor))\n            throw new IllegalArgumentException(\"Illegal load factor: \" +\n                                               loadFactor);\n\n        // HashMap 的容量必须是2的幂次方，超过 initialCapacity 的最小 2^n \n        int capacity = 1;\n        while (capacity < initialCapacity)\n            capacity <<= 1;   \n\n        //负载因子\n        this.loadFactor = loadFactor;\n\n        //设置HashMap的容量极限，当HashMap的容量达到该极限时就会进行自动扩容操作\n        threshold = (int)(capacity * loadFactor);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[capacity];\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n3、HashMap(int initialCapacity)\n\n　　该构造函数意在构造一个指定初始容量和默认负载因子 (0.75)的空 HashMap，其源码如下：\n\n    // Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75)\n    public HashMap(int initialCapacity) {\n        this(initialCapacity, DEFAULT_LOAD_FACTOR);  // 直接调用上述构造函数\n    }\n1\n2\n3\n4\n4、HashMap(Map<? extends K, ? extends V> m)\n\n　　该构造函数意在构造一个与指定 Map 具有相同映射的 HashMap，其 初始容量不小于 16 (具体依赖于指定Map的大小)，负载因子是 0.75，是 Java Collection Framework 规范推荐提供的，其源码如下：\n\n    // Constructs a new HashMap with the same mappings as the specified Map. \n    // The HashMap is created with default load factor (0.75) and an initial capacity\n    // sufficient to hold the mappings in the specified Map.\n    public HashMap(Map<? extends K, ? extends V> m) {\n\n        // 初始容量不小于 16 \n        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,\n                      DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);\n        putAllForCreate(m);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n　　在这里，我们提到了两个非常重要的参数：初始容量 和 负载因子，这两个参数是影响HashMap性能的重要参数。其中，容量表示哈希表中桶的数量 (table 数组的大小)，初始容量是创建哈希表时桶的数量；负载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度，它衡量的是一个散列表的空间的使用程度，负载因子越大表示散列表的装填程度越高，反之愈小。\n\n　　对于使用 拉链法（下文会提到）的哈希表来说，查找一个元素的平均时间是 O(1+a)，a 指的是链的长度，是一个常数。特别地，若负载因子越大，那么对空间的利用更充分，但查找效率的也就越低；若负载因子越小，那么哈希表的数据将越稀疏，对空间造成的浪费也就越严重。系统默认负载因子为 0.75，这是时间和空间成本上一种折衷，一般情况下我们是无需修改的。\n\n四. HashMap 的数据结构\n1、哈希的相关概念\n\n　　Hash 就是把任意长度的输入(又叫做预映射， pre-image)，通过哈希算法，变换成固定长度的输出(通常是整型)，该输出就是哈希值。这种转换是一种 压缩映射 ，也就是说，散列值的空间通常远小于输入的空间。不同的输入可能会散列成相同的输出，从而不可能从散列值来唯一的确定输入值。简单的说，就是一种将任意长度的消息压缩到某一固定长度的息摘要函数。\n\n2、哈希的应用：数据结构\n\n　　我们知道，数组的特点是：寻址容易，插入和删除困难；而链表的特点是：寻址困难，插入和删除容易。那么我们能不能综合两者的特性，做出一种寻址容易，插入和删除也容易的数据结构呢？答案是肯定的，这就是我们要提起的哈希表。事实上，哈希表有多种不同的实现方法，我们接下来解释的是最经典的一种方法 —— 拉链法，我们可以将其理解为 链表的数组，如下图所示：\n\n　　　　　　　　　　　　　　\n\n　　我们可以从上图看到，左边很明显是个数组，数组的每个成员是一个链表。该数据结构所容纳的所有元素均包含一个指针，用于元素间的链接。我们根据元素的自身特征把元素分配到不同的链表中去，反过来我们也正是通过这些特征找到正确的链表，再从链表中找出正确的元素。其中，根据元素特征计算元素数组下标的方法就是 哈希算法。\n\n　　总的来说，哈希表适合用作快速查找、删除的基本数据结构，通常需要总数据量可以放入内存。在使用哈希表时，有以下几个关键点：\n\nhash 函数（哈希算法）的选择：针对不同的对象(字符串、整数等)具体的哈希方法；\n\n碰撞处理：常用的有两种方式，一种是open hashing，即 >拉链法；另一种就是 closed hashing，即开地址法(opened addressing)。\n\n　　\n更多关于哈希(Hash)的介绍，请移步我的博文《Java 中的 ==, equals 与 hashCode 的区别与联系》。\n\n3、HashMap 的数据结构　　　　　　　　　　　　　\n\n　　我们知道，在Java中最常用的两种结构是 数组 和 链表，几乎所有的数据结构都可以利用这两种来组合实现，HashMap 就是这种应用的一个典型。实际上，HashMap 就是一个 链表数组，如下是它数据结构：\n\n　　　　　　　　　　　　　　\n\n　　从上图中，我们可以形象地看出HashMap底层实现还是数组，只是数组的每一项都是一条链。其中参数initialCapacity 就代表了该数组的长度，也就是桶的个数。在第三节我们已经了解了HashMap 的默认构造函数的源码：\n\n /**\n     * Constructs an empty HashMap with the default initial capacity\n     * (16) and the default load factor (0.75).\n     */\n    public HashMap() {\n\n        //负载因子:用于衡量的是一个散列表的空间的使用程度\n        this.loadFactor = DEFAULT_LOAD_FACTOR; \n\n        //HashMap进行扩容的阈值，它的值等于 HashMap 的容量乘以负载因子\n        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[DEFAULT_INITIAL_CAPACITY];\n\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n　　从上述源码中我们可以看出，每次新建一个HashMap时，都会初始化一个Entry类型的table数组，其中 Entry类型的定义如下：\n\nstatic class Entry<K,V> implements Map.Entry<K,V> {\n\n    final K key;     // 键值对的键\n    V value;        // 键值对的值\n    Entry<K,V> next;    // 下一个节点\n    final int hash;     // hash(key.hashCode())方法的返回值\n\n    /**\n     * Creates new entry.\n     */\n    Entry(int h, K k, V v, Entry<K,V> n) {     // Entry 的构造函数\n        value = v;\n        next = n;\n        key = k;\n        hash = h;\n    }\n\n    ......\n\n}\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n　　其中，Entry为HashMap的内部类，实现了 Map.Entry 接口，其包含了键key、值value、下一个节点next，以及hash值四个属性。事实上，Entry 是构成哈希表的基石，是哈希表所存储的元素的具体形式。\n\n五. HashMap 的快速存取\n　　在HashMap中，我们最常用的两个操作就是：put(Key,Value) 和 get(Key)。我们都知道，HashMap中的Key是唯一的，那它是如何保证唯一性的呢？我们首先想到的是用equals比较，没错，这样可以实现，但随着元素的增多，put 和 get 的效率将越来越低，这里的时间复杂度是O(n)。也就是说，假如 HashMap 有1000个元素，那么 put时就需要比较 1000 次，这是相当耗时的，远达不到HashMap快速存取的目的。实际上，HashMap 很少会用到equals方法，因为其内通过一个哈希表管理所有元素，利用哈希算法可以快速的存取元素。当我们调用put方法存值时，HashMap首先会调用Key的hashCode方法，然后基于此获取Key哈希码，通过哈希码快速找到某个桶，这个位置可以被称之为 bucketIndex。通过《Java 中的 ==, equals 与 hashCode 的区别与联系》 所述hashCode的协定可以知道，如果两个对象的hashCode不同，那么equals一定为 false；否则，如果其hashCode相同，equals也不一定为 true。所以，理论上，hashCode 可能存在碰撞的情况，当碰撞发生时，这时会取出bucketIndex桶内已存储的元素，并通过hashCode() 和 equals() 来逐个比较以判断Key是否已存在。如果已存在，则使用新Value值替换旧Value值，并返回旧Value值；如果不存在，则存放新的键值对<Key, Value>到桶中。因此，在 HashMap中，equals() 方法只有在哈希码碰撞时才会被用到。\n\n　　下面我们结合JDK源码看HashMap 的存取实现。\n\n1、HashMap 的存储实现\n\n　　在 HashMap 中，键值对的存储是通过 put(key,vlaue) 方法来实现的，其源码如下：\n\n    /**\n     * Associates the specified value with the specified key in this map.\n     * If the map previously contained a mapping for the key, the old\n     * value is replaced.\n     *\n     * @param key key with which the specified value is to be associated\n     * @param value value to be associated with the specified key\n     * @return the previous value associated with key, or null if there was no mapping for key.\n     *  Note that a null return can also indicate that the map previously associated null with key.\n     */\n    public V put(K key, V value) {\n\n        //当key为null时，调用putForNullKey方法，并将该键值对保存到table的第一个位置 \n        if (key == null)\n            return putForNullKey(value); \n\n        //根据key的hashCode计算hash值\n        int hash = hash(key.hashCode());             //  ------- (1)\n\n        //计算该键值对在数组中的存储位置（哪个桶）\n        int i = indexFor(hash, table.length);              // ------- (2)\n\n        //在table的第i个桶上进行迭代，寻找 key 保存的位置\n        for (Entry<K,V> e = table[i]; e != null; e = e.next) {      // ------- (3)\n            Object k;\n            //判断该条链上是否存在hash值相同且key值相等的映射，若存在，则直接覆盖 value，并返回旧value\n            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {\n                V oldValue = e.value;\n                e.value = value;\n                e.recordAccess(this);\n                return oldValue;    // 返回旧值\n            }\n        }\n\n        modCount++; //修改次数增加1，快速失败机制\n\n        //原HashMap中无该映射，将该添加至该链的链头\n        addEntry(hash, key, value, i);            \n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n　　通过上述源码我们可以清楚了解到HashMap保存数据的过程。首先，判断key是否为null，若为null，则直接调用putForNullKey方法；若不为空，则先计算key的hash值，然后根据hash值搜索在table数组中的索引位置，如果table数组在该位置处有元素，则查找是否存在相同的key，若存在则覆盖原来key的value，否则将该元素保存在链头（最先保存的元素放在链尾）。此外，若table在该处没有元素，则直接保存。这个过程看似比较简单，但其实有很多需要回味的地方，下面我们一一来看。\n\n　　先看源码中的 (3) 处，此处迭代原因就是为了防止存在相同的key值。如果发现两个hash值（key）相同时，HashMap的处理方式是用新value替换旧value，这里并没有处理key，这正好解释了 HashMap 中没有两个相同的 key。\n\n1). 对NULL键的特别处理：putForNullKey()\n\n我们直接看其源码：\n\n    /**\n     * Offloaded version of put for null keys\n     */\n    private V putForNullKey(V value) {\n        // 若key==null，则将其放入table的第一个桶，即 table[0]\n        for (Entry<K,V> e = table[0]; e != null; e = e.next) {   \n            if (e.key == null) {   // 若已经存在key为null的键，则替换其值，并返回旧值\n                V oldValue = e.value;\n                e.value = value;\n                e.recordAccess(this);\n                return oldValue;\n            }\n        }\n        modCount++;        // 快速失败\n        addEntry(0, null, value, 0);       // 否则，将其添加到 table[0] 的桶中\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n　　通过上述源码我们可以清楚知到，HashMap 中可以保存键为NULL的键值对，且该键值对是唯一的。若再次向其中添加键为NULL的键值对，将覆盖其原值。此外，如果HashMap中存在键为NULL的键值对，那么一定在第一个桶中。\n\n2). HashMap 中的哈希策略（算法）\n\n　　在上述的 put(key,vlaue) 方法的源码中，我们标出了 HashMap 中的哈希策略（即(1)、(2)两处），hash() 方法用于对Key的hashCode进行重新计算，而 indexFor() 方法用于生成这个Entry对象的插入位置。当计算出来的hash值与hashMap的(length-1)做了&运算后，会得到位于区间[0，length-1]的一个值。特别地，这个值分布的越均匀， HashMap 的空间利用率也就越高，存取效率也就越好。\n\n　　我们首先看(1)处的 hash() 方法，该方法为一个纯粹的数学计算，用于进一步计算key的hash值，源码如下：\n\n    /**\n     * Applies a supplemental hash function to a given hashCode, which\n     * defends against poor quality hash functions.  This is critical\n     * because HashMap uses power-of-two length hash tables, that\n     * otherwise encounter collisions for hashCodes that do not differ\n     * in lower bits. \n     * \n     * Note: Null keys always map to hash 0, thus index 0.\n     */\n    static int hash(int h) {\n        // This function ensures that hashCodes that differ only by\n        // constant multiples at each bit position have a bounded\n        // number of collisions (approximately 8 at default load factor).\n        h ^= (h >>> 20) ^ (h >>> 12);\n        return h ^ (h >>> 7) ^ (h >>> 4);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n　　正如JDK官方对该方法的描述那样，使用hash()方法对一个对象的hashCode进行重新计算是为了防止质量低下的hashCode()函数实现。由于hashMap的支撑数组长度总是 2 的幂次，通过右移可以使低位的数据尽量的不同，从而使hash值的分布尽量均匀。更多关于该 hash(int h)方法的介绍请见《HashMap hash方法分析》，此不赘述。\n\n　通过上述hash()方法计算得到 Key 的 hash值 后，怎么才能保证元素均匀分布到table的每个桶中呢？我们会想到取模，但是由于取模的效率较低，HashMap 是通过调用(2)处的indexFor()方法处理的，其不但简单而且效率很高，对应源码如下所示：\n\n    /**\n     * Returns index for hash code h.\n     */\n    static int indexFor(int h, int length) {\n        return h & (length-1);  // 作用等价于取模运算，但这种方式效率更高\n    }\n1\n2\n3\n4\n5\n6\n　　我们知道，HashMap的底层数组长度总是2的n次方。当length为2的n次方时，h&(length - 1)就相当于对length取模，而且速度比直接取模要快得多，这是HashMap在速度上的一个优化。至于HashMap的底层数组长度为什么是2的n次方，下一节将给出解释。\n\n　　总而言之，上述的hash()方法和indexFor()方法的作用只有一个：保证元素均匀分布到table的每个桶中以便充分利用空间。\n\n3). HashMap 中键值对的添加：addEntry()\n我们直接看其源码：\n\n     /**\n     * Adds a new entry with the specified key, value and hash code to\n     * the specified bucket.  It is the responsibility of this\n     * method to resize the table if appropriate.\n     *\n     * Subclass overrides this to alter the behavior of put method.\n     * \n     * 永远都是在链表的表头添加新元素\n     */\n    void addEntry(int hash, K key, V value, int bucketIndex) {\n\n        //获取bucketIndex处的链表\n        Entry<K,V> e = table[bucketIndex];\n\n        //将新创建的 Entry 链入 bucketIndex处的链表的表头 \n        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);\n\n        //若HashMap中元素的个数超过极限值 threshold，则容量扩大两倍\n        if (size++ >= threshold)\n            resize(2 * table.length);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n　　通过上述源码我们可以清楚地了解到 链的产生时机。HashMap 总是将新的Entry对象添加到bucketIndex处，若bucketIndex处已经有了Entry对象，那么新添加的Entry对象将指向原有的Entry对象，并形成一条新的以它为链头的Entry链；但是，若bucketIndex处原先没有Entry对象，那么新添加的Entry对象将指向 null，也就生成了一条长度为 1 的全新的Entry链了。HashMap 永远都是在链表的表头添加新元素。此外，若HashMap中元素的个数超过极限值 threshold，其将进行扩容操作，一般情况下，容量将扩大至原来的两倍。\n\n4). HashMap 的扩容：resize()\n\n　　随着HashMap中元素的数量越来越多，发生碰撞的概率将越来越大，所产生的子链长度就会越来越长，这样势必会影响HashMap的存取速度。为了保证HashMap的效率，系统必须要在某个临界点进行扩容处理，该临界点就是HashMap中元素的数量在数值上等于threshold（table数组长度*加载因子）。但是，不得不说，扩容是一个非常耗时的过程，因为它需要重新计算这些元素在新table数组中的位置并进行复制处理。所以，如果我们能够提前预知HashMap 中元素的个数，那么在构造HashMap时预设元素的个数能够有效的提高HashMap的性能。我们直接看其源码：\n\n     /**\n     * Rehashes the contents of this map into a new array with a\n     * larger capacity.  This method is called automatically when the\n     * number of keys in this map reaches its threshold.\n     *\n     * If current capacity is MAXIMUM_CAPACITY, this method does not\n     * resize the map, but sets threshold to Integer.MAX_VALUE.\n     * This has the effect of preventing future calls.\n     *\n     * @param newCapacity the new capacity, MUST be a power of two;\n     *        must be greater than current capacity unless current\n     *        capacity is MAXIMUM_CAPACITY (in which case value\n     *        is irrelevant).\n     */\n    void resize(int newCapacity) {\n        Entry[] oldTable = table;\n        int oldCapacity = oldTable.length;\n\n        // 若 oldCapacity 已达到最大值，直接将 threshold 设为 Integer.MAX_VALUE\n        if (oldCapacity == MAXIMUM_CAPACITY) {  \n            threshold = Integer.MAX_VALUE;\n            return;             // 直接返回\n        }\n\n        // 否则，创建一个更大的数组\n        Entry[] newTable = new Entry[newCapacity];\n\n        //将每条Entry重新哈希到新的数组中\n        transfer(newTable);\n\n        table = newTable;\n        threshold = (int)(newCapacity * loadFactor);  // 重新设定 threshold\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n　　该方法的作用及触发动机如下：\n\n　　Rehashes the contents of this map into a new array with a larger capacity. This method is called automatically when the number of keys in this map reaches its threshold.\n\n5). HashMap 的重哈希：transfer()\n\n　　重哈希的主要是一个重新计算原HashMap中的元素在新table数组中的位置并进行复制处理的过程，我们直接看其源码：\n\n    /**\n     * Transfers all entries from current table to newTable.\n     */\n    void transfer(Entry[] newTable) {\n\n        // 将原数组 table 赋给数组 src\n        Entry[] src = table;\n        int newCapacity = newTable.length;\n\n        // 将数组 src 中的每条链重新添加到 newTable 中\n        for (int j = 0; j < src.length; j++) {\n            Entry<K,V> e = src[j];\n            if (e != null) {\n                src[j] = null;   // src 回收\n\n                // 将每条链的每个元素依次添加到 newTable 中相应的桶中\n                do {\n                    Entry<K,V> next = e.next;\n\n                    // e.hash指的是 hash(key.hashCode())的返回值;\n                    // 计算在newTable中的位置，注意原来在同一条子链上的元素可能被分配到不同的子链\n                    int i = indexFor(e.hash, newCapacity);   \n                    e.next = newTable[i];\n                    newTable[i] = e;\n                    e = next;\n                } while (e != null);\n            }\n        }\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n　　特别需要注意的是，在重哈希的过程中，原属于一个桶中的Entry对象可能被分到不同的桶，因为HashMap 的容量发生了变化，那么 h&(length - 1) 的值也会发生相应的变化。极端地说，如果重哈希后，原属于一个桶中的Entry对象仍属于同一桶，那么重哈希也就失去了意义。\n\n2、HashMap 的读取实现\n\n　　相对于HashMap的存储而言，读取就显得比较简单了。因为，HashMap只需通过key的hash值定位到table数组的某个特定的桶，然后查找并返回该key对应的value即可，源码如下：\n\n/**\n     * Returns the value to which the specified key is mapped,\n     * or {@code null} if this map contains no mapping for the key.\n     *\n     * <p>More formally, if this map contains a mapping from a key\n     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :\n     * key.equals(k))}, then this method returns {@code v}; otherwise\n     * it returns {@code null}.  (There can be at most one such mapping.)\n     *\n     * <p>A return value of {@code null} does not <i>necessarily</i>\n     * indicate that the map contains no mapping for the key; it\'s also\n     * possible that the map explicitly maps the key to {@code null}.\n     * The {@link #containsKey containsKey} operation may be used to\n     * distinguish these two cases.\n     *\n     * @see #put(Object, Object)\n     */\n    public V get(Object key) {\n        // 若为null，调用getForNullKey方法返回相对应的value\n        if (key == null)\n            // 从table的第一个桶中寻找 key 为 null 的映射；若不存在，直接返回null\n            return getForNullKey();  \n\n        // 根据该 key 的 hashCode 值计算它的 hash 码 \n        int hash = hash(key.hashCode());\n        // 找出 table 数组中对应的桶\n        for (Entry<K,V> e = table[indexFor(hash, table.length)];\n             e != null;\n             e = e.next) {\n            Object k;\n            //若搜索的key与查找的key相同，则返回相对应的value\n            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))\n                return e.value;\n        }\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n　　在这里能够根据key快速的取到value，除了和HashMap的数据结构密不可分外，还和Entry有莫大的关系。在前面就已经提到过，HashMap在存储过程中并没有将key，value分开来存储，而是当做一个整体key-value来处理的，这个整体就是Entry对象。特别地，在Entry对象中，value的地位要比key低一些，相当于是 key 的附属。\n\n　　其中，针对键为NULL的键值对，HashMap 提供了专门的处理：getForNullKey()，其源码如下：\n\n /**\n     * Offloaded version of get() to look up null keys.  Null keys map\n     * to index 0.  This null case is split out into separate methods\n     * for the sake of performance in the two most commonly used\n     * operations (get and put), but incorporated with conditionals in\n     * others.\n     */\n    private V getForNullKey() {\n        // 键为NULL的键值对若存在，则必定在第一个桶中\n        for (Entry<K,V> e = table[0]; e != null; e = e.next) {\n            if (e.key == null)\n                return e.value;\n        }\n        // 键为NULL的键值对若不存在，则直接返回 null\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n因此，调用HashMap的get(Object key)方法后，若返回值是 NULL，则存在如下两种可能：\n\n该 key 对应的值就是 null;\nHashMap 中不存在该 key。\n3、HashMap 存取小结\n\n　　在存储的过程中，系统根据key的hash值来定位Entry在table数组中的哪个桶，并且将其放到对应的链表的链头；在取的过程中，同样根据key的hash值来定位Entry在table数组中的哪个桶，然后在该桶中查找并返回。\n\n六. HashMap 的底层数组长度为何总是2的n次方？\n　　我们知道，HashMap的底层数组长度总是2的n次方，原因是 HashMap 在其构造函数 HashMap(int initialCapacity, float loadFactor) 中作了特别的处理，如下面的代码所示。当底层数组的length为2的n次方时， h&(length - 1) 就相当于对length取模，其效率要比直接取模高得多，这是HashMap在效率上的一个优化。\n\n// HashMap 的容量必须是2的幂次方，超过 initialCapacity 的最小 2^n \nint capacity = 1;\nwhile (capacity < initialCapacity)\n    capacity <<= 1;  \n1\n2\n3\n4\n　　在上文已经提到过，HashMap 中的数据结构是一个数组链表，我们希望的是元素存放的越均匀越好。最理想的效果是，Entry数组中每个位置都只有一个元素，这样，查询的时候效率最高，不需要遍历单链表，也不需要通过equals去比较Key，而且空间利用率最大。\n\n　　那如何计算才会分布最均匀呢？正如上一节提到的，HashMap采用了一个分两步走的哈希策略：\n\n使用 hash() 方法用于对Key的hashCode进行重新计算，以防止质量低下的hashCode()函数实现。由于hashMap的支撑数组长度总是 2 的倍数，通过右移可以使低位的数据尽量的不同，从而使Key的hash值的分布尽量均匀；\n\n使用 indexFor() 方法进行取余运算，以使Entry对象的插入位置尽量分布均匀(下文将专门对此阐述)。\n\n对于取余运算，我们首先想到的是：哈希值%length = bucketIndex。但当底层数组的length为2的n次方时， h&(length - 1) 就相当于对length取模，而且速度比直接取模快得多，这是HashMap在速度上的一个优化。除此之外，HashMap 的底层数组长度总是2的n次方的主要原因是什么呢？我们借助于 chenssy 在其博客《java提高篇（二三）—–HashMap》 中的关于这个问题的阐述：\n\n　　这里，我们假设length分别为16(2^4) 和 15，h 分别为 5、6、7。\n\n　　 　　　 　　 　　　　　 \n\n　　我们可以看到，当n=15时，6和7的结果一样，即它们位于table的同一个桶中，也就是产生了碰撞，6、7就会在这个桶中形成链表，这样就会导致查询速度降低。诚然这里只分析三个数字不是很多，那么我们再看 h 分别取 0-15时的情况。\n\n　　 　　　 　　 　　　　　 \n\n　　从上面的图表中我们可以看到，当 length 为15时总共发生了8次碰撞，同时发现空间浪费非常大，因为在 1、3、5、7、9、11、13、15 这八处没有存放数据。这是因为hash值在与14（即 1110）进行&运算时，得到的结果最后一位永远都是0，即 0001、0011、0101、0111、1001、1011、1101、1111位置处是不可能存储数据的。这样，空间的减少会导致碰撞几率的进一步增加，从而就会导致查询速度慢。\n\n　　而当length为16时，length – 1 = 15， 即 1111，那么，在进行低位&运算时，值总是与原来hash值相同，而进行高位运算时，其值等于其低位值。所以，当 length=2^n 时，不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，查询速度也较快。\n\n　因此，总的来说，HashMap 的底层数组长度总是2的n次方的原因有两个，即当 length=2^n 时：\n\n不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，空间利用率较高，查询速度也较快；\n\nh&(length - 1) 就相当于对length取模，而且在速度、效率上比直接取模要快得多，即二者是等价不等效的，这是HashMap在速度和效率上的一个优化。\n\n七. 更多\n　　HashMap 的直接子类LinkedHashMap继承了HashMap的所用特性，并且还通过额外维护一个双向链表保持了有序性, 通过对比LinkedHashMap和HashMap的实现有助于更好的理解HashMap。关于LinkedHashMap的更多介绍，请参见我的另一篇博文《Map 综述（二）：彻头彻尾理解 LinkedHashMap》，欢迎指正~\n\n　更多关于哈希(Hash)和equals方法的介绍，请移步我的博文《Java 中的 ==, equals 与 hashCode 的区别与联系》。\n\n　更多关于 Java SE 进阶 方面的内容，请关注我的专栏 《Java SE 进阶之路》。本专栏主要研究Java基础知识、Java源码和设计模式，从初级到高级不断总结、剖析各知识点的内在逻辑，贯穿、覆盖整个Java知识面，在一步步完善、提高把自己的同时，把对Java的所学所思分享给大家。万丈高楼平地起，基础决定你的上限，让我们携手一起勇攀Java之巅…', 25, NULL, 'HashMap', 1, 47, 0, 0, '2020-02-01 13:17:56', '2020-02-01 13:17:56');

-- ----------------------------
-- Table structure for tb_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_category`;
CREATE TABLE `tb_blog_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类的名称',
  `category_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类的图标',
  `category_rank` int(11) NULL DEFAULT 1 COMMENT '分类的排序值 被使用的越多数值越大',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_category
-- ----------------------------
INSERT INTO `tb_blog_category` VALUES (25, 'java', '/admin/dist/img/category/02.png', 5, 0, '2020-01-21 11:06:58');

-- ----------------------------
-- Table structure for tb_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_comment`;
CREATE TABLE `tb_blog_comment`  (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint(20) NULL DEFAULT 0 COMMENT '关联的blog主键',
  `commentator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论者名称',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论人的邮箱',
  `q_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人qq号',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人昵称',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人头像',
  `website_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '网址',
  `comment_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论内容',
  `comment_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
  `commentator_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论时的ip地址',
  `reply_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '回复内容',
  `reply_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `comment_status` tinyint(4) NULL DEFAULT 0 COMMENT '是否审核通过 0-未审核 1-审核通过',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_comment
-- ----------------------------
INSERT INTO `tb_blog_comment` VALUES (27, 22, '不会敲代码的小白', '1406628376@qq.com', NULL, NULL, NULL, '', 'dadad', '2020-02-01 15:45:40', '', '不错呦', '2020-02-05 10:46:19', 1, 0);

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
  `tag_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 146 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_tag
-- ----------------------------
INSERT INTO `tb_blog_tag` VALUES (142, 'dasdsada', 0, '2020-01-21 11:07:58');
INSERT INTO `tb_blog_tag` VALUES (143, 'dada', 0, '2020-02-01 13:15:31');
INSERT INTO `tb_blog_tag` VALUES (144, 'HashMap', 0, '2020-02-01 13:17:56');
INSERT INTO `tb_blog_tag` VALUES (145, 'ha', 1, '2020-02-05 18:58:07');

-- ----------------------------
-- Table structure for tb_blog_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag_relation`;
CREATE TABLE `tb_blog_tag_relation`  (
  `relation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 302 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_tag_relation
-- ----------------------------
INSERT INTO `tb_blog_tag_relation` VALUES (297, 22, 143, '2020-02-01 13:15:31');
INSERT INTO `tb_blog_tag_relation` VALUES (298, 22, 143, '2020-02-01 13:15:31');
INSERT INTO `tb_blog_tag_relation` VALUES (299, 23, 143, '2020-02-01 13:16:16');
INSERT INTO `tb_blog_tag_relation` VALUES (300, 24, 144, '2020-02-01 13:17:56');
INSERT INTO `tb_blog_tag_relation` VALUES (301, 24, 144, '2020-02-01 13:17:56');

-- ----------------------------
-- Table structure for tb_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_config`;
CREATE TABLE `tb_config`  (
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '配置项的名称',
  `config_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '配置项的值',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`config_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_config
-- ----------------------------
INSERT INTO `tb_config` VALUES ('footerAbout', 'bug', '2018-11-11 20:33:23', '2020-01-01 02:16:49');
INSERT INTO `tb_config` VALUES ('footerCopyRight', '2020 不会敲代码的小白', '2018-11-11 20:33:31', '2020-01-01 02:16:49');
INSERT INTO `tb_config` VALUES ('footerICP', '冀 xxxxxx', '2018-11-11 20:33:27', '2020-01-01 02:16:49');
INSERT INTO `tb_config` VALUES ('footerPoweredBy', 'https://github.com/renjiahua945', '2018-11-11 20:33:36', '2020-01-01 02:16:49');
INSERT INTO `tb_config` VALUES ('footerPoweredByURL', 'https://github.com/renjiahua945', '2018-11-11 20:33:39', '2020-01-01 02:16:49');
INSERT INTO `tb_config` VALUES ('websiteDescription', '不会敲代码的小白的博客是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码', '2018-11-11 20:33:04', '2020-01-01 02:47:13');
INSERT INTO `tb_config` VALUES ('websiteIcon', '/admin/dist/img/favicon.png', '2018-11-11 20:33:11', '2020-01-01 02:47:13');
INSERT INTO `tb_config` VALUES ('websiteLogo', '/admin/dist/img/logo2.png', '2018-11-11 20:33:08', '2020-01-01 02:47:13');
INSERT INTO `tb_config` VALUES ('websiteName', '不会敲代码的小白的博客', '2018-11-11 20:33:01', '2020-01-01 02:47:13');
INSERT INTO `tb_config` VALUES ('yourAvatar', '/admin/dist/img/13.png', '2018-11-11 20:33:14', '2020-01-01 02:15:56');
INSERT INTO `tb_config` VALUES ('yourEmail', 'renjiahua945@vip.qq.com', '2018-11-11 20:33:17', '2020-01-01 02:15:56');
INSERT INTO `tb_config` VALUES ('yourName', '不会敲代码的小白', '2018-11-11 20:33:20', '2020-01-01 02:15:56');

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link`  (
  `link_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友链表主键id',
  `link_type` tinyint(4) NULL DEFAULT 0 COMMENT '友链类别 0-友链 1-推荐 2-个人网站',
  `link_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站名称',
  `link_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站链接',
  `link_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站描述',
  `link_rank` int(11) NULL DEFAULT 0 COMMENT '用于列表排序',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

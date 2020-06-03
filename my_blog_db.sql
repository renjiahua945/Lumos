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

 Date: 03/06/2020 20:57:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user`
(
    `admin_user_id`   int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员登陆名称',
    `login_password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员登陆密码',
    `nick_name`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员显示昵称',
    `locked`          tinyint(4)                                             NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
    PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin_user
-- ----------------------------
INSERT INTO `tb_admin_user`
VALUES (1, 'renjiahua', '027d3922dd6fa2060d6a9c1bbf69e122', '不会敲代码的小白', 0);

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;
CREATE TABLE `tb_blog`
(
    `blog_id`            bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
    `blog_title`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
    `blog_sub_url`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客自定义路径url',
    `blog_cover_image`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客封面图',
    `blog_content`       mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci   NULL COMMENT '博客内容',
    `blog_category_id`   int(11)                                                 NULL DEFAULT NULL COMMENT '博客分类id',
    `blog_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '博客分类(冗余字段)',
    `blog_tags`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标签',
    `blog_status`        tinyint(4)                                              NULL DEFAULT 0 COMMENT '0-草稿 1-发布',
    `blog_views`         bigint(20)                                              NULL DEFAULT 0 COMMENT '阅读量',
    `enable_comment`     tinyint(4)                                              NULL DEFAULT 0 COMMENT '0-允许评论 1-不允许评论',
    `is_deleted`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time`        datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`        datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 40
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog
-- ----------------------------
INSERT INTO `tb_blog`
VALUES (21, 'dasdasd', 'da', 'http://localhost/admin/dist/img/rand/37.jpg', 'dasdadasdad', 25, '大大啊啊分affa', 'dasdsada',
        1, 8, 0, 1, '2020-01-21 11:07:58', '2020-01-21 11:07:58');
INSERT INTO `tb_blog`
VALUES (22, 'dadad', '', 'https://localhost/admin/dist/img/rand/24.jpg', 'dadadadad', 25, 'java飒飒', 'dada', 1, 20, 0, 1,
        '2020-02-01 13:15:31', '2020-02-01 13:15:31');
INSERT INTO `tb_blog`
VALUES (23, 'dada', 'adada', 'https://localhost/admin/dist/img/rand/1.jpg', 'dadadadadada', 25, 'java', 'dada', 1, 13,
        0, 1, '2020-02-01 13:16:16', '2020-02-01 13:16:16');
INSERT INTO `tb_blog`
VALUES (24, 'Map 综述（一）：彻头彻尾理解 HashMap', '', 'https://localhost/admin/dist/img/rand/34.jpg',
        '摘要：\n\n　　HashMap是Map族中最为常用的一种，也是 Java Collection Framework 的重要成员。本文首先给出了 HashMap 的实质并概述了其与 Map、HashSet 的关系，紧接着给出了 HashMap 在 JDK 中的定义，并结合源码分析了其四种构造方式。最后，通过对 HashMap 的数据结构、实现原理、源码实现三个方面的剖析，深入到它底层 Hash 存储机制，解释了其底层数组长度总是 2 的 n 次方的原因，也揭示了其快速存取、扩容及扩容后的重哈希的原理与实现。\n\n友情提示：\n\n　　本文所有关于HashMap的源码都是基于 JDK 1.6 的，不同 JDK 版本之间也许会有些许差异，但不影响我们对 HashMap 的数据结构、原理等整体的把握和了解。\n\n　　HashMap 的直接子类LinkedHashMap继承了HashMap的所用特性，并且还通过额外维护一个双向链表保持了有序性, 通过对比LinkedHashMap和HashMap的实现有助于更好的理解HashMap。关于LinkedHashMap的更多介绍，请参见我的另一篇博文《Map 综述（二）：彻头彻尾理解 LinkedHashMap》，欢迎指正~\n\n版权声明：\n\n本文原创作者：书呆子Rico\n作者博客地址：http://blog.csdn.net/justloveyou_/\n\n一. HashMap 概述\n　　Map 是 Key-Value 对映射的抽象接口，该映射不包括重复的键，即一个键对应一个值。HashMap 是 Java Collection Framework 的重要成员，也是Map族(如下图所示)中我们最为常用的一种。简单地说，HashMap 是基于哈希表的 Map 接口的实现，以 Key-Value 的形式存在，即存储的对象是 Entry (同时包含了 Key 和 Value) 。在HashMap中，其会根据hash算法来计算key-value的存储位置并进行快速存取。特别地，HashMap最多只允许一条Entry的键为Null(多条会覆盖)，但允许多条Entry的值为Null。此外，HashMap 是 Map 的一个非同步的实现。\n　　　　　　　　　　　　\n\n　　同样地，HashSet 也是 Java Collection Framework 的重要成员，是 Set 接口的常用实现类，但其与 HashMap 有很多相似之处。对于 HashSet 而言，其采用 Hash 算法决定元素在Set中的存储位置，这样可以保证元素的快速存取；对于 HashMap 而言，其将 key-value 当成一个整体(Entry 对象)来处理，其也采用同样的 Hash 算法去决定 key-value 的存储位置从而保证键值对的快速存取。虽然 HashMap 和 HashSet 实现的接口规范不同，但是它们底层的 Hash 存储机制完全相同。实际上，HashSet 本身就是在 HashMap 的基础上实现的。因此，通过对 HashMap 的数据结构、实现原理、源码实现三个方面了解，我们不但可以进一步掌握其底层的 Hash 存储机制，也有助于对 HashSet 的了解。\n\n　　必须指出的是，虽然容器号称存储的是 Java 对象，但实际上并不会真正将 Java 对象放入容器中，只是在容器中保留这些对象的引用。也就是说，Java 容器实际上包含的是引用变量，而这些引用变量指向了我们要实际保存的 Java 对象。\n\n二. HashMap 在 JDK 中的定义\n　　HashMap实现了Map接口，并继承 AbstractMap 抽象类，其中 Map 接口定义了键值映射规则。和 AbstractCollection抽象类在 Collection 族的作用类似， AbstractMap 抽象类提供了 Map 接口的骨干实现，以最大限度地减少实现Map接口所需的工作。HashMap 在JDK中的定义为：\n\npublic class HashMap<K,V>\n    extends AbstractMap<K,V>\n    implements Map<K,V>, Cloneable, Serializable{\n...\n}\n1\n2\n3\n4\n5\n三. HashMap 的构造函数\n　　HashMap 一共提供了四个构造函数，其中 默认无参的构造函数 和 参数为Map的构造函数 为 Java Collection Framework 规范的推荐实现，其余两个构造函数则是 HashMap 专门提供的。\n\n1、HashMap()\n\n　　该构造函数意在构造一个具有> 默认初始容量 (16) 和 默认负载因子(0.75) 的空 HashMap，是 Java Collection Framework 规范推荐提供的，其源码如下：\n\n     /**\n     * Constructs an empty HashMap with the default initial capacity\n     * (16) and the default load factor (0.75).\n     */\n    public HashMap() {\n\n        //负载因子:用于衡量的是一个散列表的空间的使用程度\n        this.loadFactor = DEFAULT_LOAD_FACTOR; \n\n        //HashMap进行扩容的阈值，它的值等于 HashMap 的容量乘以负载因子\n        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[DEFAULT_INITIAL_CAPACITY];\n\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n2、HashMap(int initialCapacity, float loadFactor)\n\n　　该构造函数意在构造一个 指定初始容量 和 指定负载因子的空 HashMap，其源码如下：\n\n    /**\n     * Constructs an empty HashMap with the specified initial capacity and load factor.\n     */\n    public HashMap(int initialCapacity, float loadFactor) {\n        //初始容量不能小于 0\n        if (initialCapacity < 0)\n            throw new IllegalArgumentException(\"Illegal initial capacity: \" + initialCapacity);\n\n        //初始容量不能超过 2^30\n        if (initialCapacity > MAXIMUM_CAPACITY)\n            initialCapacity = MAXIMUM_CAPACITY;\n\n        //负载因子不能小于 0            \n        if (loadFactor <= 0 || Float.isNaN(loadFactor))\n            throw new IllegalArgumentException(\"Illegal load factor: \" +\n                                               loadFactor);\n\n        // HashMap 的容量必须是2的幂次方，超过 initialCapacity 的最小 2^n \n        int capacity = 1;\n        while (capacity < initialCapacity)\n            capacity <<= 1;   \n\n        //负载因子\n        this.loadFactor = loadFactor;\n\n        //设置HashMap的容量极限，当HashMap的容量达到该极限时就会进行自动扩容操作\n        threshold = (int)(capacity * loadFactor);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[capacity];\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n3、HashMap(int initialCapacity)\n\n　　该构造函数意在构造一个指定初始容量和默认负载因子 (0.75)的空 HashMap，其源码如下：\n\n    // Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75)\n    public HashMap(int initialCapacity) {\n        this(initialCapacity, DEFAULT_LOAD_FACTOR);  // 直接调用上述构造函数\n    }\n1\n2\n3\n4\n4、HashMap(Map<? extends K, ? extends V> m)\n\n　　该构造函数意在构造一个与指定 Map 具有相同映射的 HashMap，其 初始容量不小于 16 (具体依赖于指定Map的大小)，负载因子是 0.75，是 Java Collection Framework 规范推荐提供的，其源码如下：\n\n    // Constructs a new HashMap with the same mappings as the specified Map. \n    // The HashMap is created with default load factor (0.75) and an initial capacity\n    // sufficient to hold the mappings in the specified Map.\n    public HashMap(Map<? extends K, ? extends V> m) {\n\n        // 初始容量不小于 16 \n        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,\n                      DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);\n        putAllForCreate(m);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n　　在这里，我们提到了两个非常重要的参数：初始容量 和 负载因子，这两个参数是影响HashMap性能的重要参数。其中，容量表示哈希表中桶的数量 (table 数组的大小)，初始容量是创建哈希表时桶的数量；负载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度，它衡量的是一个散列表的空间的使用程度，负载因子越大表示散列表的装填程度越高，反之愈小。\n\n　　对于使用 拉链法（下文会提到）的哈希表来说，查找一个元素的平均时间是 O(1+a)，a 指的是链的长度，是一个常数。特别地，若负载因子越大，那么对空间的利用更充分，但查找效率的也就越低；若负载因子越小，那么哈希表的数据将越稀疏，对空间造成的浪费也就越严重。系统默认负载因子为 0.75，这是时间和空间成本上一种折衷，一般情况下我们是无需修改的。\n\n四. HashMap 的数据结构\n1、哈希的相关概念\n\n　　Hash 就是把任意长度的输入(又叫做预映射， pre-image)，通过哈希算法，变换成固定长度的输出(通常是整型)，该输出就是哈希值。这种转换是一种 压缩映射 ，也就是说，散列值的空间通常远小于输入的空间。不同的输入可能会散列成相同的输出，从而不可能从散列值来唯一的确定输入值。简单的说，就是一种将任意长度的消息压缩到某一固定长度的息摘要函数。\n\n2、哈希的应用：数据结构\n\n　　我们知道，数组的特点是：寻址容易，插入和删除困难；而链表的特点是：寻址困难，插入和删除容易。那么我们能不能综合两者的特性，做出一种寻址容易，插入和删除也容易的数据结构呢？答案是肯定的，这就是我们要提起的哈希表。事实上，哈希表有多种不同的实现方法，我们接下来解释的是最经典的一种方法 —— 拉链法，我们可以将其理解为 链表的数组，如下图所示：\n\n　　　　　　　　　　　　　　\n\n　　我们可以从上图看到，左边很明显是个数组，数组的每个成员是一个链表。该数据结构所容纳的所有元素均包含一个指针，用于元素间的链接。我们根据元素的自身特征把元素分配到不同的链表中去，反过来我们也正是通过这些特征找到正确的链表，再从链表中找出正确的元素。其中，根据元素特征计算元素数组下标的方法就是 哈希算法。\n\n　　总的来说，哈希表适合用作快速查找、删除的基本数据结构，通常需要总数据量可以放入内存。在使用哈希表时，有以下几个关键点：\n\nhash 函数（哈希算法）的选择：针对不同的对象(字符串、整数等)具体的哈希方法；\n\n碰撞处理：常用的有两种方式，一种是open hashing，即 >拉链法；另一种就是 closed hashing，即开地址法(opened addressing)。\n\n　　\n更多关于哈希(Hash)的介绍，请移步我的博文《Java 中的 ==, equals 与 hashCode 的区别与联系》。\n\n3、HashMap 的数据结构　　　　　　　　　　　　　\n\n　　我们知道，在Java中最常用的两种结构是 数组 和 链表，几乎所有的数据结构都可以利用这两种来组合实现，HashMap 就是这种应用的一个典型。实际上，HashMap 就是一个 链表数组，如下是它数据结构：\n\n　　　　　　　　　　　　　　\n\n　　从上图中，我们可以形象地看出HashMap底层实现还是数组，只是数组的每一项都是一条链。其中参数initialCapacity 就代表了该数组的长度，也就是桶的个数。在第三节我们已经了解了HashMap 的默认构造函数的源码：\n\n /**\n     * Constructs an empty HashMap with the default initial capacity\n     * (16) and the default load factor (0.75).\n     */\n    public HashMap() {\n\n        //负载因子:用于衡量的是一个散列表的空间的使用程度\n        this.loadFactor = DEFAULT_LOAD_FACTOR; \n\n        //HashMap进行扩容的阈值，它的值等于 HashMap 的容量乘以负载因子\n        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);\n\n        // HashMap的底层实现仍是数组，只是数组的每一项都是一条链\n        table = new Entry[DEFAULT_INITIAL_CAPACITY];\n\n        init();\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n　　从上述源码中我们可以看出，每次新建一个HashMap时，都会初始化一个Entry类型的table数组，其中 Entry类型的定义如下：\n\nstatic class Entry<K,V> implements Map.Entry<K,V> {\n\n    final K key;     // 键值对的键\n    V value;        // 键值对的值\n    Entry<K,V> next;    // 下一个节点\n    final int hash;     // hash(key.hashCode())方法的返回值\n\n    /**\n     * Creates new entry.\n     */\n    Entry(int h, K k, V v, Entry<K,V> n) {     // Entry 的构造函数\n        value = v;\n        next = n;\n        key = k;\n        hash = h;\n    }\n\n    ......\n\n}\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n　　其中，Entry为HashMap的内部类，实现了 Map.Entry 接口，其包含了键key、值value、下一个节点next，以及hash值四个属性。事实上，Entry 是构成哈希表的基石，是哈希表所存储的元素的具体形式。\n\n五. HashMap 的快速存取\n　　在HashMap中，我们最常用的两个操作就是：put(Key,Value) 和 get(Key)。我们都知道，HashMap中的Key是唯一的，那它是如何保证唯一性的呢？我们首先想到的是用equals比较，没错，这样可以实现，但随着元素的增多，put 和 get 的效率将越来越低，这里的时间复杂度是O(n)。也就是说，假如 HashMap 有1000个元素，那么 put时就需要比较 1000 次，这是相当耗时的，远达不到HashMap快速存取的目的。实际上，HashMap 很少会用到equals方法，因为其内通过一个哈希表管理所有元素，利用哈希算法可以快速的存取元素。当我们调用put方法存值时，HashMap首先会调用Key的hashCode方法，然后基于此获取Key哈希码，通过哈希码快速找到某个桶，这个位置可以被称之为 bucketIndex。通过《Java 中的 ==, equals 与 hashCode 的区别与联系》 所述hashCode的协定可以知道，如果两个对象的hashCode不同，那么equals一定为 false；否则，如果其hashCode相同，equals也不一定为 true。所以，理论上，hashCode 可能存在碰撞的情况，当碰撞发生时，这时会取出bucketIndex桶内已存储的元素，并通过hashCode() 和 equals() 来逐个比较以判断Key是否已存在。如果已存在，则使用新Value值替换旧Value值，并返回旧Value值；如果不存在，则存放新的键值对<Key, Value>到桶中。因此，在 HashMap中，equals() 方法只有在哈希码碰撞时才会被用到。\n\n　　下面我们结合JDK源码看HashMap 的存取实现。\n\n1、HashMap 的存储实现\n\n　　在 HashMap 中，键值对的存储是通过 put(key,vlaue) 方法来实现的，其源码如下：\n\n    /**\n     * Associates the specified value with the specified key in this map.\n     * If the map previously contained a mapping for the key, the old\n     * value is replaced.\n     *\n     * @param key key with which the specified value is to be associated\n     * @param value value to be associated with the specified key\n     * @return the previous value associated with key, or null if there was no mapping for key.\n     *  Note that a null return can also indicate that the map previously associated null with key.\n     */\n    public V put(K key, V value) {\n\n        //当key为null时，调用putForNullKey方法，并将该键值对保存到table的第一个位置 \n        if (key == null)\n            return putForNullKey(value); \n\n        //根据key的hashCode计算hash值\n        int hash = hash(key.hashCode());             //  ------- (1)\n\n        //计算该键值对在数组中的存储位置（哪个桶）\n        int i = indexFor(hash, table.length);              // ------- (2)\n\n        //在table的第i个桶上进行迭代，寻找 key 保存的位置\n        for (Entry<K,V> e = table[i]; e != null; e = e.next) {      // ------- (3)\n            Object k;\n            //判断该条链上是否存在hash值相同且key值相等的映射，若存在，则直接覆盖 value，并返回旧value\n            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {\n                V oldValue = e.value;\n                e.value = value;\n                e.recordAccess(this);\n                return oldValue;    // 返回旧值\n            }\n        }\n\n        modCount++; //修改次数增加1，快速失败机制\n\n        //原HashMap中无该映射，将该添加至该链的链头\n        addEntry(hash, key, value, i);            \n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n　　通过上述源码我们可以清楚了解到HashMap保存数据的过程。首先，判断key是否为null，若为null，则直接调用putForNullKey方法；若不为空，则先计算key的hash值，然后根据hash值搜索在table数组中的索引位置，如果table数组在该位置处有元素，则查找是否存在相同的key，若存在则覆盖原来key的value，否则将该元素保存在链头（最先保存的元素放在链尾）。此外，若table在该处没有元素，则直接保存。这个过程看似比较简单，但其实有很多需要回味的地方，下面我们一一来看。\n\n　　先看源码中的 (3) 处，此处迭代原因就是为了防止存在相同的key值。如果发现两个hash值（key）相同时，HashMap的处理方式是用新value替换旧value，这里并没有处理key，这正好解释了 HashMap 中没有两个相同的 key。\n\n1). 对NULL键的特别处理：putForNullKey()\n\n我们直接看其源码：\n\n    /**\n     * Offloaded version of put for null keys\n     */\n    private V putForNullKey(V value) {\n        // 若key==null，则将其放入table的第一个桶，即 table[0]\n        for (Entry<K,V> e = table[0]; e != null; e = e.next) {   \n            if (e.key == null) {   // 若已经存在key为null的键，则替换其值，并返回旧值\n                V oldValue = e.value;\n                e.value = value;\n                e.recordAccess(this);\n                return oldValue;\n            }\n        }\n        modCount++;        // 快速失败\n        addEntry(0, null, value, 0);       // 否则，将其添加到 table[0] 的桶中\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n　　通过上述源码我们可以清楚知到，HashMap 中可以保存键为NULL的键值对，且该键值对是唯一的。若再次向其中添加键为NULL的键值对，将覆盖其原值。此外，如果HashMap中存在键为NULL的键值对，那么一定在第一个桶中。\n\n2). HashMap 中的哈希策略（算法）\n\n　　在上述的 put(key,vlaue) 方法的源码中，我们标出了 HashMap 中的哈希策略（即(1)、(2)两处），hash() 方法用于对Key的hashCode进行重新计算，而 indexFor() 方法用于生成这个Entry对象的插入位置。当计算出来的hash值与hashMap的(length-1)做了&运算后，会得到位于区间[0，length-1]的一个值。特别地，这个值分布的越均匀， HashMap 的空间利用率也就越高，存取效率也就越好。\n\n　　我们首先看(1)处的 hash() 方法，该方法为一个纯粹的数学计算，用于进一步计算key的hash值，源码如下：\n\n    /**\n     * Applies a supplemental hash function to a given hashCode, which\n     * defends against poor quality hash functions.  This is critical\n     * because HashMap uses power-of-two length hash tables, that\n     * otherwise encounter collisions for hashCodes that do not differ\n     * in lower bits. \n     * \n     * Note: Null keys always map to hash 0, thus index 0.\n     */\n    static int hash(int h) {\n        // This function ensures that hashCodes that differ only by\n        // constant multiples at each bit position have a bounded\n        // number of collisions (approximately 8 at default load factor).\n        h ^= (h >>> 20) ^ (h >>> 12);\n        return h ^ (h >>> 7) ^ (h >>> 4);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n　　正如JDK官方对该方法的描述那样，使用hash()方法对一个对象的hashCode进行重新计算是为了防止质量低下的hashCode()函数实现。由于hashMap的支撑数组长度总是 2 的幂次，通过右移可以使低位的数据尽量的不同，从而使hash值的分布尽量均匀。更多关于该 hash(int h)方法的介绍请见《HashMap hash方法分析》，此不赘述。\n\n　通过上述hash()方法计算得到 Key 的 hash值 后，怎么才能保证元素均匀分布到table的每个桶中呢？我们会想到取模，但是由于取模的效率较低，HashMap 是通过调用(2)处的indexFor()方法处理的，其不但简单而且效率很高，对应源码如下所示：\n\n    /**\n     * Returns index for hash code h.\n     */\n    static int indexFor(int h, int length) {\n        return h & (length-1);  // 作用等价于取模运算，但这种方式效率更高\n    }\n1\n2\n3\n4\n5\n6\n　　我们知道，HashMap的底层数组长度总是2的n次方。当length为2的n次方时，h&(length - 1)就相当于对length取模，而且速度比直接取模要快得多，这是HashMap在速度上的一个优化。至于HashMap的底层数组长度为什么是2的n次方，下一节将给出解释。\n\n　　总而言之，上述的hash()方法和indexFor()方法的作用只有一个：保证元素均匀分布到table的每个桶中以便充分利用空间。\n\n3). HashMap 中键值对的添加：addEntry()\n我们直接看其源码：\n\n     /**\n     * Adds a new entry with the specified key, value and hash code to\n     * the specified bucket.  It is the responsibility of this\n     * method to resize the table if appropriate.\n     *\n     * Subclass overrides this to alter the behavior of put method.\n     * \n     * 永远都是在链表的表头添加新元素\n     */\n    void addEntry(int hash, K key, V value, int bucketIndex) {\n\n        //获取bucketIndex处的链表\n        Entry<K,V> e = table[bucketIndex];\n\n        //将新创建的 Entry 链入 bucketIndex处的链表的表头 \n        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);\n\n        //若HashMap中元素的个数超过极限值 threshold，则容量扩大两倍\n        if (size++ >= threshold)\n            resize(2 * table.length);\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n　　通过上述源码我们可以清楚地了解到 链的产生时机。HashMap 总是将新的Entry对象添加到bucketIndex处，若bucketIndex处已经有了Entry对象，那么新添加的Entry对象将指向原有的Entry对象，并形成一条新的以它为链头的Entry链；但是，若bucketIndex处原先没有Entry对象，那么新添加的Entry对象将指向 null，也就生成了一条长度为 1 的全新的Entry链了。HashMap 永远都是在链表的表头添加新元素。此外，若HashMap中元素的个数超过极限值 threshold，其将进行扩容操作，一般情况下，容量将扩大至原来的两倍。\n\n4). HashMap 的扩容：resize()\n\n　　随着HashMap中元素的数量越来越多，发生碰撞的概率将越来越大，所产生的子链长度就会越来越长，这样势必会影响HashMap的存取速度。为了保证HashMap的效率，系统必须要在某个临界点进行扩容处理，该临界点就是HashMap中元素的数量在数值上等于threshold（table数组长度*加载因子）。但是，不得不说，扩容是一个非常耗时的过程，因为它需要重新计算这些元素在新table数组中的位置并进行复制处理。所以，如果我们能够提前预知HashMap 中元素的个数，那么在构造HashMap时预设元素的个数能够有效的提高HashMap的性能。我们直接看其源码：\n\n     /**\n     * Rehashes the contents of this map into a new array with a\n     * larger capacity.  This method is called automatically when the\n     * number of keys in this map reaches its threshold.\n     *\n     * If current capacity is MAXIMUM_CAPACITY, this method does not\n     * resize the map, but sets threshold to Integer.MAX_VALUE.\n     * This has the effect of preventing future calls.\n     *\n     * @param newCapacity the new capacity, MUST be a power of two;\n     *        must be greater than current capacity unless current\n     *        capacity is MAXIMUM_CAPACITY (in which case value\n     *        is irrelevant).\n     */\n    void resize(int newCapacity) {\n        Entry[] oldTable = table;\n        int oldCapacity = oldTable.length;\n\n        // 若 oldCapacity 已达到最大值，直接将 threshold 设为 Integer.MAX_VALUE\n        if (oldCapacity == MAXIMUM_CAPACITY) {  \n            threshold = Integer.MAX_VALUE;\n            return;             // 直接返回\n        }\n\n        // 否则，创建一个更大的数组\n        Entry[] newTable = new Entry[newCapacity];\n\n        //将每条Entry重新哈希到新的数组中\n        transfer(newTable);\n\n        table = newTable;\n        threshold = (int)(newCapacity * loadFactor);  // 重新设定 threshold\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n　　该方法的作用及触发动机如下：\n\n　　Rehashes the contents of this map into a new array with a larger capacity. This method is called automatically when the number of keys in this map reaches its threshold.\n\n5). HashMap 的重哈希：transfer()\n\n　　重哈希的主要是一个重新计算原HashMap中的元素在新table数组中的位置并进行复制处理的过程，我们直接看其源码：\n\n    /**\n     * Transfers all entries from current table to newTable.\n     */\n    void transfer(Entry[] newTable) {\n\n        // 将原数组 table 赋给数组 src\n        Entry[] src = table;\n        int newCapacity = newTable.length;\n\n        // 将数组 src 中的每条链重新添加到 newTable 中\n        for (int j = 0; j < src.length; j++) {\n            Entry<K,V> e = src[j];\n            if (e != null) {\n                src[j] = null;   // src 回收\n\n                // 将每条链的每个元素依次添加到 newTable 中相应的桶中\n                do {\n                    Entry<K,V> next = e.next;\n\n                    // e.hash指的是 hash(key.hashCode())的返回值;\n                    // 计算在newTable中的位置，注意原来在同一条子链上的元素可能被分配到不同的子链\n                    int i = indexFor(e.hash, newCapacity);   \n                    e.next = newTable[i];\n                    newTable[i] = e;\n                    e = next;\n                } while (e != null);\n            }\n        }\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n　　特别需要注意的是，在重哈希的过程中，原属于一个桶中的Entry对象可能被分到不同的桶，因为HashMap 的容量发生了变化，那么 h&(length - 1) 的值也会发生相应的变化。极端地说，如果重哈希后，原属于一个桶中的Entry对象仍属于同一桶，那么重哈希也就失去了意义。\n\n2、HashMap 的读取实现\n\n　　相对于HashMap的存储而言，读取就显得比较简单了。因为，HashMap只需通过key的hash值定位到table数组的某个特定的桶，然后查找并返回该key对应的value即可，源码如下：\n\n/**\n     * Returns the value to which the specified key is mapped,\n     * or {@code null} if this map contains no mapping for the key.\n     *\n     * <p>More formally, if this map contains a mapping from a key\n     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :\n     * key.equals(k))}, then this method returns {@code v}; otherwise\n     * it returns {@code null}.  (There can be at most one such mapping.)\n     *\n     * <p>A return value of {@code null} does not <i>necessarily</i>\n     * indicate that the map contains no mapping for the key; it\'s also\n     * possible that the map explicitly maps the key to {@code null}.\n     * The {@link #containsKey containsKey} operation may be used to\n     * distinguish these two cases.\n     *\n     * @see #put(Object, Object)\n     */\n    public V get(Object key) {\n        // 若为null，调用getForNullKey方法返回相对应的value\n        if (key == null)\n            // 从table的第一个桶中寻找 key 为 null 的映射；若不存在，直接返回null\n            return getForNullKey();  \n\n        // 根据该 key 的 hashCode 值计算它的 hash 码 \n        int hash = hash(key.hashCode());\n        // 找出 table 数组中对应的桶\n        for (Entry<K,V> e = table[indexFor(hash, table.length)];\n             e != null;\n             e = e.next) {\n            Object k;\n            //若搜索的key与查找的key相同，则返回相对应的value\n            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))\n                return e.value;\n        }\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n　　在这里能够根据key快速的取到value，除了和HashMap的数据结构密不可分外，还和Entry有莫大的关系。在前面就已经提到过，HashMap在存储过程中并没有将key，value分开来存储，而是当做一个整体key-value来处理的，这个整体就是Entry对象。特别地，在Entry对象中，value的地位要比key低一些，相当于是 key 的附属。\n\n　　其中，针对键为NULL的键值对，HashMap 提供了专门的处理：getForNullKey()，其源码如下：\n\n /**\n     * Offloaded version of get() to look up null keys.  Null keys map\n     * to index 0.  This null case is split out into separate methods\n     * for the sake of performance in the two most commonly used\n     * operations (get and put), but incorporated with conditionals in\n     * others.\n     */\n    private V getForNullKey() {\n        // 键为NULL的键值对若存在，则必定在第一个桶中\n        for (Entry<K,V> e = table[0]; e != null; e = e.next) {\n            if (e.key == null)\n                return e.value;\n        }\n        // 键为NULL的键值对若不存在，则直接返回 null\n        return null;\n    }\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n因此，调用HashMap的get(Object key)方法后，若返回值是 NULL，则存在如下两种可能：\n\n该 key 对应的值就是 null;\nHashMap 中不存在该 key。\n3、HashMap 存取小结\n\n　　在存储的过程中，系统根据key的hash值来定位Entry在table数组中的哪个桶，并且将其放到对应的链表的链头；在取的过程中，同样根据key的hash值来定位Entry在table数组中的哪个桶，然后在该桶中查找并返回。\n\n六. HashMap 的底层数组长度为何总是2的n次方？\n　　我们知道，HashMap的底层数组长度总是2的n次方，原因是 HashMap 在其构造函数 HashMap(int initialCapacity, float loadFactor) 中作了特别的处理，如下面的代码所示。当底层数组的length为2的n次方时， h&(length - 1) 就相当于对length取模，其效率要比直接取模高得多，这是HashMap在效率上的一个优化。\n\n// HashMap 的容量必须是2的幂次方，超过 initialCapacity 的最小 2^n \nint capacity = 1;\nwhile (capacity < initialCapacity)\n    capacity <<= 1;  \n1\n2\n3\n4\n　　在上文已经提到过，HashMap 中的数据结构是一个数组链表，我们希望的是元素存放的越均匀越好。最理想的效果是，Entry数组中每个位置都只有一个元素，这样，查询的时候效率最高，不需要遍历单链表，也不需要通过equals去比较Key，而且空间利用率最大。\n\n　　那如何计算才会分布最均匀呢？正如上一节提到的，HashMap采用了一个分两步走的哈希策略：\n\n使用 hash() 方法用于对Key的hashCode进行重新计算，以防止质量低下的hashCode()函数实现。由于hashMap的支撑数组长度总是 2 的倍数，通过右移可以使低位的数据尽量的不同，从而使Key的hash值的分布尽量均匀；\n\n使用 indexFor() 方法进行取余运算，以使Entry对象的插入位置尽量分布均匀(下文将专门对此阐述)。\n\n对于取余运算，我们首先想到的是：哈希值%length = bucketIndex。但当底层数组的length为2的n次方时， h&(length - 1) 就相当于对length取模，而且速度比直接取模快得多，这是HashMap在速度上的一个优化。除此之外，HashMap 的底层数组长度总是2的n次方的主要原因是什么呢？我们借助于 chenssy 在其博客《java提高篇（二三）—–HashMap》 中的关于这个问题的阐述：\n\n　　这里，我们假设length分别为16(2^4) 和 15，h 分别为 5、6、7。\n\n　　 　　　 　　 　　　　　 \n\n　　我们可以看到，当n=15时，6和7的结果一样，即它们位于table的同一个桶中，也就是产生了碰撞，6、7就会在这个桶中形成链表，这样就会导致查询速度降低。诚然这里只分析三个数字不是很多，那么我们再看 h 分别取 0-15时的情况。\n\n　　 　　　 　　 　　　　　 \n\n　　从上面的图表中我们可以看到，当 length 为15时总共发生了8次碰撞，同时发现空间浪费非常大，因为在 1、3、5、7、9、11、13、15 这八处没有存放数据。这是因为hash值在与14（即 1110）进行&运算时，得到的结果最后一位永远都是0，即 0001、0011、0101、0111、1001、1011、1101、1111位置处是不可能存储数据的。这样，空间的减少会导致碰撞几率的进一步增加，从而就会导致查询速度慢。\n\n　　而当length为16时，length – 1 = 15， 即 1111，那么，在进行低位&运算时，值总是与原来hash值相同，而进行高位运算时，其值等于其低位值。所以，当 length=2^n 时，不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，查询速度也较快。\n\n　因此，总的来说，HashMap 的底层数组长度总是2的n次方的原因有两个，即当 length=2^n 时：\n\n不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，空间利用率较高，查询速度也较快；\n\nh&(length - 1) 就相当于对length取模，而且在速度、效率上比直接取模要快得多，即二者是等价不等效的，这是HashMap在速度和效率上的一个优化。\n\n七. 更多\n　　HashMap 的直接子类LinkedHashMap继承了HashMap的所用特性，并且还通过额外维护一个双向链表保持了有序性, 通过对比LinkedHashMap和HashMap的实现有助于更好的理解HashMap。关于LinkedHashMap的更多介绍，请参见我的另一篇博文《Map 综述（二）：彻头彻尾理解 LinkedHashMap》，欢迎指正~\n\n　更多关于哈希(Hash)和equals方法的介绍，请移步我的博文《Java 中的 ==, equals 与 hashCode 的区别与联系》。\n\n　更多关于 Java SE 进阶 方面的内容，请关注我的专栏 《Java SE 进阶之路》。本专栏主要研究Java基础知识、Java源码和设计模式，从初级到高级不断总结、剖析各知识点的内在逻辑，贯穿、覆盖整个Java知识面，在一步步完善、提高把自己的同时，把对Java的所学所思分享给大家。万丈高楼平地起，基础决定你的上限，让我们携手一起勇攀Java之巅…',
        25, 'java', 'HashMap', 1, 60, 0, 1, '2020-02-01 13:17:56', '2020-02-01 13:17:56');
INSERT INTO `tb_blog`
VALUES (25, '阿达v啊发发啊', '', 'https://localhost/admin/dist/img/rand/5.jpg', '大阿达打发发发', 25, 'java', '大大a,a大啊的啊', 1, 3, 0,
        1, '2020-03-09 16:14:03', '2020-03-09 16:14:03');
INSERT INTO `tb_blog`
VALUES (26, 'da afafa', '', 'https://localhost/admin/dist/img/rand/6.jpg', 'faa fa ff', 25, 'java', 'a fa', 1, 3, 0, 0,
        '2020-03-09 17:29:14', '2020-03-09 17:29:14');
INSERT INTO `tb_blog`
VALUES (27, '深入浅出学Java——HashMap', '', 'https://localhost/admin/dist/img/rand/18.jpg',
        '深入浅出学Java——HashMap\n哈希表（hash table）\n也叫散列表，是一种非常重要的数据结构，应用场景及其丰富，许多缓存技术（比如memcached）的核心其实就是在内存中维护一张大的哈希表，本文会对java集合框架中HashMap的实现原理进行讲解，并对JDK7的HashMap源码进行分析。\n\n一、什么是哈希表\n\n在讨论哈希表之前，我们先大概了解下其他数据结构在新增，查找等基础操作执行性能\n\n数组：采用一段连续的存储单元来存储数据。对于指定下标的查找，时间复杂度为O(1)；通过给定值进行查找，需要遍历数组，逐一比对给定关键字和数组元素，时间复杂度为O(n)，当然，对于有序数组，则可采用二分查找，插值查找，斐波那契查找等方式，可将查找复杂度提高为O(logn)；对于一般的插入删除操作，涉及到数组元素的移动，其平均复杂度也为O(n)\n\n线性链表：对于链表的新增，删除等操作（在找到指定操作位置后），仅需处理结点间的引用即可，时间复杂度为O(1)，而查找操作需要遍历链表逐一进行比对，复杂度为O(n)\n\n二叉树：对一棵相对平衡的有序二叉树，对其进行插入，查找，删除等操作，平均复杂度均为O(logn)。\n\n哈希表：相比上述几种数据结构，在哈希表中进行添加，删除，查找等操作，性能十分之高，不考虑哈希冲突的情况下（后面会探讨下哈希冲突的情况），仅需一次定位即可完成，时间复杂度为O(1)，接下来我们就来看看哈希表是如何实现达到惊艳的常数阶O(1)的。\n\n我们知道，数据结构的物理存储结构只有两种：顺序存储结构和链式存储结构（像栈，队列，树，图等是从逻辑结构去抽象的，映射到内存中，也这两种物理组织形式），而在上面我们提到过，在数组中根据下标查找某个元素，一次定位就可以达到，哈希表利用了这种特性，哈希表的主干就是数组。\n\n比如我们要新增或查找某个元素，我们通过把当前元素的关键字 通过某个函数映射到数组中的某个位置，通过数组下标一次定位就可完成操作。\n　　\n这个函数可以简单描述为：存储位置 = f(关键字) ，这个函数f一般称为哈希函数，这个函数的设计好坏会直接影响到哈希表的优劣。举个例子，比如我们要在哈希表中执行插入操作：\n插入过程如下图所示\n哈希表数据插入过程\n\n查找操作同理，先通过哈希函数计算出实际存储地址，然后从数组中对应地址取出即可。\n\n哈希冲突\n\n然而万事无完美，如果两个不同的元素，通过哈希函数得出的实际存储地址相同怎么办？也就是说，当我们对某个元素进行哈希运算，得到一个存储地址，然后要进行插入的时候，发现已经被其他元素占用了，其实这就是所谓的哈希冲突，也叫哈希碰撞。前面我们提到过，哈希函数的设计至关重要，好的哈希函数会尽可能地保证 计算简单和散列地址分布均匀,但是，我们需要清楚的是，数组是一块连续的固定长度的内存空间，再好的哈希函数也不能保证得到的存储地址绝对不发生冲突。那么哈希冲突如何解决呢？哈希冲突的解决方案有多种:开放定址法（发生冲突，继续寻找下一块未被占用的存储地址），再散列函数法，链地址法，而HashMap即是采用了链地址法，也就是数组+链表的方式。\n\n二、HashMap的实现原理\n\nHashMap的主干是一个Entry数组。Entry是HashMap的基本组成单元，每一个Entry包含一个key-value键值对。（其实所谓Map其实就是保存了两个对象之间的映射关系的一种集合）\n\n//HashMap的主干数组，可以看到就是一个Entry数组，初始值为空数组{}，主干数组的长度一定是2的次幂。\n//至于为什么这么做，后面会有详细分析。\ntransient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;\n1\n2\n3\nEntry是HashMap中的一个静态内部类。代码如下\n\n    static class Entry<K,V> implements Map.Entry<K,V> {\n        final K key;\n        V value;\n        Entry<K,V> next;//存储指向下一个Entry的引用，单链表结构\n        int hash;//对key的hashcode值进行hash运算后得到的值，存储在Entry，避免重复计算\n\n        /**\n         * Creates new entry.\n         */\n        Entry(int h, K k, V v, Entry<K,V> n) {\n            value = v;\n            next = n;\n            key = k;\n            hash = h;\n        } \n\n所以，HashMap的总体结构如下：\n在这里插入图片描述\n\n简单来说，HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,那么查找，添加等操作很快，仅需一次寻址即可；如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。\n\n其他几个重要字段\n\n/**实际存储的key-value键值对的个数*/\ntransient int size;\n\n/**阈值，当table == {}时，该值为初始容量（初始容量默认为16）；当table被填充了，也就是为table分配内存空间后，\nthreshold一般为 capacity*loadFactory。HashMap在进行扩容时需要参考threshold，后面会详细谈到*/\nint threshold;\n\n/**负载因子，代表了table的填充度有多少，默认是0.75\n加载因子存在的原因，还是因为减缓哈希冲突，如果初始桶为16，等到满16个元素才扩容，某些桶里可能就有不止一个元素了。\n所以加载因子默认为0.75，也就是说大小为16的HashMap，到了第13个元素，就会扩容成32。\n*/\nfinal float loadFactor;\n\n/**HashMap被改变的次数，由于HashMap非线程安全，在对HashMap进行迭代时，\n如果期间其他线程的参与导致HashMap的结构发生变化了（比如put，remove等操作），\n需要抛出异常ConcurrentModificationException*/\ntransient int modCount;\n\nHashMap有4个构造器，其他构造器如果用户没有传入initialCapacity 和loadFactor这两个参数，会使用默认值\n\ninitialCapacity默认为16，loadFactory默认为0.75\n\n我们看下其中一个\n\npublic HashMap(int initialCapacity, float loadFactor) {\n　　　　　//此处对传入的初始容量进行校验，最大不能超过MAXIMUM_CAPACITY = 1<<30(230)\n        if (initialCapacity < 0)\n            throw new IllegalArgumentException(\"Illegal initial capacity: \" +\n                                               initialCapacity);\n        if (initialCapacity > MAXIMUM_CAPACITY)\n            initialCapacity = MAXIMUM_CAPACITY;\n        if (loadFactor <= 0 || Float.isNaN(loadFactor))\n            throw new IllegalArgumentException(\"Illegal load factor: \" +\n                                               loadFactor);\n\n        this.loadFactor = loadFactor;\n        threshold = initialCapacity;\n　　　　　\n        init();//init方法在HashMap中没有实际实现，不过在其子类如 linkedHashMap中就会有对应实现\n    }\n\n从上面这段代码我们可以看出，在常规构造器中，没有为数组table分配内存空间（有一个入参为指定Map的构造器例外），而是在执行put操作的时候才真正构建table数组\n\nOK,接下来我们来看看put操作的实现\n\npublic V put(K key, V value) {\n        //如果table数组为空数组{}，进行数组填充（为table分配实际内存空间），入参为threshold，\n        //此时threshold为initialCapacity 默认是1<<4(24=16)\n        if (table == EMPTY_TABLE) {\n            inflateTable(threshold);\n        }\n       //如果key为null，存储位置为table[0]或table[0]的冲突链上\n        if (key == null)\n            return putForNullKey(value);\n        int hash = hash(key);//对key的hashcode进一步计算，确保散列均匀\n        int i = indexFor(hash, table.length);//获取在table中的实际位置\n        for (Entry<K,V> e = table[i]; e != null; e = e.next) {\n        //如果该对应数据已存在，执行覆盖操作。用新value替换旧value，并返回旧value\n            Object k;\n            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {\n                V oldValue = e.value;\n                e.value = value;\n                e.recordAccess(this);\n                return oldValue;\n            }\n        }\n        modCount++;//保证并发访问时，若HashMap内部结构发生变化，快速响应失败\n        addEntry(hash, key, value, i);//新增一个entry\n        return null;\n    }\n\ninflateTable这个方法用于为主干数组table在内存中分配存储空间，通过roundUpToPowerOf2(toSize)可以确保capacity为大于或等于toSize的最接近toSize的二次幂，比如toSize=13,则capacity=16;to_size=16,capacity=16;to_size=17,capacity=32.\n\nprivate void inflateTable(int toSize) {\n        int capacity = roundUpToPowerOf2(toSize);//capacity一定是2的次幂\n        /**此处为threshold赋值，取capacity*loadFactor和MAXIMUM_CAPACITY+1的最小值，\n        capaticy一定不会超过MAXIMUM_CAPACITY，除非loadFactor大于1 */\n        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);\n        table = new Entry[capacity];\n        initHashSeedAsNeeded(capacity);\n    }\n\nroundUpToPowerOf2中的这段处理使得数组长度一定为2的次幂，Integer.highestOneBit是用来获取最左边的bit（其他bit位为0）所代表的数值.\n\n private static int roundUpToPowerOf2(int number) {\n        // assert number >= 0 : \"number must be non-negative\";\n        return number >= MAXIMUM_CAPACITY\n                ? MAXIMUM_CAPACITY\n                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;\n    }\n\n\nhash函数\n\n/**这是一个神奇的函数，用了很多的异或，移位等运算\n对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀*/\nfinal int hash(Object k) {\n        int h = hashSeed;\n        if (0 != h && k instanceof String) {\n            return sun.misc.Hashing.stringHash32((String) k);\n        }\n\n        h ^= k.hashCode();\n\n        h ^= (h >>> 20) ^ (h >>> 12);\n        return h ^ (h >>> 7) ^ (h >>> 4);\n    }\n\n以上hash函数计算出的值，通过indexFor进一步处理来获取实际的存储位置\n\n/**\n     * 返回数组下标\n     */\n    static int indexFor(int h, int length) {\n        return h & (length-1);\n    }\n\n\nh&（length-1）保证获取的index一定在数组范围内，举个例子，默认容量16，length-1=15，h=18,转换成二进制计算为index=2。位运算对计算机来说，性能更高一些（HashMap中有大量位运算）\n\n所以最终存储位置的确定流程是这样的：\nHashMap如何确定元素位置\n\n再来看看addEntry的实现：\n\nvoid addEntry(int hash, K key, V value, int bucketIndex) {\n        if ((size >= threshold) && (null != table[bucketIndex])) {\n            resize(2 * table.length);//当size超过临界阈值threshold，并且即将发生哈希冲突时进行扩容\n            hash = (null != key) ? hash(key) : 0;\n            bucketIndex = indexFor(hash, table.length);\n        }\n\n        createEntry(hash, key, value, bucketIndex);\n    }\n\n通过以上代码能够得知，当发生哈希冲突并且size大于阈值的时候，需要进行数组扩容，扩容时，需要新建一个长度为之前数组2倍的新的数组，然后将当前的Entry数组中的元素全部传输过去，扩容后的新数组长度为之前的2倍，所以扩容相对来说是个耗资源的操作。\n\n三、为何HashMap的数组长度一定是2的次幂？\n\n我们来继续看上面提到的resize方法\n\nvoid resize(int newCapacity) {\n        Entry[] oldTable = table;\n        int oldCapacity = oldTable.length;\n        if (oldCapacity == MAXIMUM_CAPACITY) {\n            threshold = Integer.MAX_VALUE;\n            return;\n        }\n\n        Entry[] newTable = new Entry[newCapacity];\n        transfer(newTable, initHashSeedAsNeeded(newCapacity));\n        table = newTable;\n        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);\n    }\n\n如果数组进行扩容，数组长度发生变化，而存储位置 index = h&(length-1),index也可能会发生变化，需要重新计算index，我们先来看看transfer这个方法\n\nvoid transfer(Entry[] newTable, boolean rehash) {\n        int newCapacity = newTable.length;\n　　　　　//for循环中的代码，逐个遍历链表，重新计算索引位置，将老数组数据复制到新数组中去（数组不存储实际数据，所以仅仅是拷贝引用而已）\n        for (Entry<K,V> e : table) {\n            while(null != e) {\n                Entry<K,V> next = e.next;\n                if (rehash) {\n                    e.hash = null == e.key ? 0 : hash(e.key);\n                }\n                int i = indexFor(e.hash, newCapacity);\n                //将当前entry的next链指向新的索引位置,newTable[i]有可能为空，有可能也是个entry链，如果是entry链，直接在链表头部插入。\n                e.next = newTable[i];\n                newTable[i] = e;\n                e = next;\n            }\n        }\n    }\n\n这个方法将老数组中的数据逐个链表地遍历，扔到新的扩容后的数组中，我们的数组索引位置的计算是通过 对key值的hashcode进行hash扰乱运算后，再通过和 length-1进行位运算得到最终数组索引位置。\n\nHashMap的数组长度一定保持2的次幂，比如16的二进制表示为 10000，那么length-1就是15，二进制为01111，同理扩容后的数组长度为32，二进制表示为100000，length-1为31，二进制表示为011111。从下图可以我们也能看到这样会保证低位全为1，而扩容后只有一位差异，也就是多出了最左位的1，这样在通过 h&(length-1)的时候，只要h对应的最左边的那一个差异位为0，就能保证得到的新的数组索引和老数组索引一致(大大减少了之前已经散列良好的老数组的数据位置重新调换)，个人理解。\n\n在这里插入图片描述\n\n还有，数组长度保持2的次幂，length-1的低位都为1，会使得获得的数组索引index更加均匀\n\n在这里插入图片描述\n我们看到，上面的&运算，高位是不会对结果产生影响的（hash函数采用各种位运算可能也是为了使得低位更加散列），我们只关注低位bit，如果低位全部为1，那么对于h低位部分来说，任何一位的变化都会对结果产生影响，也就是说，要得到index=21这个存储位置，h的低位只有这一种组合。这也是数组长度设计为必须为2的次幂的原因。\n在这里插入图片描述\n如果不是2的次幂，也就是低位不是全为1此时，要使得index=21，h的低位部分不再具有唯一性了，哈希冲突的几率会变的更大，同时，index对应的这个bit位无论如何不会等于1了，而对应的那些数组位置也就被白白浪费了。\n\nget方法：\n\n public V get(Object key) {\n　　　　 //如果key为null,则直接去table[0]处去检索即可。\n        if (key == null)\n            return getForNullKey();\n        Entry<K,V> entry = getEntry(key);\n        return null == entry ? null : entry.getValue();\n }\n\nget方法通过key值返回对应value，如果key为null，直接去table[0]处检索。我们再看一下getEntry这个方法\n\nfinal Entry<K,V> getEntry(Object key) {\n            \n        if (size == 0) {\n            return null;\n        }\n        //通过key的hashcode值计算hash值\n        int hash = (key == null) ? 0 : hash(key);\n        //indexFor (hash&length-1) 获取最终数组索引，然后遍历链表，通过equals方法比对找出对应记录\n        for (Entry<K,V> e = table[indexFor(hash, table.length)];\n             e != null;\n             e = e.next) {\n            Object k;\n            if (e.hash == hash && \n                ((k = e.key) == key || (key != null && key.equals(k))))\n                return e;\n        }\n        return null;\n    }    \n\n可以看出，get方法的实现相对简单，key(hashcode)–>hash–>indexFor–>最终索引位置，找到对应位置table[i]，再查看是否有链表，遍历链表，通过key的equals方法比对查找对应的记录。要注意的是，有人觉得上面在定位到数组位置之后然后遍历链表的时候，e.hash == hash这个判断没必要，仅通过equals判断就可以。其实不然，试想一下，如果传入的key对象重写了equals方法却没有重写hashCode，而恰巧此对象定位到这个数组位置，如果仅仅用equals判断可能是相等的，但其hashCode和当前对象不一致，这种情况，根据Object的hashCode的约定，不能返回当前对象，而应该返回null，后面的例子会做出进一步解释。\n\n四、重写equals方法需同时重写hashCode方法\n\n最后我们再聊聊老生常谈的一个问题，各种资料上都会提到，“重写equals时也要同时覆盖hashcode”，我们举个小例子来看看，如果重写了equals而不重写hashcode会发生什么样的问题\n\n\npublic class MyTest {\n    private static class Person{\n        int idCard;\n        String name;\n\n        public Person(int idCard, String name) {\n            this.idCard = idCard;\n            this.name = name;\n        }\n        @Override\n        public boolean equals(Object o) {\n            if (this == o) {\n                return true;\n            }\n            if (o == null || getClass() != o.getClass()){\n                return false;\n            }\n            Person person = (Person) o;\n            //两个对象是否等值，通过idCard来确定\n            return this.idCard == person.idCard;\n        }\n\n    }\n    public static void main(String []args){\n        HashMap<Person,String> map = new HashMap<Person, String>();\n        Person person = new Person(1234,\"乔峰\");\n        //put到hashmap中去\n        map.put(person,\"天龙八部\");\n        //get取出，从逻辑上讲应该能输出“天龙八部”\n        System.out.println(\"结果:\"+map.get(new Person(1234,\"萧峰\")));\n    }\n}\n\n实际输出结果：null\n\n如果我们已经对HashMap的原理有了一定了解，这个结果就不难理解了。尽管我们在进行get和put操作的时候，使用的key从逻辑上讲是等值的（通过equals比较是相等的），但由于没有重写hashCode方法，所以put操作时，key(hashcode1)–>hash–>indexFor–>最终索引位置 ，而通过key取出value的时候 key(hashcode1)–>hash–>indexFor–>最终索引位置，由于hashcode1不等于hashcode2，导致没有定位到一个数组位置而返回逻辑上错误的值null（也有可能碰巧定位到一个数组位置，但是也会判断其entry的hash值是否相等，上面get方法中有提到。）\n\n所以，在重写equals的方法的时候，必须注意重写hashCode方法，同时还要保证通过equals判断相等的两个对象，调用hashCode方法要返回同样的整数值。而如果equals判断不相等的两个对象，其hashCode可以相同（只不过会发生哈希冲突，应尽量避免）。\n\n五、JDK1.8中HashMap的性能优化\n\n假如一个数组槽位上链上数据过多（即拉链过长的情况）导致性能下降该怎么办？\nJDK1.8在JDK1.7的基础上针对增加了红黑树来进行优化。即当链表超过8时，链表就转换为红黑树，利用红黑树快速增删改查的特点提高HashMap的性能，其中会用到红黑树的插入、删除、查找等算法。\n关于这方面的探讨我们以后的文章再做说明。\n附：HashMap put方法逻辑图（JDK1.8）\n在这里插入图片描述',
        25, 'java', 'HashMap', 1, 4, 0, 0, '2020-03-09 18:16:01', '2020-03-09 18:16:01');
INSERT INTO `tb_blog`
VALUES (28, 'Java中HashMap的实现原理', '', 'https://localhost/admin/dist/img/rand/25.jpg',
        '最近面试中被问及Java中HashMap的原理，瞬间无言以对，因此痛定思痛觉得研究一番。\n\n一、Java中的hashCode和equals\n1、关于hashCode\nhashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来在散列存储结构中确定对象的存储地址的\n如果两个对象相同，就是适用于equals(java.lang.Object) 方法，那么这两个对象的hashCode一定要相同\n如果对象的equals方法被重写，那么对象的hashCode也尽量重写，并且产生hashCode使用的对象，一定要和equals方法中使用的一致，否则就会违反上面提到的第2点\n两个对象的hashCode相同，并不一定表示两个对象就相同，也就是不一定适用于equals(java.lang.Object) 方法，只能够说明这两个对象在散列存储结构中，如Hashtable，他们“存放在同一个篮子里“\n再归纳一下就是hashCode是用于查找使用的，而equals是用于比较两个对象的是否相等的。\n\n以下对hashCode的解读摘自其他博客：\n\n1.hashcode是用来查找的，如果你学过数据结构就应该知道，在查找和排序这一章有\n例如内存中有这样的位置\n0  1  2  3  4  5  6  7\n而我有个类，这个类有个字段叫ID,我要把这个类存放在以上8个位置之一，如果不用hashcode而任意存放，那么当查找时就需要到这八个位置里挨个去找，或者用二分法一类的算法。\n但如果用hashcode那就会使效率提高很多。\n我们这个类中有个字段叫ID,那么我们就定义我们的hashcode为ID％8，然后把我们的类存放在取得得余数那个位置。比如我们的ID为9，9除8的余数为1，那么我们就把该类存在1这个位置，如果ID是13，求得的余数是5，那么我们就把该类放在5这个位置。这样，以后在查找该类时就可以通过ID除 8求余数直接找到存放的位置了。\n2.但是如果两个类有相同的hashcode怎么办那（我们假设上面的类的ID不是唯一的），例如9除以8和17除以8的余数都是1，那么这是不是合法的，回答是：可以这样。那么如何判断呢？在这个时候就需要定义 equals了。\n也就是说，我们先通过 hashcode来判断两个类是否存放某个桶里，但这个桶里可能有很多类，那么我们就需要再通过 equals 来在这个桶里找到我们要的类。\n那么。重写了equals()，为什么还要重写hashCode()呢？\n想想，你要在一个桶里找东西，你必须先要找到这个桶啊，你不通过重写hashcode()来找到桶，光重写equals()有什么用啊\n2、关于equals\n1.equals和==\n==用于比较引用和比较基本数据类型时具有不同的功能：\n比较基本数据类型，如果两个值相同，则结果为true\n而在比较引用时，如果引用指向内存中的同一对象，结果为true;\n\nequals()作为方法，实现对象的比较。由于==运算符不允许我们进行覆盖，也就是说它限制了我们的表达。因此我们复写equals()方法，达到比较对象内容是否相同的目的。而这些通过==运算符是做不到的。\n\n2.object类的equals()方法的比较规则为：如果两个对象的类型一致，并且内容一致，则返回true,这些类有：\njava.io.file,java.util.Date,java.lang.string,包装类（Integer,Double等）\nString s1=new String(\"abc\");\nString s2=new String(\"abc\");\nSystem.out.println(s1==s2);\nSystem.out.println(s1.equals(s2));\n运行结果为false true\n\n二、HashMap的实现原理\n1.    HashMap概述\n    HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。\n\n    在java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。\n\n\n\n从上图中可以看出，HashMap底层就是一个数组结构，数组中的每一项又是一个链表。当新建一个HashMap的时候，就会初始化一个数组。\n\n其中Java源码如下：\n\n复制代码\n/**\n * The table, resized as necessary. Length MUST Always be a power of two.\n */\ntransient Entry[] table;\n\nstatic class Entry<K,V> implements Map.Entry<K,V> {\n    final K key;\n    V value;\n    Entry<K,V> next;\n    final int hash;\n    ……\n}\n复制代码\n可以看出，Entry就是数组中的元素，每个 Map.Entry 其实就是一个key-value对，它持有一个指向下一个元素的引用，这就构成了链表。\n\n2、HashMap实现存储和读取\n1）存储\n\n复制代码\n 1 public V put(K key, V value) {\n 2     // HashMap允许存放null键和null值。\n 3     // 当key为null时，调用putForNullKey方法，将value放置在数组第一个位置。\n 4     if (key == null)\n 5         return putForNullKey(value);\n 6     // 根据key的keyCode重新计算hash值。\n 7     int hash = hash(key.hashCode());\n 8     // 搜索指定hash值在对应table中的索引。\n 9     int i = indexFor(hash, table.length);\n10     // 如果 i 索引处的 Entry 不为 null，通过循环不断遍历 e 元素的下一个元素。\n11     for (Entry<K,V> e = table[i]; e != null; e = e.next) {\n12         Object k;\n13         if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {\n14             // 如果发现已有该键值，则存储新的值，并返回原始值\n15             V oldValue = e.value;\n16             e.value = value;\n17             e.recordAccess(this);\n18             return oldValue;\n19         }\n20     }\n21     // 如果i索引处的Entry为null，表明此处还没有Entry。\n22     modCount++;\n23     // 将key、value添加到i索引处。\n24     addEntry(hash, key, value, i);\n25     return null;\n26 }\n复制代码\n根据hash值得到这个元素在数组中的位置（即下标），如果数组该位置上已经存放有其他元素了，那么在这个位置上的元素将以链表的形式存放，新加入的放在链头，最先加入的放在链尾。如果数组该位置上没有元素，就直接将该元素放到此数组中的该位置上。\n\nhash(int h)方法根据key的hashCode重新计算一次散列。此算法加入了高位计算，防止低位不变，高位变化时，造成的hash冲突。\n\n1 static int hash(int h) {\n2     h ^= (h >>> 20) ^ (h >>> 12);\n3     return h ^ (h >>> 7) ^ (h >>> 4);\n4 }\n我们可以看到在HashMap中要找到某个元素，需要根据key的hash值来求得对应数组中的位置。如何计算这个位置就是hash算法。前面说过HashMap的数据结构是数组和链表的结合，所以我们当然希望这个HashMap里面的元素位置尽量的分布均匀些，尽量使得每个位置上的元素数量只有一个，那么当我们用hash算法求得这个位置的时候，马上就可以知道对应位置的元素就是我们要的，而不用再去遍历链表，这样就大大优化了查询的效率。\n\n根据上面 put 方法的源代码可以看出，当程序试图将一个key-value对放入HashMap中时，程序首先根据该 key的 hashCode() 返回值决定该 Entry 的存储位置：如果两个 Entry 的 key 的 hashCode() 返回值相同，那它们的存储位置相同。如果这两个 Entry 的 key 通过 equals 比较返回 true，新添加 Entry 的 value 将覆盖集合中原有 Entry的 value，但key不会覆盖。如果这两个 Entry 的 key 通过 equals 比较返回 false，新添加的 Entry 将与集合中原有 Entry 形成 Entry 链，而且新添加的 Entry 位于 Entry 链的头部——具体说明继续看 addEntry() 方法的说明。\n\n通过这种方式就可以高效的解决HashMap的冲突问题。\n\n2）读取\n\n复制代码\n 1 public V get(Object key) {\n 2     if (key == null)\n 3         return getForNullKey();\n 4     int hash = hash(key.hashCode());\n 5     for (Entry<K,V> e = table[indexFor(hash, table.length)];\n 6         e != null;\n 7         e = e.next) {\n 8         Object k;\n 9         if (e.hash == hash && ((k = e.key) == key || key.equals(k)))\n10             return e.value;\n11     }\n12     return null;\n13 }\n复制代码\n从HashMap中get元素时，首先计算key的hashCode，找到数组中对应位置的某一元素，然后通过key的equals方法在对应位置的链表中找到需要的元素。\n\n3）归纳起来简单地说，HashMap 在底层将 key-value 当成一个整体进行处理，这个整体就是一个 Entry 对象。HashMap 底层采用一个 Entry[] 数组来保存所有的 key-value 对，当需要存储一个 Entry 对象时，会根据hash算法来决定其在数组中的存储位置，在根据equals方法决定其在该数组位置上的链表中的存储位置；当需要取出一个Entry时，也会根据hash算法找到其在数组中的存储位置，再根据equals方法从该位置上的链表中取出该Entry。\n\n3、HashMap的resize\n       当hashmap中的元素越来越多的时候，碰撞的几率也就越来越高（因为数组的长度是固定的），所以为了提高查询的效率，就要对hashmap的数组进行扩容，数组扩容这个操作也会出现在ArrayList中，所以这是一个通用的操作，很多人对它的性能表示过怀疑，不过想想我们的“均摊”原理，就释然了，而在hashmap数组扩容之后，最消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，并放进去，这就是resize。\n\n       那么hashmap什么时候进行扩容呢？当hashmap中的元素个数超过数组大小*loadFactor时，就会进行数组扩容，loadFactor的默认值为0.75，也就是说，默认情况下，数组大小为16，那么当hashmap中元素个数超过16*0.75=12的时候，就把数组的大小扩展为2*16=32，即扩大一倍，然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，所以如果我们已经预知hashmap中元素的个数，那么预设元素的个数能够有效的提高hashmap的性能。比如说，我们有1000个元素new HashMap(1000), 但是理论上来讲new HashMap(1024)更合适，不过上面annegu已经说过，即使是1000，hashmap也自动会将其设置为1024。 但是new HashMap(1024)还不是更合适的，因为0.75*1000 < 1000, 也就是说为了让0.75 * size > 1000, 我们必须这样new HashMap(2048)才最合适，既考虑了&的问题，也避免了resize的问题。\n\n \n\n总结：HashMap的实现原理：\n\n利用key的hashCode重新hash计算出当前对象的元素在数组中的下标\n存储时，如果出现hash值相同的key，此时有两种情况。(1)如果key相同，则覆盖原始值；(2)如果key不同（出现冲突），则将当前的key-value放入链表中\n获取时，直接找到hash值对应的下标，在进一步判断key是否相同，从而找到对应值。\n理解了以上过程就不难明白HashMap是如何解决hash冲突的问题，核心就是使用了数组的存储方式，然后将冲突的key的对象放入链表中，一旦发现冲突就在链表中做进一步的对比。',
        25, '恶趣味去', 'HashMap', 1, 10, 0, 1, '2020-03-09 18:17:09', '2020-03-09 18:17:09');
INSERT INTO `tb_blog`
VALUES (29, '测试', '', 'https://localhost/admin/dist/img/rand/24.jpg',
        '```java\npackage club.javafan.blog.web.aop;\n\nimport club.javafan.blog.common.util.DateUtils;\nimport club.javafan.blog.common.util.RedisUtil;\nimport com.alibaba.fastjson.JSONObject;\nimport com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;\nimport org.apache.commons.lang3.ObjectUtils;\nimport org.aspectj.lang.JoinPoint;\nimport org.aspectj.lang.ProceedingJoinPoint;\nimport org.aspectj.lang.annotation.*;\nimport org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Component;\n\nimport javax.servlet.http.HttpServletRequest;\nimport javax.servlet.http.HttpServletResponse;\nimport java.util.List;\nimport java.util.Objects;\nimport java.util.stream.Collectors;\nimport java.util.stream.Stream;\n\nimport static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;\nimport static club.javafan.blog.common.constant.RedisKeyConstant.EXCEPTION_AMOUNT;\nimport static java.util.Objects.isNull;\n\n/**\n * @author 敲代码的长腿毛欧巴(博客)\n * @date 2019/12/10 22:57\n * @desc 日志处理和异常处理切面。主要作用打印入参和返回结果。\n * 也可以捕获异常。有条件的话可以吧捕获的异常做异常上报\n */\n@Aspect\n@Component\npublic class LoggerExceptionAop {\n    /**\n     * redis 工具类\n     */\n    @Autowired\n    private RedisUtil redisUtil;\n    /**\n     * 日志\n     */\n    private final Logger logger = LoggerFactory.getLogger(this.getClass());\n\n    @Pointcut(value = \"execution(public * club.javafan.blog.service.impl.*.*(..))\")\n    private void servicePointCut() {\n    }\n\n    @Pointcut(value = \"execution(public * club.javafan.blog.common.mail.impl.*.*(..))\")\n    private void commonPointCut() {\n    }\n\n    @Pointcut(value = \"execution(public * club.javafan.blog.worker..*.*(..))\")\n    private void workerPointCut() {\n    }\n\n    @Pointcut(value = \"execution(public * club.javafan.blog.web.controller..*.*(..))\")\n    private void controllerPoint() {\n    }\n\n    @Before(value = \"controllerPoint()||servicePointCut()||commonPointCut()||workerPointCut()\")\n    public void before(JoinPoint joinPoint) {\n        String className = joinPoint.getTarget().getClass().getName();\n        String methodName = joinPoint.getSignature().getName();\n        StringBuilder log = new StringBuilder();\n        log.append(className).append(\"@\")\n                .append(methodName)\n                .append(\" , params: \");\n        Object[] args = joinPoint.getArgs();\n        //过滤掉request请求和response 避免异步请求出错\n        List<Object> logArgs = Stream.of(args)\n                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))\n                .parallel()\n                .collect(Collectors.toList());\n        log.append(JSONObject.toJSONString(logArgs)).toString();\n        logger.info(log.toString());\n    }\n\n    @AfterReturning(value = \"controllerPoint()||servicePointCut()||workerPointCut()\", returning = \"returnObj\")\n    public void afterReturn(Object returnObj) {\n        if (isNull(returnObj)){\n            return;\n        }\n        logger.info(\"club.javafan.blog return result: {}\", JSONObject.toJSONString(returnObj));\n    }\n\n    @AfterThrowing(value = \"controllerPoint()||servicePointCut()||commonPointCut()||workerPointCut()\", throwing = \"e\")\n    public void afterThrowing(Throwable e) {\n        //统计今日异常数\n        redisUtil.incr(EXCEPTION_AMOUNT + DateUtils.getToday());\n        logger.error(\"club.javafan.blog error : {}\", e);\n    }\n\n    @Around(value = \"controllerPoint()||servicePointCut()||commonPointCut()||workerPointCut()\")\n    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {\n        //统计今日执行的总次数\n        redisUtil.incr(CS_PAGE_VIEW + DateUtils.getToday());\n        String className = proceedingJoinPoint.getTarget().getClass().getName();\n        String methodName = proceedingJoinPoint.getSignature().getName();\n        Long begin = System.currentTimeMillis();\n        StringBuilder log = new StringBuilder(className + \".\" + methodName + \" :\");\n        Object result;\n        try {\n            result = proceedingJoinPoint.proceed();\n        } catch (Throwable e) {\n            throw e;\n        }\n        Long end = System.currentTimeMillis();\n        log.append(\"执行时间: \")\n                .append(end - begin)\n                .append(\" ms\");\n        logger.info(log.toString());\n        return result;\n    }\n\n\n}\n```',
        25, 'java', '测试', 1, 2, 0, 0, '2020-03-16 11:13:56', '2020-03-16 11:13:56');
INSERT INTO `tb_blog`
VALUES (30, '大大的', '', 'https://localhost/upload/img/20200326_13565992.jpg',
        '大大大大\n```java\npackage club.javafan.blog.common.sennsor;\n\nimport com.baidu.aip.contentcensor.AipContentCensor;\nimport org.json.JSONObject;\nimport org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\nimport org.springframework.stereotype.Component;\n\nimport java.util.Objects;\n\nimport static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;\nimport static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;\n\n/**\n * 文本审核单例\n *\n * @author 敲代码的长腿毛欧巴\n * @createDate 2020/2/2\n */\n@Component\npublic class AipContentCensorBuilder {\n    private static final Logger logger = LoggerFactory.getLogger(AipContentCensorBuilder.class);\n\n\n    private static AipContentCensor client = new AipContentCensor(\"18131202\", \"T1TAQcoANVtGgibseCATCblY\"\n            , \"HmgAhWXV3Ao1GRHtBsqKI4PAswlQzMim\");\n\n    public static AipContentCensor getInstance() {\n        return client;\n    }\n\n    private AipContentCensorBuilder() {\n\n    }\n\n    /**\n     *  敏感词结果\n     */\n    public static class SensorResult{\n        private String desc;\n        private Integer code;\n\n        public String getDesc() {\n            return desc;\n        }\n\n        public SensorResult setDesc(String desc) {\n            this.desc = desc;\n            return this;\n        }\n\n        public Integer getCode() {\n            return code;\n        }\n\n        public SensorResult setCode(Integer code) {\n            this.code = code;\n            return this;\n        }\n\n        public SensorResult failResult(String desc){\n            SensorResult sensorResult = new SensorResult();\n            sensorResult.setCode(INTEGER_ONE);\n            sensorResult.setDesc(desc);\n            return sensorResult;\n        }\n\n        public SensorResult successResult(String desc) {\n            SensorResult sensorResult = new SensorResult();\n            sensorResult.setCode(INTEGER_ZERO);\n            sensorResult.setDesc(desc);\n            return sensorResult;\n        }\n    }\n\n    /**\n     * 文本敏感词校验\n     * @param text\n     * @return\n     */\n    public static SensorResult judgeText(String text){\n        JSONObject jsonObject = client.antiSpam(text, null);\n        logger.info(\"AipContentCensorBuilder text: {},info: {}\",text,jsonObject);\n        //0表示非违禁，1表示违禁，2表示建议人工复审\n        JSONObject result = jsonObject.getJSONObject(\"result\");\n        if (Objects.isNull(jsonObject) || Objects.isNull(result) || result.getInt(\"spam\") == INTEGER_ZERO){\n            return new SensorResult().successResult(\"需要人工审核\");\n        }\n        return new SensorResult().failResult(\"失败！\");\n\n    }\n}\n\n```\n大师水水          大苏打dasdasd啊\ndadadada的\na adafa\n发送       ',
        25, 'java', '大大a', 1, 0, 0, 0, '2020-03-25 17:48:01', '2020-03-25 17:48:01');
INSERT INTO `tb_blog`
VALUES (31, 'dadad', '', 'https://localhost/admin/dist/img/rand/12.jpg', 'dadasda', 25, 'java', 'dada', 1, 0, 0, 0,
        '2020-03-26 17:16:34', '2020-03-26 17:16:34');
INSERT INTO `tb_blog`
VALUES (32, 'dada', '', 'https://localhost/admin/dist/img/rand/13.jpg', 'dadad', 25, 'java', 'dada', 1, 0, 0, 0,
        '2020-03-26 17:16:50', '2020-03-26 17:16:50');
INSERT INTO `tb_blog`
VALUES (33, 'dadad', '', 'https://localhost/admin/dist/img/rand/23.jpg', 'dadadad', 25, 'java', 'dad,a', 1, 0, 0, 0,
        '2020-03-26 17:17:05', '2020-03-26 17:17:05');
INSERT INTO `tb_blog`
VALUES (34, 'dadad', '', 'https://localhost/admin/dist/img/rand/26.jpg', 'dadad', 25, 'java', 'dada', 1, 0, 0, 0,
        '2020-03-26 17:17:19', '2020-03-26 17:17:19');
INSERT INTO `tb_blog`
VALUES (35, 'dadad', '', 'https://localhost/admin/dist/img/rand/2.jpg', 'adada', 25, 'java', 'adad', 1, 0, 0, 0,
        '2020-03-26 17:17:37', '2020-03-26 17:17:37');
INSERT INTO `tb_blog`
VALUES (36, 'dadad', '', 'https://localhost/admin/dist/img/rand/2.jpg', 'adda', 25, 'java', 'add', 1, 0, 0, 0,
        '2020-03-26 17:17:46', '2020-03-26 17:17:46');
INSERT INTO `tb_blog`
VALUES (37, '个人简历', '', 'https://localhost/admin/dist/img/rand/13.jpg',
        '# Java程序员简历模板\n\n本简历模板由国内首家互联网人才拍卖网站「 [JobDeer.com](http://www.jobdeer.com) 」提供。\n\n（括号里的是我们的顾问编写的说明，建议在简历书写完成后统一删除）\n\n## 先讲讲怎样才是一份好的技术简历\n\n首先，一份好的简历不光说明事实，更通过FAB模式来增强其说服力。\n\n - Feature：是什么\n - Advantage：比别人好在哪些地方\n - Benefit：如果雇佣你，招聘方会得到什么好处 \n\n其次，写简历和写议论文不同，过分的论证会显得自夸，反而容易引起反感，所以要点到为止。这里的技巧是，提供论据，把论点留给阅读简历的人自己去得出。放论据要具体，最基本的是要数字化，好的论据要让人印象深刻。\n\n举个例子，下边内容是虚构的：\n\n2006年，我参与了手机XX网发布系统WAPCMS的开发（```这部分是大家都会写的```）。作为核心程序员，我不但完成了网站界面、调度队列的开发工作，更提出了高效的组件级缓存系统，通过碎片化缓冲有效的提升了系统的渲染效率。（```这部分是很多同学忘掉的，要写出你在这个项目中具体负责的部分，以及你贡献出来的价值。```）在该系统上线后，Web前端性能从10QPS提升到200QPS，服务器由10台减少到3台（``` 通过量化的数字来增强可信度 ```）。2008年我升任WAPCMS项目负责人，带领一个3人小组支持着每天超过2亿的PV（``` 这就是Benefit。你能带给前雇主的价值，也就是你能带给新雇主的价值。 ```）。\n\n有同学问，如果我在项目里边没有那么显赫的成绩可以说怎么办？讲不出成绩时，就讲你的成长。因为学习能力也是每家公司都看中的东西。你可以写你在这个项目里边遇到了一个什么样的问题，别人怎么解决的，你怎么解决的，你的方案好在什么地方，最终这个方案的效果如何。\n\n具体、量化、有说服力，是技术简历特别需要注重的地方。\n\n（以上内容在写完简历后，对每一段进行评估，完成后再删除）\n\n---\n\n\n# 联系方式\n（HR会打印你的简历，用于在面试的时候联系，所以联系方式放到最上边会比较方便）\n\n- 手机：135******** （```如果是外地手机，可注明。如经常关机，要写上最优联系时间```）\n- Email：goodman@gmail.com （```虽然我觉得QQ邮箱无所谓，不过有些技术人员比较反感，建议用G```）\n- QQ/微信号：6*******（```提供一个通过网络可以联系到你的方式```）\n\n---\n\n# 个人信息\n\n - 胶布帝/男/1990 \n - 本科/萌鹿大学计算机系 \n - 工作年限：3年\n - 微博：[@JobDeer](http://weibo.com/jobdeer) （``` 如果没有技术相关内容，也可以不放 ```）\n - 技术博客：http://blog.github.io ( ``` 使用GitHub Host的Big较高 ```  )\n - Github：http://github.com/geekcompany ( ``` 有原创repo的Github帐号会极大的提升你的个人品牌 ```  )\n\n - 期望职位：Java高级程序员，架构师\n - 期望薪资：税前月薪15k~20k，特别喜欢的公司可例外\n - 期望城市：北京\n\n---\n\n# 工作经历\n（工作经历按逆序排列，最新的在最前边，按公司做一级分组，公司内按二级分组）\n\n## ABC公司 （ 2012年9月 ~ 2014年9月 ）\n\n### DEF项目 \n我在此项目负责了哪些工作，分别在哪些地方做得出色/和别人不一样/成长快，这个项目中，我最困难的问题是什么，我采取了什么措施，最后结果如何。这个项目中，我最自豪的技术细节是什么，为什么，实施前和实施后的数据对比如何，同事和领导对此的反应如何。\n\n\n### GHI项目 \n我在此项目负责了哪些工作，分别在哪些地方做得出色/和别人不一样/成长快，这个项目中，我最困难的问题是什么，我采取了什么措施，最后结果如何。这个项目中，我最自豪的技术细节是什么，为什么，实施前和实施后的数据对比如何，同事和领导对此的反应如何。\n\n\n### 其他项目\n\n（每个公司写2~3个核心项目就好了，如果你有非常大量的项目，那么按分类进行合并，每一类选一个典型写出来。其他的一笔带过即可。）\n\n \n## JKL公司 （ 2010年3月 ~ 2012年8月 ）\n\n### MNO项目 \n我在此项目负责了哪些工作，分别在哪些地方做得出色/和别人不一样/成长快，这个项目中，我最困难的问题是什么，我采取了什么措施，最后结果如何。这个项目中，我最自豪的技术细节是什么，为什么，实施前和实施后的数据对比如何，同事和领导对此的反应如何。\n\n\n### PQR项目 \n我在此项目负责了哪些工作，分别在哪些地方做得出色/和别人不一样/成长快，这个项目中，我最困难的问题是什么，我采取了什么措施，最后结果如何。这个项目中，我最自豪的技术细节是什么，为什么，实施前和实施后的数据对比如何，同事和领导对此的反应如何。\n\n\n### 其他项目\n\n（每个公司写2~3个核心项目就好了，如果你有非常大量的项目，那么按分类进行合并，每一类选一个典型写出来。其他的一笔带过即可。）\n\n---\n\n# 开源项目和作品\n（这一段用于放置工作以外的、可证明你的能力的材料）\n\n## 开源项目\n（对于程序员来讲，没有什么比Show me the code能有说服力了）\n\n - [STU](http://github.com/yourname/projectname)：项目的简要说明，Star和Fork数多的可以注明\n - [WXYZ](http://github.com/yourname/projectname)：项目的简要说明，Star和Fork数多的可以注明\n\n## 技术文章\n（挑选你写作或翻译的技术文章，好的文章可以从侧面证实你的表达和沟通能力，也帮助招聘方更了解你）\n\n- [一个产品经理眼中的云计算：前生今世和未来](http://get.jobdeer.com/706.get)\n- [来自HeroKu的HTTP API 设计指南(翻译文章)](http://get.jobdeer.com/343.get) （ ```好的翻译文章可以侧证你对英文技术文档的阅读能力```）\n\n## 演讲和讲义\n（放置你代表公司在一些技术会议上做过的演讲，以及你在公司分享时制作的讲义）\n\n  - 2014架构师大会演讲：[如何通过Docker优化内部开发](http://jobdeer.com)\n - 9月公司内部分享：[云计算的前生今世](http://jobdeer.com)\n\n# 技能清单\n（我一般主张将技能清单写入到工作经历里边去。不过很难完整，所以有这么一段也不错）\n\n以下均为我熟练使用的技能\n\n- Web开发：PHP/Hack/Node\n- Web框架：ThinkPHP/Yaf/Yii/Lavaral/LazyPHP\n- 前端框架：Bootstrap/AngularJS/EmberJS/HTML5/Cocos2dJS/ionic\n- 前端工具：Bower/Gulp/SaSS/LeSS/PhoneGap\n- 数据库相关：MySQL/PgSQL/PDO/SQLite\n- 版本管理、文档和自动化部署工具：Svn/Git/PHPDoc/Phing/Composer\n- 单元测试：PHPUnit/SimpleTest/Qunit\n- 云和开放平台：SAE/BAE/AWS/微博开放平台/微信应用开发\n\n## 参考技能关键字\n\n本技能关键字列表是从最近招聘Java的数百份JD中统计出来的，括号中是出现的词频。如果你的简历要投递给有机器（简历分选系统）和不如机器（不懂技术的HR）筛选简历环节的地方，请一定从下边高频关键词中选择5～10个适合你自己的。\n\n- java(730)\n- spring(305)\n- web(260)\n- mysql(250)\n- oracle(207)\n- linux(198)\n- j2ee(182)\n- javascript(177)\n- sql(176)\n- hibernate(169)\n- html(139)\n- tomcat(132)\n- struts(128)\n- jquery(116)\n- jsp(106)\n- ajax(96)\n- css(94)\n- ibatis(84)\n- mvc(77)\n- servlet(71)\n- xml(70)\n- js(62)\n- eclipse(51)\n- mybatis(51)\n- jboss(47)\n- struts2(47)\n- weblogic(46)\n- redis(46)\n- apache(45)\n- http(44)\n- shell(39)\n- python(38)\n- hadoop(37)\n- nosql(35)\n- ssh(35)\n- sqlserver(33)\n- mongodb(33)\n- svn(32)\n- uml(32)\n- json(27)\n- unix(27)\n- maven(27)\n- nginx(26)\n- webservice(25)\n- jdbc(24)\n- memcached(23)\n- tcp(22)\n- resin(22)\n- jvm(21)\n- socket(21)\n- db2(19)\n- springmvc(19)\n- websphere(16)\n- soa(16)\n- mina(14)\n- android(14)\n- extjs(13)\n- erp(12)\n- memcache(12)\n- api(11)\n- jetty(11)\n- myeclipse(11)\n- ext(10)\n- git(10)\n- jpa(10)\n- svm(9)\n- php(9)\n- jms(9)\n- ruby(9)\n- lucene(8)\n- html5(8)\n- postgresql(8)\n- crm(7)\n- javaee(7)\n- sybase(7)\n- freemarker(6)\n- cache(6)\n- jsf(6)\n- j2se(6)\n- jbpm(6)\n- cvs(6)\n- junit(6)\n- visio(6)\n- netty(6)\n- hbase(6)\n- nio(6)\n- powerdesigner(6)\n- oo(6)\n- aop(6)\n- workflow(5)\n- restful(5)\n- ios(5)\n- ant(5)\n- mssql(5)\n- orm(5)\n- rose(5)\n- solr(5)\n- webwork(5)\n- zookeeper(4)\n- soap(4)\n- o2o(4)\n- wap(4)\n- cxf(4)\n- thrift(4)\n- xmpp(3)\n- p2p(3)\n- javabean(3)\n- jee(3)\n- hdfs(3)\n- dom(3)\n- hibernate3(3)\n\n\n\n\n---\n\n# 致谢\n感谢您花时间阅读我的简历，期待能有机会和您共事。\n',
        25, 'java', '简历', 1, 0, 0, 0, '2020-03-26 20:27:16', '2020-03-26 20:27:16');
INSERT INTO `tb_blog`
VALUES (38, '博客介绍Mark Down', '', 'https://localhost/admin/dist/img/rand/32.jpg',
        '<h1 align=\"center\"><a href=\"https://github.com/renjiahua945/blog\" target=\"_blank\">Lumos</a></h1>\n\n> Lumos是基于Spring Boot的轻量级博客，是学习搭建使用Spring Boot的不错选择。\n\n<p align=\"center\">\n<a href=\"https://github.com/renjiahua945/blog/releases\"><img alt=\"GitHub release\" src=\"https://img.shields.io/github/release/renjiahua945/Lumos\"/></a>\n<a href=\"https://github.com/renjiahua945/Lumos/releases\"><img alt=\"GitHub All Releases\" src=\"https://img.shields.io/github/downloads/renjiahua945/Lumos/total\"/></a>\n<a href=\"https://github.com/renjiahua945/Lumos/commits\"><img alt=\"GitHub last commit\" src=\"https://img.shields.io/github/last-commit/renjiahua945/Lumos\"/></a>\n<a href=\"https://github.com/renjiahua945/Lumos/packages\"><img alt=\"Travis CI\" src=\"https://img.shields.io/github/repo-size/renjiahua945/Lumos\"/></a>\n\n</p>\n\n------------------------------\n\n## 简介\n\n**Lumos** `[ˈlumos]`，音译为撸莫斯，意为荧光闪烁。撸当然是撸代码了，莫斯是流浪地球的人工智能，所以Lumos解释为撸出一个像莫斯一样的人工智能。除此之外，Lumos是哈利波特中的一句咒语，可以将魔法杖点着火用来照明。这是一个轻量级博客，值得尝试一下。\n\n\n## 声明\n\n> 本项目为使用Apache 2.0证书的开源博客项目，大家可以下载代码学习和使用，但是需要尽量遵守开源协议。博客现在还处于快速迭代更新的进程中，难免有些问题，如果发现问题，最好在GitHub上提交issues。\n\n\n> 目前我们的release分支即 master，肯定会有很多小问题，不要运行不起来就跑过来吐槽什么代码开源不完整之类的，多找找自己的原因。同时建议下载最新 release 版本的代码。\n\n## 快速开始\n\n### 拉取最新的Lumos代码\n\n```bash\ngit clone https://github.com/renjiahua945/Lumos.git\n```\n\n或者\n\n\n直接在项目上点击download zip\n\n\n### 启动 Lumos\n\n#####1. 执行项目中SQL文件，创建表。\n\n#####2. 修改Application.yml中的MySQL数据库信息、Redis数据库信息、Java Mail数据库配置信息。具体如何修改，可以在yml文件的注释中查看。\n#####3. 项目中设计了敏感词校验，使用的百度云的文本校验接口，如果您想使用该项功能，需要去百度云创建应用，申请到AppId，Secret Key和ApiToken。代码在AipContentCensorBuilder.java文件中。\n```new AipContentCensor(\"434343\", \"RQERNWNRN\"\n            , \"FSFSMFSMFMSFMM\");```\n#####4. 如果以上步骤都完成了，可以构建下项目，看下有没有报错。\n#####5. 后台密码没有提供注册界面，需要自己使用项目中的MD5方法，自行生成密码存在数据库。生成方法在：MD5Util.java中\n```public static String md5Encode(String origin, String charsetname)```\n\n## 博客示例\n\n请移步： 目前博客还在迭代中，暂未上线。\n\n\n## 许可证\n\n[![license](https://img.shields.io/badge/license-Apache%202.0-green)](https://github.com/renjiahua945/Lumos/blob/master/LICENSE)\n\n> Lumos 使用 Apache-v2.0 协议开源，请尽量遵守开源协议。\n\n## 捐赠\n\n> 如果 Lumos对你有帮助，可以请我喝杯咖啡。你的支持就是我最大的动力\n>  \n<img src=\"https://i.imgur.com/1HdZ3sw.jpg\" width = \"200\" height = \"300\" alt=\"微信收款码\" align=center />\n\n## 预览图\n![](https://i.imgur.com/SRKMPUw.png)\n![](https://i.imgur.com/VlBA9Vo.png)\n![](https://i.imgur.com/lvGV7Nj.png)\n![](https://i.imgur.com/4XNhlsN.png)\n![](https://i.imgur.com/aOxjym5.png)\n![](https://i.imgur.com/iEfoDzk.png)\n![](https://i.imgur.com/HvoFIx5.png)\n![](https://i.imgur.com/FQrelUW.png)\n![](https://i.imgur.com/voFA2EL.png)',
        25, 'java', '介绍,Mark Down,Spring Boot', 1, 0, 0, 1, '2020-03-26 21:30:37', '2020-03-26 21:30:37');
INSERT INTO `tb_blog`
VALUES (39, 'adadad', '', 'https://localhost/admin/dist/img/rand/31.jpg', 'dad', 25, NULL, 'dada', 1, 0, 0, 0,
        '2020-04-01 19:03:34', '2020-04-01 19:03:34');

-- ----------------------------
-- Table structure for tb_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_category`;
CREATE TABLE `tb_blog_category`
(
    `category_id`   int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
    `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类的名称',
    `category_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类的图标',
    `category_rank` int(11)                                                NULL DEFAULT 1 COMMENT '分类的排序值 被使用的越多数值越大',
    `is_deleted`    tinyint(4)                                             NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time`   datetime(0)                                            NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 29
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_category
-- ----------------------------
INSERT INTO `tb_blog_category`
VALUES (25, 'java', '/admin/dist/img/category/02.png', 28, 0, '2020-01-21 11:06:58');
INSERT INTO `tb_blog_category`
VALUES (26, '博客介绍', '/admin/dist/img/category/06.png', 1, 1, '2020-03-27 21:06:06');
INSERT INTO `tb_blog_category`
VALUES (27, '安卓', '/admin/dist/img/category/03.png', 1, 0, '2020-03-27 21:07:50');
INSERT INTO `tb_blog_category`
VALUES (28, '数据库', '/admin/dist/img/category/04.png', 1, 1, '2020-03-27 21:08:01');

-- ----------------------------
-- Table structure for tb_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_comment`;
CREATE TABLE `tb_blog_comment`
(
    `comment_id`          bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `blog_id`             bigint(20)                                              NULL DEFAULT 0 COMMENT '关联的blog主键',
    `commentator`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT '' COMMENT '评论者名称',
    `email`               varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论人的邮箱',
    `q_number`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人qq号',
    `nick_name`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人昵称',
    `head_img`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人头像',
    `website_url`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT '' COMMENT '网址',
    `comment_body`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '评论内容',
    `comment_create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
    `commentator_ip`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT '' COMMENT '评论时的ip地址',
    `reply_body`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '回复内容',
    `reply_create_time`   datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
    `comment_status`      tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否审核通过 0-未审核 1-审核通过',
    `is_deleted`          tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
    PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 32
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_comment
-- ----------------------------
INSERT INTO `tb_blog_comment`
VALUES (27, 22, '不会敲代码的小白', '1406628376@qq.com', NULL, NULL, NULL, '', 'dadad', '2020-02-01 15:45:40', '', '不错呦',
        '2020-02-05 10:46:19', 1, 1);
INSERT INTO `tb_blog_comment`
VALUES (28, 22, '', '1406628376@qq.com', '1406628376', '敲代码的长腿毛欧巴',
        'http://qlogo1.store.qq.com/qzone/1406628376/1406628376/100', '', 'eqeqeq', '2020-03-06 07:02:53', '', '',
        '2020-03-06 15:02:53', 1, 1);
INSERT INTO `tb_blog_comment`
VALUES (29, 25, '', '1406628376@qq.com', '1406628376', '敲代码的长腿毛欧巴',
        'http://qlogo1.store.qq.com/qzone/1406628376/1406628376/100', '', 'daaaaaaaaaaaaaaa', '2020-03-09 09:03:15', '',
        '很高兴收到你的留言', '2020-03-09 09:03:51', 1, 1);
INSERT INTO `tb_blog_comment`
VALUES (30, 26, '', '1406628376@qq.com', '1406628376', '敲代码的长腿毛欧巴',
        'http://qlogo1.store.qq.com/qzone/1406628376/1406628376/100', '', 'dadada', '2020-03-09 09:29:38', '',
        'da dafaf', '2020-03-10 06:45:55', 1, 0);
INSERT INTO `tb_blog_comment`
VALUES (31, 29, '', '1406628376@qq.com', '1406628376', '敲代码的长腿毛欧巴',
        'http://qlogo1.store.qq.com/qzone/1406628376/1406628376/100', '', '阿发发发啊 ', '2020-03-25 09:44:24', '', '不错呀',
        '2020-03-25 09:45:12', 1, 0);

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag`
(
    `tag_id`      int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
    `tag_name`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
    `is_deleted`  tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除 0=否 1=是',
    `create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 158
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_tag
-- ----------------------------
INSERT INTO `tb_blog_tag`
VALUES (142, 'dasdsada', 0, '2020-01-21 11:07:58');
INSERT INTO `tb_blog_tag`
VALUES (143, 'dada', 0, '2020-02-01 13:15:31');
INSERT INTO `tb_blog_tag`
VALUES (144, 'HashMap', 0, '2020-02-01 13:17:56');
INSERT INTO `tb_blog_tag`
VALUES (145, 'ha', 1, '2020-02-05 18:58:07');
INSERT INTO `tb_blog_tag`
VALUES (146, '大大a', 0, '2020-03-09 16:14:06');
INSERT INTO `tb_blog_tag`
VALUES (147, 'a大啊的啊', 0, '2020-03-09 16:14:06');
INSERT INTO `tb_blog_tag`
VALUES (148, 'a fa', 0, '2020-03-09 17:29:14');
INSERT INTO `tb_blog_tag`
VALUES (149, '测试', 0, '2020-03-16 11:13:56');
INSERT INTO `tb_blog_tag`
VALUES (150, 'dad', 0, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag`
VALUES (151, 'a', 0, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag`
VALUES (152, 'adad', 0, '2020-03-26 17:17:37');
INSERT INTO `tb_blog_tag`
VALUES (153, 'add', 0, '2020-03-26 17:17:46');
INSERT INTO `tb_blog_tag`
VALUES (154, '简历', 0, '2020-03-26 20:27:16');
INSERT INTO `tb_blog_tag`
VALUES (155, '介绍', 0, '2020-03-26 21:30:37');
INSERT INTO `tb_blog_tag`
VALUES (156, 'Mark Down', 1, '2020-03-26 21:30:37');
INSERT INTO `tb_blog_tag`
VALUES (157, 'Spring Boot', 0, '2020-03-26 21:30:37');

-- ----------------------------
-- Table structure for tb_blog_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag_relation`;
CREATE TABLE `tb_blog_tag_relation`
(
    `relation_id` bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '关系表id',
    `blog_id`     bigint(20)  NOT NULL COMMENT '博客id',
    `tag_id`      int(11)     NOT NULL COMMENT '标签id',
    `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 348
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_tag_relation
-- ----------------------------
INSERT INTO `tb_blog_tag_relation`
VALUES (306, 26, 148, '2020-03-09 17:29:14');
INSERT INTO `tb_blog_tag_relation`
VALUES (307, 26, 148, '2020-03-09 17:29:14');
INSERT INTO `tb_blog_tag_relation`
VALUES (308, 27, 144, '2020-03-09 18:16:01');
INSERT INTO `tb_blog_tag_relation`
VALUES (309, 28, 144, '2020-03-09 18:17:09');
INSERT INTO `tb_blog_tag_relation`
VALUES (313, 29, 149, '2020-03-16 11:59:16');
INSERT INTO `tb_blog_tag_relation`
VALUES (317, 30, 146, '2020-03-26 13:57:02');
INSERT INTO `tb_blog_tag_relation`
VALUES (318, 31, 143, '2020-03-26 17:16:34');
INSERT INTO `tb_blog_tag_relation`
VALUES (319, 32, 143, '2020-03-26 17:16:50');
INSERT INTO `tb_blog_tag_relation`
VALUES (320, 33, 150, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag_relation`
VALUES (321, 33, 151, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag_relation`
VALUES (322, 33, 150, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag_relation`
VALUES (323, 33, 151, '2020-03-26 17:17:05');
INSERT INTO `tb_blog_tag_relation`
VALUES (324, 34, 143, '2020-03-26 17:17:19');
INSERT INTO `tb_blog_tag_relation`
VALUES (325, 35, 152, '2020-03-26 17:17:37');
INSERT INTO `tb_blog_tag_relation`
VALUES (326, 35, 152, '2020-03-26 17:17:37');
INSERT INTO `tb_blog_tag_relation`
VALUES (327, 36, 153, '2020-03-26 17:17:46');
INSERT INTO `tb_blog_tag_relation`
VALUES (328, 36, 153, '2020-03-26 17:17:46');
INSERT INTO `tb_blog_tag_relation`
VALUES (340, 37, 154, '2020-03-27 19:20:15');
INSERT INTO `tb_blog_tag_relation`
VALUES (347, 39, 143, '2020-04-01 19:03:34');

-- ----------------------------
-- Table structure for tb_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_config`;
CREATE TABLE `tb_config`
(
    `config_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '配置项的名称',
    `config_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT '' COMMENT '配置项的值',
    `create_time`  datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime(0)                                             NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`config_name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_config
-- ----------------------------
INSERT INTO `tb_config`
VALUES ('footerAbout', '2020 Javafan', '2018-11-11 20:33:23', '2020-03-27 01:07:27');
INSERT INTO `tb_config`
VALUES ('footerCopyRight', 'Copyright © 2020 Javafan.club', '2018-11-11 20:33:31', '2020-03-27 01:07:27');
INSERT INTO `tb_config`
VALUES ('footerICP', '冀 xxxxxx', '2018-11-11 20:33:27', '2020-03-27 01:07:27');
INSERT INTO `tb_config`
VALUES ('footerPoweredBy', 'https://github.com/renjiahua945/blog', '2018-11-11 20:33:36', '2020-03-27 01:07:27');
INSERT INTO `tb_config`
VALUES ('footerPoweredByURL', 'https://github.com/renjiahua945/blog', '2018-11-11 20:33:39', '2020-03-27 01:07:27');
INSERT INTO `tb_config`
VALUES ('websiteDescription', '敲代码的长腿欧巴的博客是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码',
        '2018-11-11 20:33:04', '2020-03-27 11:55:28');
INSERT INTO `tb_config`
VALUES ('websiteIcon', '/blog/amaze/images/favicon.ico', '2018-11-11 20:33:11', '2020-03-27 11:55:28');
INSERT INTO `tb_config`
VALUES ('websiteLogo', '/blog/amaze/images/website.png', '2018-11-11 20:33:08', '2020-03-27 11:55:28');
INSERT INTO `tb_config`
VALUES ('websiteName', '敲代码的长腿欧巴的博客', '2018-11-11 20:33:01', '2020-03-27 11:55:28');
INSERT INTO `tb_config`
VALUES ('yourAvatar', '/admin/dist/img/headimg.jpg', '2018-11-11 20:33:14', '2020-03-27 11:32:25');
INSERT INTO `tb_config`
VALUES ('yourEmail', 'renjiahua945@vip.qq.com', '2018-11-11 20:33:17', '2020-03-27 11:32:25');
INSERT INTO `tb_config`
VALUES ('yourName', '敲代码的长腿欧巴', '2018-11-11 20:33:20', '2020-03-27 11:32:25');

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link`
(
    `link_id`          int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '友链表主键id',
    `link_type`        tinyint(4)                                              NULL DEFAULT 0 COMMENT '友链类别 0-友链 1-推荐 2-个人网站',
    `link_name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '网站名称',
    `link_url`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站链接',
    `link_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站描述',
    `link_logo`        varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站logo',
    `link_rank`        int(11)                                                 NULL DEFAULT 0 COMMENT '用于列表排序',
    `is_deleted`       tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除',
    `create_time`      datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 24
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_link
-- ----------------------------
INSERT INTO `tb_link`
VALUES (20, 0, '我的博客', 'https://javafan.club', '我的个人博客',
        'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=69433670,3397024061&fm=15&gp=0.jpg', 0, 0,
        '2020-03-26 15:06:09');
INSERT INTO `tb_link`
VALUES (21, 0, '腾讯', 'https://www.baidu.com/', '大大',
        'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3557113452,423804103&fm=15&gp=0.jpg', 0, 0,
        '2020-03-26 15:06:40');
INSERT INTO `tb_link`
VALUES (22, 0, '维普', 'https://weipu.com', 'c查重daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
        'https://www.baidu.com/img/pc_cc75653cd975aea6d4ba1f59b3697455.png', 0, 0, '2020-05-27 22:27:55');
INSERT INTO `tb_link`
VALUES (23, 0, 'baidu', 'https://www.baidu.com', '面向开源及私有软件项目的托管平台',
        'http://img4.imgtn.bdimg.com/it/u=1490414401,2620769295&fm=26&gp=0.jpg', 0, 1, '2020-06-03 18:57:43');

SET FOREIGN_KEY_CHECKS = 1;

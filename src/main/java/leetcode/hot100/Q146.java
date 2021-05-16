package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author drone
 * @date 2021/5/16
 */
class Q146 {
    //LRU 缓存机制可以通过哈希表辅以双向链表实现
    //双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，靠近尾部的键值对是最久未使用的
    //哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //缓存实际长度
    private int size;
    //缓存容量长度
    private int capacity;
    //头节点
    private DLinkedNode head;
    //尾节点
    private DLinkedNode tail;

    public Q146(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }

        //该节点被访问，移动该节点到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (null == node) {
            //创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到Hash表
            cache.put(key, newNode);
            //添加到链表头部
            addToHead(newNode);
            size++;
            //判断新添加节点后是否超出容量，淘汰链表尾部的缓存
            //先加后减省掉考虑0的情况
            if (size + 1 > capacity) {
                DLinkedNode tailNode = tail.pre;
                removeNode(tailNode);
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkedNode node) {
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }

    class DLinkedNode {
        private int key;
        private int value;
        //使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

package com.lgq.modeler.ds.consistenthash;

import com.google.common.base.Strings;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 带虚拟节点的一致性Hash算法
 */
public class ConsistentHashingWithVirtualNode {

    //待添加入Hash环的服务器列表
    private static String[] servers = {"192.168.0.0:8080", "192.168.0.1:8080"};

    //待添加入Hash环的服务器列表
    private static String[] serverExtends = {"192.168.0.0:8080", "192.168.0.1:8080", "192.168.0.2:8080"};

    //真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
    private static List<String> realNodes = new LinkedList<String>();

    //虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
    private static SortedMap<Long, String> virtualNodes = new TreeMap<>();

    //虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应8个虚拟节点
    private static final int VIRTUAL_NODES = 65535;

    private static void init() {
        //先把原始的服务器添加到真实结点列表中
        for (int i = 0; i < servers.length; i++) {
            realNodes.add(servers[i]);
        }

        //再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                long hash = HashUtil.hash(virtualNodeName);
                //System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }


    private static void extend() {
        realNodes = new LinkedList<String>();
        //先把原始的服务器添加到真实结点列表中
        for (int i = 0; i < serverExtends.length; i++) {
            realNodes.add(serverExtends[i]);
        }

        //再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                Long hash = HashUtil.hash(virtualNodeName);
                //System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }


    //得到应当路由到的结点
    private static String getServer(String key) {
        //得到该key的hash值
        Long hash = HashUtil.hash(key);
        // 得到大于该Hash值的所有Map
        SortedMap<Long, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            Long i = virtualNodes.firstKey();
            //返回对应的服务器
            virtualNode = virtualNodes.get(i);
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            Long i = subMap.firstKey();
            //返回对应的服务器
            virtualNode = subMap.get(i);
        }
        //virtualNode虚拟节点名称要截取一下
        if (!Strings.isNullOrEmpty(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    public static void main(String[] args) {
        init();
        System.out.println("Server扩容前:");
        String[] keys = new String[10];
        for (int i = 0; i < 10; i++) {
            keys[i] = "node_" + i;
        }
        // 扩容前
        for (int i = 0; i < 10; i++) {
            if (Strings.isNullOrEmpty(keys[i])) {
                continue;
            }
            //System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i]) + ", 被路由到结点[" + getServer(keys[i]) + "]");
            System.out.println(keys[i] + "->" + getServer(keys[i]));
        }
        System.out.println("Server扩容后:");
        extend();
        // 扩容后
        for (int i = 0; i < keys.length; i++) {
            if (Strings.isNullOrEmpty(keys[i])) {
                continue;
            }
            System.out.println(keys[i] + "->" + getServer(keys[i]));
            //System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i]) + ", 被路由到结点[" + getServer(keys[i]) + "]");
        }
    }
    //from https://blog.csdn.net/u010558660/article/details/52767218
}
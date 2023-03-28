package com.lcf.learn.data.stracture.list;

public interface MyList<T> {

    /**
     * 设置指定数组下标的元素的值
     *
     * @param idx 下标
     * @return val
     */
    T get(int idx);

    /**
     * 设置指定数组下标的元素的值
     *
     * @param idx 下标
     * @param val 值
     */
    void set(int idx, T val);

    /**
     * 判断给定值是否在列表中存在
     *
     * @param val 值
     * @return 是否存在
     */
    boolean contains(T val);

    /**
     * 在头部插入数据
     *
     * @param val 待插入数据
     */
    void addHead(T val);

    /**
     * 在尾部插入数据
     *
     * @param val 待插入数据
     */
    void addTail(T val);

    /**
     * 删除指定位置的数据
     *
     * @param idx 下标
     */
    void delete(int idx);

    /**
     * 在指定下标插入一个元素
     *
     * @param idx 数组下标
     * @param val 指定值
     */
    void insert(int idx, T val);

    /**
     * 获取给定元素在数组中的下标，不存在时返回-1
     *
     * @param val 给定值
     * @return 下标，不存在时返回-1
     */
    int indexOf(T val);

    /**
     * 返回数组中元素的个数
     * @return 数组中元素的个数
     */
    int size();


}

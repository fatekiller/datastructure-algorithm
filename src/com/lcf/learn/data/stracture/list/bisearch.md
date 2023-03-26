## 二分查找

### 核心思路
**每次丢掉一部分肯定不存在答案的**

**退出条件**
由于 `mid = (left+right)/2`

如果`right = left+1`,则计算出的新`mid`仍然等于`left`，因此


如果判断是 `left<right` ，则`left`每一轮必须更新为`mid+1`;`right`可以设置为`mid`;
最后退出的时候`left`会等于`right`;且最后其取值会偏左，例如：
`[1,2,4]`和`[1,2,4,5]` 中二分查找3，`left`最后都会为1

如果退出判断是`left<right`，则`left`和`right`都必须更新为和mid不一致，否则会死循环，
这种写法不能用于解找最后一个target或者第一个target这种问题

## 常见问题

#### 求插入位置 或 求第一个大于等于target的数的下标
每一轮可以淘汰小于target的一半，则可以这样写，小于的一部分不要
```python
if nums[mid] < target:
    left = mid+1
else:
    right = mid
```
这样可以保证每次淘汰的都是不要的一半

#### 求最后出现的位置，求最后一个小于等于
如果沿用之前的思路，就是 `nums[mid]>target` 则`end = mid-1`;但是循环条件是`left<right`时`left`不能设置为
`mid+1` 因为会丢掉可能的解，`left`也不能设置为`mid`，因为会死循环
可以转换为求第一个大于target的下标，则可以这样写：
```python
if nums[mid] <= target:
    left = mid+1
else:
    right = mid
```
求到

和上面的区别是多了一个等于号，最后返回`left-1`表示最后一个小于或等于target的元素的下标
边界条件是：
- 不存在小于等于`target`的，则`left`会落到0，`nums[0]`也大于`target`,自然没有小于等于target的
- 全部都严格小于`target`，求到的`left`是`n-1`,不需要-1了，需要特殊处理一下


#### 循环条件是 left<=right
循环条件是`left<=right`时，最后退出时必定是 `left=right+1`;对应上面的例子，可以看到
当使用`nums[mid]>target` 判断，设置`end = mid-1`时;`left`设置为
`mid+1`会丢掉解，则`left-1`永远是一个合法的解
如果`nums[mid]>target`是true,那么收缩的逻辑是正确的，不会丢掉解
如果`nums[mid]>target`是false,那么`nums[mid]`是解，因为`left`设置为`mid+1`,则
返回`left-1`即可
这个算法当全部的值都严格小于`target`时，left会收缩到右边界然后越界，`left-1`恰好为最终解
不需要特殊处理

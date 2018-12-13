/**
 * @Title: UnionFind
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/9 3:54 PM
 * @Description: 动态连通性算法
 */

public abstract class UnionFind {
    /***
     * 定义成抽象类， 因为find和union方法有不同的实现方式， 通过不同的子类去实现
     */
    int[] id; //分量id（以触点作为索引）
    int count; //分量数量
    //public UnionFind(){}
    public UnionFind(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i=0; i<N; i++)
            id[i] = i;

    }
    public int count(){return count;}
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public abstract int find(int p);
    public abstract void union(int p, int q);
}

/***
 * 第一种实现方式： quick find
 * 即 find的速度很快但是union速度慢
 */
class QuickFind extends UnionFind{
    public QuickFind(int N){
        super(N);
    }
    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        if(pID == qID) return;
        for(int i=0; i<id.length; i++){
            if(id[i] == pID) id[i] = qID;
        }
        count -- ;
    }

}

/***
 * 第二种实现方式， quick union
 * 快速联通，但是find速度慢
 */
class QuickUnion extends UnionFind{
    public QuickUnion(int N){
        super(N);
    }
    @Override
    public int find(int p) {
        while (p !=id[p]) p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count -- ;
    }
}

/***
 * 第三种方式：加权quick union
 * 对quick union的改进， 根据根节点的分量数判断那颗树作为根进行合并
 * 这种方式总能保证小树合并（联通）到大树上， 保证了find的速读
 */
class FindUnion extends UnionFind{
    private int[] sz ; //根节点所对应分量的大小
    public FindUnion(int N){
        super(N);
        sz = new int[N];
        for(int i=0; i<N; i++) sz[i] = 1;   //初始情况每个根节点分量数为1
    }
    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) return;

        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        count --;
    }
}


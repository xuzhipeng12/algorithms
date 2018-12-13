/**
 * @Title: Example
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/11 9:38 PM
 * @Description: 排序算法的基础模板
 */

public class Example {
    public static void sort(Comparable[] compare){

    }
    static boolean less(Comparable v, Comparable w){
        //判断v是否小于w
        return v.compareTo(w) < 0;
    }
    static void exch(Comparable[] a, int i, int j){
        //交换两个值
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static boolean isSorted(Comparable[] a){
        // 测试数组是否有序
        for(int i = 1; i<a.length ; i++){
            if(less(a[i], a[i-1]))
                return false;
        }
        return true;
    }
}

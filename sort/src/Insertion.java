/**
 * @Title: Insertion
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/12 9:56 PM
 * @Description: 插入排序
 * 思想： 算法 page 157
 */
public class Insertion extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i<N; i++){
            for(int j=i; j>0 && less(a[j], a[j-1]) ;j--){
                    exch(a,j,j-1);
            }
        }
    }
}

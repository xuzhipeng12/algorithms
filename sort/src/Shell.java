/**
 * @Title: Shell
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/12 10:09 PM
 * @Description: 希尔排序
 * 本质： 插入插入排序
 * 思想 ： 算法 page 162
 */
public class Shell extends Example {
    public  static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1; //1, 4, 13， 40， 121， 364， 1093
        while(h >= 1){
            // 将数组变为h有序
            for(int i=h; i< N; i++)
                for(int j=i; j>=h && less(a[j], a[j-h]); j -= h )
                    exch(a,j, j-h);

            h = h/3;
        }
    }
}

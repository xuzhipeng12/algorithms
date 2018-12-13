/**
 * @Title: Selection
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/12 9:42 PM
 * @Description: 选择排序
 * 思想： 算法 page 155
 */
public class Selection extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i<N; i++){
            int min = i;
            for(int j=i+1; j<N; j++)
                if(less(a[j], a[min]))
                    min = j;
            exch(a,min,i);
        }
    }
}

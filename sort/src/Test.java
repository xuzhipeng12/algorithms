/**
 * @Title: Test
 * @ProjectName: algorithms
 * @author: xuzhipeng
 * @date: 2018/12/12 9:45 PM
 * @Description:
 */
public class Test {
    public static void main(String[] args){
        Integer[] a = {4,5,3,8,2,1,9,7,6};
        Shell.sort(a);
        System.out.println(Example.isSorted(a));
        Example.show(a);
    }
}

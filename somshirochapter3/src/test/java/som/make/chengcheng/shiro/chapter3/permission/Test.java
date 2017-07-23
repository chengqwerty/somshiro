package som.make.chengcheng.shiro.chapter3.permission;

/**
 * Created by Think on 2017/7/23.
 */
public class Test {

    @org.junit.Test
    public void test1(){
        String abc="+user+10";
        String[] array=abc.split("\\+");
        for(String str:array){
            System.out.println(str);
        }
    }
}

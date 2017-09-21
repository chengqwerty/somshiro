package som.make.chengcheng.shiro.chapter3.chengcheng;

public class Test {

    @org.junit.Test
    public void test1() {
        String chengStr = "+cheng++123+++++";
        String[] result = chengStr.split("\\+");
        System.out.println(result.length);
        for(String str: result) {
            System.out.println("====================");
            System.out.println(str);
        }
    }

}

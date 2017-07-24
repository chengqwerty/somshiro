package som.make.chengcheng.shiro.chapter3.permission;

/**
 * Created by Think on 2017/7/23.
 */
public class Test {

    private String abc;

    private Test test;


    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void testAbc(){
        System.out.println(this.test.abc);
    }

    @org.junit.Test
    public void test1(){
        String abc="+user+10";
        String[] array=abc.split("\\+");
        for(String str:array){
            System.out.println(str);
        }
    }

    @org.junit.Test
    public void test3(){
        Test test=new Test();
        Test test1=new Test();
        test1.setAbc("abcdef");
        test.setTest(test1);
        test.testAbc();
    }

    @org.junit.Test
    public void test2(){
        BitPermission bitPermission=new BitPermission("+*+3+1");

        boolean isTrue=bitPermission.implies(new BitPermission("+user+10+1"));

        System.out.println("================"+isTrue);
    }
}

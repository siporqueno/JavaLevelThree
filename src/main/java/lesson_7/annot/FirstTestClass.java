package lesson_7.annot;

public class FirstTestClass {
    @BeforeSuite
    public void init() {
        System.out.println("Inside the method init with annotation @BeforeSuite");
    }

   /* @BeforeSuite
    public void initAgain() {
        System.out.println("Inside the method initAgain with annotation @BeforeSuite");
    }*/

    @Test(Priority.NINE)
    public void testOne() {
        System.out.println("Inside the method testOne with annotation @Test and priority 9");
    }

    @Test(Priority.THREE)
    public void testTwo() {
        System.out.println("Inside the method testTwo with annotation @Test and priority 3");
    }

    @Test
    public void testThree() {
        System.out.println("Inside the method testThree with annotation @Test and priority 5");
    }

    @Test(Priority.SEVEN)
    public void testFour() {
        System.out.println("Inside the method testFour with annotation @Test and priority 7");
    }

    @Test
    public void testFive() {
        System.out.println("Inside the method testFive with annotation @Test and priority 5");
    }

    @Test(Priority.SIX)
    public void testSix() {
        System.out.println("Inside the method testSix with annotation @Test and priority 6");
    }

    @AfterSuite
    public void terminate() {
        System.out.println("Inside the method with annotation @AfterSuite");
    }
}

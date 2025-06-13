
import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("#### BeforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("#### afterEach\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("#### afterAll()\n");
    }

    @Test
    void successTest1() {
        System.out.println("####        test1");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void successTest2() {
        System.out.println("####        test2");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}


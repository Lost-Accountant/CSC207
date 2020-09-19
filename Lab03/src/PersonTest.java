import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void LetHimSip(){
        SodaCan testcan = new SodaCan("cola");
        Person tester = new Person();

        // assert statements
        tester.takeSip(testcan);
        assertEquals("amount drank must be 10", 10, tester.amountDrunk);
    }
}
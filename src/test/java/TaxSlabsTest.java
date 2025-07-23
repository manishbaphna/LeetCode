import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxSlabsTest {

    @Test
    void basicTest(){
        TaxSlabs ts = new TaxSlabs();
        double tax = ts.calculateTax(249_000, ts.ftbSlabs);
        assertEquals(tax, 0);
        tax = ts.calculateTax(249_000, ts.ftbSlabs);
        assertEquals(tax, 0);
        tax = ts.calculateTax(250_000, ts.ftbSlabs);
        assertEquals(tax, 0.02);
        tax = (int)ts.calculateTax(500_000 - 1, ts.ftbSlabs);
        assertEquals (tax, 5000);
        tax = (int)ts.calculateTax(1_000_000 - 1, ts.ftbSlabs);
        assertEquals (tax, 30_000);
        tax = (int)ts.calculateTax(1_500_000 - 1, ts.ftbSlabs);
        assertEquals (tax, 70_000);
        tax = (int)ts.calculateTax(2_500_000 - 1, ts.ftbSlabs);
        assertEquals (tax, 190_000);
    }
}
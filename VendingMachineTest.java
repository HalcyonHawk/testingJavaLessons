
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {
    VendingMachine machine = new VendingMachine();
    
    @Test
    public void testInitialBalance() {
        assertEquals(0, machine.getBalance());
    }
    
    @Test
    public void testInitialRevenue() {
        assertEquals(0, machine.getRevenue());
    }
    
    @Test
    public void testInsertCoins() {
        machine.insertCoin();
        assertEquals(1, machine.getBalance());
        assertEquals(0, machine.getRevenue());
    }
    
    @Test
    public void testRefund() {
        machine.insertCoin();
        assertEquals(1, machine.refund());
        assertEquals(0, machine.getBalance());
        assertEquals(0, machine.getRevenue());
    }
    
    @Test
    public void testVendFailure() {
        assertFalse(machine.vendCandyBar());
        assertEquals(0, machine.getBalance());
        assertEquals(0, machine.getRevenue());
    }
    
    @Test
    public void testVendSuccess() {
        machine.insertCoin();
        machine.insertCoin();
        machine.insertCoin();
        assertTrue(machine.vendCandyBar());
        assertEquals(3, machine.getRevenue());
        assertEquals(0, machine.getBalance());
    }
}


import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest{
    BankAccount account = new BankAccount(100, 123456, "Tilly", "current");
    
    @Test
    //test balance- expected, actual, error tolerance 
    //1 line version 
    public void testGetBalance(){
        assertEquals(100.0, account.getBalance(), 0);
    }
    
    @Test
    public void testGetAccountNumber(){
        int accountNumber = account.getAccountNumber();
        assertEquals(123456, accountNumber);
    }
    
    @Test
    public void testGetAccountHolder(){
        String accountHolder = account.getAccountHolder();
        assertEquals("Tilly", accountHolder);
    }
    
    @Test
    public void testGetKind(){
        String kind = account.getKind();
        assertEquals("current", kind);
    }
    
    
    @Test
    public void testSetBalance(){
        account.setBalance(200);
        assertEquals(200.0, account.getBalance(), 0);
    }
    
    @Test
    public void testSetAccountNumber(){
        account.setAccountNumber(260199);
        assertEquals(260199, account.getAccountNumber());
    }
    
    @Test
    public void testSetAccountHolder(){
        account.setAccountHolder("Me");
        assertEquals("Me", account.getAccountHolder());
    }    
    
    @Test
    public void testSetKind(){
        account.setKind("savings");
        assertEquals("savings", account.getKind());
    }    
    
    
    @Test
    public void testDeposit(){
        account.deposit(50);
        assertEquals(150.0, account.getBalance(), 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegative(){
        account.deposit(-70);
        assertEquals(account.getBalance(), 0);
    }
    
    @Test
    public void testNotOverdrawn(){
        assertFalse(account.isOverdrawn());
    }
    @Test
    public void testOverdrawn(){
        account.setBalance(-40);
        assertTrue(account.isOverdrawn());
    }
    @Test
    public void testOverdrawnBoundary(){
        account.setBalance(0);
        assertTrue(account.isOverdrawn());
    }
}

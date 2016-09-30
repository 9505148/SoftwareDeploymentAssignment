import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.Test;
import servlet.MyServlet;

public class TestMyServlet {

	@Test
	public void testGetDateFromString() throws ParseException 
	{
		//Get age from input
		Calendar calendar = MyServlet.getDateFromString("01/01/2000");
		
		assertEquals(2000, calendar.get(Calendar.YEAR));
		assertEquals(0, calendar.get(Calendar.MONTH)); //january is zero
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void testGetDateFromString2() throws ParseException 
	{
		//Get age from input
		Calendar calendar = MyServlet.getDateFromString("19/11/2037");
		
		assertEquals(2037, calendar.get(Calendar.YEAR));
		assertEquals(10, calendar.get(Calendar.MONTH)); //january is zero
		assertEquals(19, calendar.get(Calendar.DAY_OF_MONTH));
	}
}

/**
 * 
 */
package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.util.DBChecker;

/**
 * @author raghavan.muthu
 *
 */
class DBCheckerJUnitTest {

	/**
	 * Test method for {@link com.raghsonline.miniprojects.tms.db.DBConnection#getConn()}.
	 */
	@Test
	void testGetConn() {
		//fail("Not yet implemented");
		//fail("My own error message"); // this would never be reached
		
		DBChecker.checkDB();
		assertEquals(true, DBChecker.FLAG_DB_READY);
	}
	
	//@Test
	void verifyCount() {
		assertEquals(1,1);
	}

}

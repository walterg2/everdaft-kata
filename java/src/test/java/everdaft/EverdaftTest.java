package everdaft;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EverdaftTest {

	@Before
	public void setUp() throws Exception {		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Everdaft everdaft = new Everdaft();
		assertTrue(everdaft != null);
		everdaft.execute();
	}

}

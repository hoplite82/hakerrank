package hack.md5;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	private ByteArrayOutputStream testOut;

	private String getOutput() {
		return testOut.toString().trim();
	}

	@Before
	public void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	@Test
	public void testMain() throws IOException {

		String expected = Files.readString(Path.of("testdata/md5/output/output00.txt")).trim();
		System.setIn(new FileInputStream(new File("testdata/md5/input/input00.txt")));
		Solution.main(new String[0]);
		assertEquals(expected, getOutput());

	}

	@After
	public void restoreSystemInputOutput() {
		System.setIn(System.in);
		System.setOut(System.out);
	}

}

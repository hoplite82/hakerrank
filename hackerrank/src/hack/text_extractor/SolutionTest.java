package hack.text_extractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;

	String t1input = """
			2
			<h1>My text first</h1>
			jklj<h15>My text 2</h15> jkljk
			""";
	String t1expected = """
			My text first
			My text 2
			""";
//	private String testdata[][] = { {t1input},{t1expected} };

	@Before
	public void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	private void provideInputFromFile(String path) {
		InputStream fin;
		try {
			fin = new FileInputStream(new File(path));
			System.setIn(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getOutput() {
		return testOut.toString();
	}

	@After
	public void restoreSystemInputOutput() {
		System.setIn(systemIn);
		System.setOut(systemOut);
	}

	@Test
	public void testSolution() {
		String t1expected = """
				My text first
				My text 2
				""";
		provideInput(t1input);
		Solution.main(new String[0]);

		try {
			assertEquals(t1expected.trim(), getOutput().trim());
		} catch (AssertionError ae) {
			fail(MessageFormat.format("""

					expected:
					{0}
					computed:
					{1}
					""", t1expected.trim(), getOutput().trim()));
		}
	}

	@Test
	public void testSolutionInput01() throws IOException {
		String expected = Files.readString(Path.of("testdata/text_extractor/output/output01.txt"));

		provideInputFromFile("testdata/text_extractor/input/input01.txt");
		Solution.main(new String[0]);

		try {
			assertEquals(expected, getOutput());
		} catch (AssertionError ae) {
			fail(MessageFormat.format("""
					expected:
					{0}
					computed:
					{1}
					""", expected, getOutput()));
		}
	}
	
	@Test
	public void testSolutionInput00() throws IOException {
		String expected = Files.readString(Path.of("testdata/text_extractor/output/output00.txt"));

		provideInputFromFile("testdata/text_extractor/input/input00.txt");
		Solution.main(new String[0]);

		try {
			assertEquals(expected, getOutput());
		} catch (AssertionError ae) {
			fail(MessageFormat.format("""
					expected:
					{0}
					computed:
					{1}
					""", expected, getOutput()));
		}
	}
	
	@Test
	public void testSolutionInput02() throws IOException {
		String expected = Files.readString(Path.of("testdata/text_extractor/output/output02.txt"));

		provideInputFromFile("testdata/text_extractor/input/input02.txt");
		Solution.main(new String[0]);

		Files.writeString(Path.of("testdata/text_extractor/unitlogf.txt"),getOutput(), StandardOpenOption.CREATE);
			assertEquals(expected, getOutput());
			
		
	}

	@Test
	public void innerTextTest() throws IOException {
		List<String> expected = Files.readAllLines(Path.of("testdata/text_extractor/output/output02.txt"));
		List<String> inputs =   Files.readAllLines(Path.of("testdata/text_extractor/input/input02.txt"));
		inputs.remove(0);
		// assertEquals(expected.size(), inputs.size());
		int pos = 0;
		for (int i = 0; i < inputs.size(); i++) {
			String computed = Solution.innerText(inputs.get(i));
			computed = computed.trim();
			var computedlines = computed.lines().toList();
			try {
				for (String line : computedlines) {
					assertEquals(expected.get(pos++), line);
				}
				
			} catch (AssertionError ae) {
				Files.writeString(Path.of("testdata/text_extractor/unitlog.txt"), inputs.get(i), StandardOpenOption.CREATE);
				Files.writeString(Path.of("testdata/text_extractor/unitlog2.txt"),computed, StandardOpenOption.CREATE);
				Files.writeString(Path.of("testdata/text_extractor/unitlog2.txt"),computed, StandardOpenOption.CREATE);
				
				fail(MessageFormat.format("""
						i: {0} pos: {1}
						expected:
						{2}
						computed:
						{3}
						""",i, pos, expected.get(pos), computed));
			}
			
		}

	}

}
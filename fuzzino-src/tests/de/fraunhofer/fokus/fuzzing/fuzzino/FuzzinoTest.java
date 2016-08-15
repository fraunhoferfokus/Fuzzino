package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/***
 * Superclass for all testcases to avoid code duplication for initializations that all test classes need
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class FuzzinoTest {

	@BeforeClass
	/***
	 * This method is there to avoid producing files in the permanent directory specified in the RequestProcessor class whenever the tests are executed.
	 * Thus every testcase should extend this class
	 */
	public static void setupTemporarySerializationDirectory() throws IOException {
		Path temp = Files.createTempDirectory("fuzzinoTemp");
		temp.toFile().deleteOnExit();
		RequestProcessor.setSerializationDir(temp.toFile());
	}
	
	
	@AfterClass
	/***
	 * Apparently deleteOnExit does not work if there are files in the directory, so we need a manual cleanup:
	 * @throws IOException
	 */
	public static void cleanupTemporarySerializationDirectory() throws IOException {
		File dir = RequestProcessor.getSerializationDir();
		for(File file: dir.listFiles()){
			file.delete();
		}
		dir.delete();
	}

}

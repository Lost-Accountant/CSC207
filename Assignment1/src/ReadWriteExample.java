import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Prompt for and read the name of a file from standard input, write two lines
 * to that file, prompt for and read another file name, and print the contents
 * to standard output.
 */
public class ReadWriteExample {

	/**
	 * Demonstrate input and output.
	 */
	public static void main(String[] args) throws IOException {
		// Hook up to standard input.
		try (BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
			// Get the name of an output file from standard input.
			System.out.print("Enter name of file to write: ");
			String fileName = keyboard.readLine();

			// Open the file for writing and write to it.
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
				out.println("This is the first line.");
				out.println("This is the second line.");
				System.out.println("File has been written.");
			}

			// Read the name of a file and print its contents to standard output. 
			System.out.print("Enter name of file to read: ");
 			fileName = keyboard.readLine();
			try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

				// Print the lines from f prefaced with the line number,
				// starting at 1.
				String line = fileReader.readLine();
				int i = 1;
				while (line != null) {
					System.out.println("Line " + i + ": " + line);
					line = fileReader.readLine();
					i++;
				}
			}
		}
	}
}
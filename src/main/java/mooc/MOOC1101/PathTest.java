package mooc.MOOC1101;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) {

		Path path = FileSystems.getDefault().getPath("c:/temp", "abc.txt");
		System.out.println(path.getNameCount());

		File file = new File("c:/temp/abc.txt");
		Path pathOther = file.toPath();

		System.out.println(path.compareTo(pathOther));

		Path path3 = Paths.get("c:/temp", "abc.txt");
		System.out.println(path3.toString());

		Path path4 = Paths.get("c:/temp");
		System.out.println("path4: " + path4.resolve("abc.txt"));

		if (Files.isReadable(path)) {
			System.out.println("it is readable");
		} else {
			System.out.println("it is not readable");
		}
	}
}

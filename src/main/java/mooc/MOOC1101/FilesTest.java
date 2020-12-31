package mooc.MOOC1101;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.util.Date;

public class FilesTest {
	
	public static void main(String[] a)
	{
		moveFile();
        System.out.println("111111111111111111111111");
        System.out.println("111111111111111111111111");
        System.out.println("111111111111111111111111");
		fileAttributes();
        System.out.println("111111111111111111111111");
		createDirectory();
	}

	public static void moveFile() {

		Path from = Paths.get("c:/", "abc.txt");
		Path to = from.getParent().resolve("test/def.txt");

		try {

			System.out.println(Files.size(from));
			Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			System.err.println("error::::::::::"+e.getMessage());
		}
	}
	
	
	public static void fileAttributes(){
		Path path = Paths.get("c:/temp");
		System.out.println(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));
		try {
			BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.println(attributes.isDirectory());

			System.out.println(new Date(attributes.lastModifiedTime().toMillis()).toLocaleString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createDirectory(){
		Path path = Paths.get("c:/temp/test");
		try {

			if(Files.notExists(path)){
				Files.createDirectories(path);
				System.out.println("create dir");
			}else{
				System.out.println("dir exists");
			}
//			Path path2 = path.resolve("A.java");
//			Path path3 = path.resolve("B.java");
//			Path path4 = path.resolve("C.txt");
//			Path path5 = path.resolve("D.jpg");
//			Files.createFile(path2);
//			Files.createFile(path3);
//			Files.createFile(path4);
//			Files.createFile(path5);

			DirectoryStream<Path> paths = Files.newDirectoryStream(path);
			for(Path p : paths){
				System.out.println(p.getFileName());
			}
            paths.close();
			System.out.println();

			DirectoryStream<Path> pathsFilter = Files.newDirectoryStream(path, "*.{java,txt}");
			for(Path p : pathsFilter){
				System.out.println(p.getFileName());
			}
            pathsFilter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

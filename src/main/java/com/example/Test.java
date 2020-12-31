package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    static Pattern pattern = Pattern.compile("^102D\\d{11}$");
    static final Path buluFile = new File("F:\\2020年5月起图片\\2019补充扫描\\1.jpg").toPath();
    private static int cnt;
    private static int cnt2;

    static String ArchiveNo = "";
    static int archiveIndex = 0;
    public static void main(String[] args) throws IOException {

        File file = new File("F:\\2020年5月起图片\\2019补充扫描");

        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("------------------------------");
                String fileName = dir.getFileName().toString();
                if (fileName.startsWith("102D")){
                    Matcher matcher = pattern.matcher(fileName);
                    boolean matches = matcher.matches();
                    if(matches){
                        ArchiveNo = fileName;
                        archiveIndex = 0;
                        System.out.println(fileName);
                    }
                }

                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                cnt++;
                archiveIndex++;
               Files.copy(buluFile,new File("F:\\2020年5月起图片\\2019补充扫描\\cover\\"+ArchiveNo+".jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
                //System.out.println(parent+File.separator+ArchiveNo+"-"+(archiveIndex)+".jpg");
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });

        System.out.println(cnt);

    }
}

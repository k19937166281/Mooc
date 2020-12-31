package mooc;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        //通过输入输出流控制文件
        inputOutputCopy();
        //使用tryResource的方式通过输入输出流控制文件
        tryResourceInputOutputCopy();
        //通过 jdk1.7 Files工具类 控制文件（内部做好了输入输出流操作）
        filesWriteCopy();
        //Files 加 输入流 切割文件
        toPart();
        //通过Files合并文件 通过输入输出流合并文件
        merge();
    }

    public static void inputOutputCopy(){

        FileInputStream fileInputStream =null;
        BufferedInputStream bufferedInputStream= null;
        DataInputStream dataInputStream = null;

        FileOutputStream fileOutputStream =null;
        BufferedOutputStream bufferedOutputStream= null;
        DataOutputStream dataOutputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\k1326\\Desktop\\1.jpg");//节点类 我把它当作入口
            bufferedInputStream = new BufferedInputStream(fileInputStream);//缓冲类  我把它当作缓存
            dataInputStream = new DataInputStream(bufferedInputStream);//装饰类  据说是 与字节字符有关，最后是用字节的方式来读入java


            fileOutputStream = new FileOutputStream("D:\\2222.jpg");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            dataOutputStream = new DataOutputStream(bufferedOutputStream);

            byte[] change = new byte[1024];
            int len=-1;
            // 这种方式来写呢   最后一次 write 会多出来 一部分字节
            //所以要通过 read 的 数量 来控制最后一次的 write
//            while(true){
//                int read = dataInputStream.read(change);
//                if (read==-1){
//                    break;
//                }
//                dataOutputStream.write(change,0,read);
//            }
            //终极模式   jdk
            while((len=dataInputStream.read(change))!=-1){
                dataOutputStream.write(change,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                dataInputStream.close();
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //主体代码11行  nice  上面都是28行
    public static  void tryResourceInputOutputCopy(){
        //try  resource  格式   不用去管理  资源的释放   觉得不错
        try(
                DataInputStream dataInputStream =new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\k1326\\Desktop\\1.jpg")));
                DataOutputStream dataOutputStream =new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\k1326\\Desktop\\1.jpg")));
        ){
            byte[] change = new byte[1024];
            int len=-1;
            while((len=dataInputStream.read(change))!=-1){
                dataOutputStream.write(change,0,len);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // jdk1.7  6行
    public static  void filesWriteCopy(){
        //通过这种方式呢，我可以把  每一个部分文件按照顺序读取出字节数组，然后通过 追加变量  把每一个字节写到文件追加到文件字节的最后面，从而达到文件的合并效果
        //Files.write(new File("").toPath(),new byte[0],StandardOpenOption.APPEND);
        //那么自然而然的 可以通过 读取一个文件的字节来进行 拆分操作  比如 每 10240个字节 作为一个部分（part）  然后通过   //Files.write(new File(i+".part").toPath(),new byte[0],StandardOpenOption.CREATE_NEW);
        //try  resource  格式   不用去管理  资源的释放   觉得不错
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("C:\\Users\\k1326\\Desktop\\1.jpg"), StandardOpenOption.READ);
            // deleteIfExists(target);  再底层 就需要 稍微深入一些了    FileSystemProvider
            long copy = Files.copy(inputStream, new File("C:\\Users\\k1326\\Desktop\\2.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(copy);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //切割文件  最近简单的看了一下流，结合着之前的代码经历，就思考自己进行文件切割，果然基础的重要性，感觉得到了一些收获
    public static void toPart(){
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("C:\\Users\\k1326\\Desktop\\202-8-3.rar"), StandardOpenOption.READ);
            //FileOutputStream fileOutputStream = null;  //此处对象不需要接收
            BufferedOutputStream bufferedOutputStream = null;
            //DataOutputStream dataOutputStream = null;//已经是字节，不是用这个类装饰了
            //10M
            byte[] b = new byte[10240000];
            int len=-1;
            int i=0;
            while((len=inputStream.read(b))!=-1){
                i++;
                //String.format("%04d",i) 通过它就可以不进行 排序操作了
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\k1326\\Desktop\\part\\"+String.format("%04d",i)+".part"));
                bufferedOutputStream.write(b,0,len);
                bufferedOutputStream.close();
                // Files.write(Paths.get("C:\\Users\\k1326\\Desktop\\part\\"+String.format("%04d",i)+".part"),b,StandardOpenOption.CREATE_NEW);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void merge(){
        File file = new File("C:\\Users\\k1326\\Desktop\\part");
        Path path = file.toPath();
        //茴香豆 的 茴
        //JDK1.0
        File[] files = file.listFiles((dir,name)->name.endsWith(".part"));
        try {
            //1.8
            Stream<Path> list = Files.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //1.7
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.walkFileTree()

        try {
            new File("C:\\Users\\k1326\\Desktop\\1.rar").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //8行 merge
        Path path1 = Paths.get("C:\\Users\\k1326\\Desktop\\1.rar");
        for (File file1 : files) {
            try {
                Files.write(path1,Files.readAllBytes(file1.toPath()),StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //21行 merge
        BufferedOutputStream bufferedOutputStream= null;
        FileInputStream fileInputStream = null;
        byte[] b = new byte[1024];
        int len=-1;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\k1326\\Desktop\\2.rar"));
            for (File file1 : files) {
                    fileInputStream = new FileInputStream(file1);
                    while((len=fileInputStream.read(b))!=-1){
                        bufferedOutputStream.write(b,0,len);
                    }
                    fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
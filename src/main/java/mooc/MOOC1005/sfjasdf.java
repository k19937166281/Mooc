package mooc.MOOC1005;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class sfjasdf
{
    public static void main(String[] args) {
        String url =
                "http://localhost:8080/LCBUpdateImageBase/static/upload/1246375202310206-1.jpg";
        String path="1246375202310206-1.jpg";
        downloadPicture(url,path);
    }

    //链接url下载图片
    /**
     * 功能描述:
     * @param:  urlList  图片url地址
     * @param:  path     下载到本地的路径
     * @return: void
     * @author: lemon
     * @since: 2019/9/27 0027
     */
    private static void downloadPicture(String urlList,String path) {

        try {

            URL url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

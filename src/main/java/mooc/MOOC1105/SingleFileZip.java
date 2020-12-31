package mooc.MOOC1105;

import java.io.File ;
import java.io.FileInputStream ;  
import java.io.InputStream ;  
import java.util.zip.ZipEntry ;  
import java.util.zip.ZipOutputStream ;  
import java.io.FileOutputStream ;  
public class SingleFileZip{  
    public static void main(String args[]) throws Exception{    
        File file = new File("c:/temp/abc.txt") ;  // ����Ҫѹ�����ļ�  
        File zipFile = new File("c:/temp/single2.zip") ;   // ����ѹ���ļ�����  
        
        InputStream input = new FileInputStream(file) ; // �����ļ���������  
        ZipOutputStream zipOut = null ; // ����ѹ��������  
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;  
        zipOut.putNextEntry(new ZipEntry(file.getName())) ; // ����ZipEntry����  
        zipOut.setComment("single file zip") ;  // ����ע��  
        
        //ѹ������
        int temp = 0 ;  
        while((temp=input.read())!=-1){ // ��ȡ����  
            zipOut.write(temp) ;    // ѹ�����  
        }  
        input.close() ; // �ر�������  
        zipOut.close() ;    // �ر������  
        
        System.out.println("single file zip done.");
    }  
}
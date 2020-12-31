package mooc.MOOC1105;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry ;  
import java.util.zip.ZipInputStream ;   
public class SingleFileUnzip{  
    public static void main(String args[]) throws Exception{     
        //����ѹ�ļ�, ��Ҫ��zip�ļ�������������ȡ���ݵ�java��
    	File zipFile = new File("c:/temp/single.zip") ;   // ����ѹ���ļ�����          
        ZipInputStream input = null ;   // ����ѹ��������  
        input = new ZipInputStream(new FileInputStream(zipFile)) ;  // ʵ����ZIpInputStream  
        ZipEntry entry = input.getNextEntry() ; // �õ�һ��ѹ��ʵ��  
        System.out.println("ѹ��ʵ�����ƣ�" + entry.getName()) ;  //��ȡѹ�������ļ����� 
        
        //�½�Ŀ���ļ�����Ҫ��Ŀ���ļ�������������ݴ�java����
        File outFile = new File("c:/temp/" + entry.getName());
        OutputStream out = new FileOutputStream(outFile) ;   // ʵ�����ļ������  
        int temp = 0 ;  
        while((temp=input.read())!=-1){  
            out.write(temp) ;  
        }  
        input.close() ;     // �ر�������  
        out.close() ;   // �ر������
        System.out.println("unzip done.") ;
    }  
}
package mooc.MOOC1101;

import java.io.*;
public class FileAttributeTest{
  public static void main(String[] args){
	//����Ŀ¼
	File d=new File("c:/temp");
	if(!d.exists())
	{
		d.mkdirs();  //mkdir ��������Ŀ¼  mkdirs ���������༶Ŀ¼
	}
	System.out.println("Is d directory? " + d.isDirectory());
	
	//�����ļ�  
    File f=new File("C:/temp/abc.txt");    
    if(!f.exists())
    {    	
      try
      {
        f.createNewFile(); //����abc.txt
      }
      catch(IOException e){ //���ܻ���ΪȨ�޲���������������
    	  e.printStackTrace();
      }
    }  
    
    //����ļ��������
    System.out.println("Is f file? " + f.isFile());
    System.out.println("Name: "+f.getName());
    System.out.println("Parent: "+f.getParent());
    System.out.println("Path: "+f.getPath());
    System.out.println("Size: "+f.length()+" bytes");
    System.out.println("Last modified time: "+f.lastModified()+"ms");
    
    //����dĿ¼�����е��ļ���Ϣ
    System.out.println("list files in d directory");
    File[] fs = d.listFiles();  //�г�dĿ¼�����е����ļ�����������Ŀ¼�µ��ļ�
    for(File f1:fs)
    {
    	System.out.println(f1.getPath());
    }
    
    //f.delete(); //ɾ�����ļ�
    //d.delete(); //ɾ��Ŀ¼
  }
}

package mooc.MOOC1104;

import java.io.*;
public class BinFileWrite{
  public static void main(String[] args) throws Exception{
	writeFile();
    System.out.println("done.");
  }
  
  public static void writeFile() {
	  FileOutputStream fos = null;
	  DataOutputStream dos = null;
	  BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("c:/temp/def.dat"); // �ڵ���
			bos = new BufferedOutputStream(fos); // װ����
			dos = new DataOutputStream(bos); // װ����		
			
			dos.writeUTF("a");
			dos.writeInt(20);
			dos.writeInt(180);
			dos.writeUTF("b");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				dos.close(); // �ر����һ���࣬�Ὣ���еĵײ������ر�
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

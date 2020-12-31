package mooc.MOOC1105;//�ļ���ѹ��
import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.util.zip.ZipEntry ;
import java.util.zip.ZipOutputStream ;
import java.io.FileOutputStream ;
public class MultipleFileZip{
	public static void main(String args[]) throws Exception{	// �����쳣�׳�
		File file = new File("c:/temp/multiple") ;	// ����Ҫѹ�����ļ���
		File zipFile = new File("c:/temp/multiple2.zip") ;	// ����ѹ���ļ�����
		
		InputStream input = null ;
		ZipOutputStream zipOut = null ;
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;
		zipOut.setComment("multiple file zip") ;

		int temp = 0 ;
		if(file.isDirectory()){
			File lists[] = file.listFiles() ;
			for(int i=0;i<lists.length;i++){
				input = new FileInputStream(lists[i]) ;
				zipOut.putNextEntry(new ZipEntry(file.getName()
					+File.separator+lists[i].getName())) ;
				System.out.println("dododo" + lists[i].getName());
				while((temp=input.read())!=-1){
					zipOut.write(temp) ;
				}
				input.close() ;
			}
		}
		zipOut.close();
		System.out.println("multiple file zip done.");
	}
}
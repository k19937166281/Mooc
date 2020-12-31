package mooc.MOOC1103;

import java.io.*;

public class TxtFileWrite {
	public static void main(String[] args) {
		writeFile1();
		System.out.println("===================");
		//writeFile2(); // JDK 7�����ϲſ���ʹ��
	}

	public static void writeFile1() {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream("c:/temp/111.txt");
			osw = new OutputStreamWriter(fos, "UTF-8");
			//osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			// br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/temp/abc.txt")))
			bw.write("111111111111111111");
			bw.newLine();
			bw.write("222222222222222222222222");
			bw.newLine();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				bw.close(); // �ر����һ���࣬�Ὣ���еĵײ������ر�
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void writeFile2() {
		//try-resource ��䣬�Զ��ر���Դ
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/temp/abc.txt")))) {
			bw.write("������");
			bw.newLine();
			bw.write("Ecnuers.^^");
			bw.newLine();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

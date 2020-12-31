package mooc.MOOC0805;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterTest {

	public static void main(String[] args) {
		//���ַ���ת��Ϊʱ��
		String dateStr= "2016��10��25��";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy��MM��dd��");
        LocalDate date= LocalDate.parse(dateStr, formatter);
        System.out.println(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
        
        System.out.println("==========================");
        
        //������ת��Ϊ�ַ������
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy��MM��dd�� hh:mm:ss");
        String nowStr = now.format(format);
        System.out.println(nowStr);


	}

}

package mooc.MOOC0805;

import java.text.DecimalFormat;

public class Test{
    public static void main(String[] args){
        double pi=3.1415927;//Բ����
        //ȡһλ���� 
        System.out.println(new DecimalFormat("0").format(pi));//3
        //ȡһλ��������λС��  
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //ȡ��λ��������λС�����������㲿����0���  
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142  
        //ȡ������������  
        System.out.println(new DecimalFormat("#").format(pi));//3  
        //�԰ٷֱȷ�ʽ��������ȡ��λС��  
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%  
        
        long c=299792458;//����  
        //��ʾΪ��ѧ����������ȡ��λС��  
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8  
        //��ʾΪ��λ�����Ŀ�ѧ����������ȡ��λС��  
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7  
        //ÿ��λ�Զ��Ž��зָ���  
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458  
        //����ʽǶ���ı�  
        System.out.println(new DecimalFormat("���ٴ�СΪÿ��,###��").format(c)); //���ٴ�СΪÿ��299,792,458��
    }
}

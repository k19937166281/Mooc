package mooc.MOOC0902;

import java.io.IOException;

public class MyExceptionTest {
	public static void testException() throws MyException {  
       throw new MyException("10001", "The reason of myException");  
         
    }  
	
	public static void main(String[] args) throws Exception {

		MyExceptionTest.testException();
		
//		try {
//			MyExceptionTest.testException();
//		} catch (MyException e) {
//			e.printStackTrace();
//			System.out.println("returnCode:"+e.getReturnCode());
//			System.out.println("returnMsg:"+e.getreturnMsg());
//		}
	}
}
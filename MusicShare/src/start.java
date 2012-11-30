import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class start {
	public static void main(String[] args) {
		Date date = new Date();
//		try { 
//			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2010-12-03 12:12:12");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//    	Date date2 = null;
//    	Date monthS = null;
//    	Date monthE = null;	
//    	String monthStr = null;
//    	
//    	monthStr = sdf.format(date);
//    	
//    	try {
//			date2 = sdf.parse(monthStr);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date2);
//		cal.set(Calendar.DAY_OF_MONTH, 1);
//		monthS = cal.getTime();
//		
//		cal.add(Calendar.MONTH, 1);
//		monthE = cal.getTime();
//		
//		System.out.println(monthS.toString());
//		System.out.println(monthE.toString());
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	
    	date = cal.getTime();
    	System.out.println(date.toString());
	}
}

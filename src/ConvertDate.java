

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConvertDate {

	public ConvertDate() {}
	
	 //Convert date for last entry (stackoverflow https://stackoverflow.com/questions/25458832/how-can-i-convert-an-integer-e-g-19000101-to-java-util-date)
	public String convert(String temp) {
		long i = Long.parseLong(temp)  ;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(i * 1000L));
	}
	
	
}

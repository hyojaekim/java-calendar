package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class planItem {
	public Date plandate;
	public String Detail;
	
	public static Date getDateFromPlan(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public planItem(String date, String detail) {
		this.plandate = getDateFromPlan(date);
		this.Detail = detail;
	}
	
	public Date getDate() {
		return plandate;
	}

}

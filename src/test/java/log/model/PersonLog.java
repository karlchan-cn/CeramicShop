/**
 * 
 */
package log.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author karl
 * 
 */
public class PersonLog {
	private Calendar date;
	private Calendar startWork;
	private Calendar offWork;
	private Integer lateMinutes;
	private Integer offearlyMinutes;
	private Integer workHours;
	private Integer actWorkHours;
	private boolean isLate = false;
	private boolean isOffEarly = false;

	public boolean isLate() {
		return isLate;
	}

	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}

	public boolean isOffEarly() {
		return isOffEarly;
	}

	public void setOffEarly(boolean isOffEarly) {
		this.isOffEarly = isOffEarly;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getStartWork() {
		return startWork;
	}

	public void setStartWork(Calendar startWork) {
		this.startWork = startWork;
	}

	public Calendar getOffWork() {
		return offWork;
	}

	public void setOffWork(Calendar offWork) {
		this.offWork = offWork;
	}

	public Integer getLateMinutes() {
		return lateMinutes;
	}

	public void setLateMinutes(Integer lateMinutes) {
		this.lateMinutes = lateMinutes;
	}

	public Integer getOffearlyMinutes() {
		return offearlyMinutes;
	}

	public void setOffearlyMinutes(Integer offearlyMinutes) {
		this.offearlyMinutes = offearlyMinutes;
	}

	public Integer getWorkHours() {
		return workHours;
	}

	public void setWorkHours(Integer workHours) {
		this.workHours = workHours;
	}

	public Integer getActWorkHours() {
		return actWorkHours;
	}

	public void setActWorkHours(Integer actWorkHours) {
		this.actWorkHours = actWorkHours;
	}

	public String showLog() {
		String CONST_DATE_FORMATE_STR = "yyyy-MM-dd HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				CONST_DATE_FORMATE_STR);
		StringBuffer sb = new StringBuffer();
		sb.append("上班时间: ")
				.append(simpleDateFormat.format(getStartWork().getTime()))
				.append(" 下班时间: ")
				.append(simpleDateFormat.format(getOffWork().getTime()));
		return sb.toString();
	}
}

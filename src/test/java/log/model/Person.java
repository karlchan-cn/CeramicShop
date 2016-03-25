package log.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private String id;
	private String logId;
	private List<PersonLog> personLogs = new ArrayList<PersonLog>();
	private String department;
	private Integer totalLateCount = 0;
	private Integer totallateMinutes = 0;
	private Integer totalLeaveEarlyCount = 0;
	private Integer totalLeaveEarlyMinutes = 0;

	public Integer getTotalLateCount() {
		return totalLateCount;
	}

	public void setTotalLateCount(Integer totalLateCount) {
		this.totalLateCount = totalLateCount;
	}

	public Integer getTotalLeaveEarlyCount() {
		return totalLeaveEarlyCount;
	}

	public void setTotalLeaveEarlyCount(Integer totalLeaveEarlyCount) {
		this.totalLeaveEarlyCount = totalLeaveEarlyCount;
	}

	public Integer getTotalLeaveEarlyMinutes() {
		return totalLeaveEarlyMinutes;
	}

	public void setTotalLeaveEarlyMinutes(Integer totalLeaveEarlyMinutes) {
		this.totalLeaveEarlyMinutes = totalLeaveEarlyMinutes;
	}

	public Integer getTotallateMinutes() {
		return totallateMinutes;
	}

	public void setTotallateMinutes(Integer totallateMinutes) {
		this.totallateMinutes = totallateMinutes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public List<PersonLog> getPersonLogs() {
		return personLogs;
	}

	public void setPersonLogs(List<PersonLog> personLogs) {
		this.personLogs = personLogs;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

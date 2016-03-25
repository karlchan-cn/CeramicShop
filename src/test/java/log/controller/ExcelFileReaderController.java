package log.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import log.model.Person;
import log.model.PersonLog;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReaderController {
	private static int INDEX_ZERO = 0;// 序号
	private static int INDEX_ONE = 1;// log id
	private static int INDEX_TWO = 2;// id
	private static int INDEX_THREE = 3;// name
	private static int INDEX_FOUR = 4;// 日期
	private static int INDEX_FIVE = 5;// 上班时间
	private static int INDEX_SIX = 6;// 下班时间
	private static int INDEX_SEVEN = 7;// 迟到时长
	private static int INDEX_EIGHT = 8;// 早退
	private static int INDEX_NIGHT = 9;// 计划工作时长
	private static int INDEX_TEN = 10;// 部门
	private static int INDEX_ELEVEN = 11;// 总共出勤时间
	private static String CONST_MAIN_DEP = "总公司";
	private static String CONST_SHARE_DEP = "公共部";
	private static String CONST_DATE_FORMATE_STR = "yyyy-MM-dd HH:mm";
	private static String CONST_START_WORK_HOUR = "09:30";
	private static String CONST_OFF_WORK_HOUR = "18:30";
	private static Long CONST_ONE_MINUTE = 60000l;// 一分钟
	private static String CONST_LATE_NOT_HAPPEN = "没有发生迟到";
	private static String CONST_LATE_HAPPEN = "发生迟到";
	private static String CONST_EARLY_NOT_HAPPEN = "没有发生早退";
	private static String CONST_EARLY_HAPPEN = "发生早退";

	public static void main(String[] args) throws Exception {
		InputStream inp = new FileInputStream(
				"/Volumes/Macintosh HD/Users/karl/Downloads/3.24-4.21.xls");
		// InputStream inp = new FileInputStream("workbook.xlsx");
		Map<String, Person> personMap = new LinkedHashMap<String, Person>();
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				CONST_DATE_FORMATE_STR);

		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				continue;
			}
			if (row.getRowNum() == 13399) {
				break;
			}
			String department = row.getCell(INDEX_TEN).getRichStringCellValue()
					.toString().trim();
			String workDateStr = row.getCell(INDEX_FOUR)
					.getRichStringCellValue().toString().trim();
			Calendar workDateCal = Calendar.getInstance();
			workDateCal.setTime(simpleDateFormat.parse(workDateStr + " 01:00"));

			Calendar startWorkHour = Calendar.getInstance();
			startWorkHour.setTime(simpleDateFormat.parse(row
					.getCell(INDEX_FOUR).getRichStringCellValue().toString()
					.trim()
					+ " " + CONST_START_WORK_HOUR));
			Calendar offWorkHour = Calendar.getInstance();
			offWorkHour.setTime(simpleDateFormat.parse(row.getCell(INDEX_FOUR)
					.getRichStringCellValue().toString().trim()
					+ " " + CONST_OFF_WORK_HOUR));

			if (workDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| workDateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				continue;
			}
			// 公共部 或者总部
			if (CONST_MAIN_DEP.equals(department)
					|| CONST_SHARE_DEP.equals(department)) {
				// 上下班时间有一个存在
				if (StringUtils.isNotEmpty(row.getCell(INDEX_FIVE)
						.getRichStringCellValue().toString())
						&& StringUtils.isNotEmpty(row.getCell(INDEX_SIX)
								.getRichStringCellValue().toString())) {
					String id = row.getCell(INDEX_TWO).getRichStringCellValue()
							.toString().trim();
					String name = row.getCell(INDEX_THREE)
							.getRichStringCellValue().toString().trim();
					String logId = row.getCell(INDEX_ONE)
							.getRichStringCellValue().toString().trim();
					String startWorkStr = workDateStr
							+ " "
							+ row.getCell(INDEX_FIVE).getRichStringCellValue()
									.toString().trim();
					String offWorkStr = workDateStr
							+ " "
							+ row.getCell(INDEX_SIX).getRichStringCellValue()
									.toString().trim();
					Calendar startWorkCal = Calendar.getInstance();
					startWorkCal.setTime(simpleDateFormat.parse(startWorkStr));
					Calendar offWorkCal = Calendar.getInstance();
					offWorkCal.setTime(simpleDateFormat.parse(offWorkStr));
					Person person = personMap.get(id);
					if (person == null) {
						person = new Person();
						person.setLogId(logId);
						personMap.put(id, person);
						person.setId(id);
						person.setName(name);
						person.setDepartment(department);
					}
					PersonLog personLog = new PersonLog();
					personLog.setDate(workDateCal);
					personLog.setStartWork(startWorkCal);
					personLog.setOffWork(offWorkCal);
					// 迟到
					if (startWorkCal.after(startWorkHour)) {
						person.setTotalLateCount(person.getTotalLateCount() + 1);
						Integer lateMintes = Integer
								.valueOf(String.valueOf((startWorkCal
										.getTimeInMillis() - startWorkHour
										.getTimeInMillis())
										/ CONST_ONE_MINUTE));
						person.setTotallateMinutes(person.getTotallateMinutes()
								+ lateMintes);
						personLog.setLate(true);
					}
					// 早退
					if (offWorkCal.before(offWorkHour)) {
						personLog.setOffEarly(true);
						person.setTotalLeaveEarlyCount(person
								.getTotalLeaveEarlyCount() + 1);
						Integer earlyLeaveMintes = Integer
								.valueOf(String.valueOf((offWorkHour
										.getTimeInMillis() - offWorkCal
										.getTimeInMillis())
										/ CONST_ONE_MINUTE));
						person.setTotalLeaveEarlyMinutes(person
								.getTotalLeaveEarlyMinutes() + earlyLeaveMintes);
					}
					person.getPersonLogs().add(personLog);
				}
			}
		}
		InputStream inp_out = new FileInputStream(
				"/Volumes/Macintosh HD/Users/karl/Downloads/workbook_log.xls");
		Workbook wb_out = WorkbookFactory.create(inp_out);
		Sheet sheet_out = wb_out.getSheetAt(0);
		Integer rowNum = 0;
		Set<String> keySets = personMap.keySet();
		Person person = null;
		for (String key : keySets) {
			rowNum++;
			person = personMap.get(key);
			Row row = sheet_out.getRow(rowNum);
			String isLate = CONST_LATE_NOT_HAPPEN;
			if (person.getTotalLateCount() > 0) {
				isLate = CONST_LATE_HAPPEN;
			}
			String hasEarly = CONST_EARLY_NOT_HAPPEN;
			if (person.getTotalLeaveEarlyCount() > 0) {
				hasEarly = CONST_EARLY_HAPPEN;
			}
			StringBuffer logSb = new StringBuffer();
			setCellValue(row, 0, person.getLogId());
			setCellValue(row, 1, person.getId());
			setCellValue(row, 2, person.getName());
			setCellValue(row, 3, isLate);
			setCellValue(row, 4, "迟到次数:" + person.getTotalLateCount());
			setCellValue(row, 5, "迟到分钟:" + person.getTotallateMinutes());
			setCellValue(row, 6, hasEarly);
			setCellValue(row, 7, "早退次数:" + person.getTotalLeaveEarlyCount());
			setCellValue(row, 8, "早退分钟:" + person.getTotalLeaveEarlyMinutes());
			setCellValue(row, 9, person.getDepartment());
			for (PersonLog personLog : person.getPersonLogs()) {
				if (personLog.isLate() || personLog.isOffEarly()) {
					logSb.append(personLog.showLog()).append("\n");
				}
			}
			setCellValue(row, 10, logSb.toString());

		}
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(
				"/Volumes/Macintosh HD/Users/karl/Downloads/workbook_log.xls");
		wb_out.write(fileOut);
		fileOut.close();
		// Write the output to a file
		// FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		// wb.write(fileOut);
		// fileOut.close();
	}

	private static void setCellValue(Row row, Integer cellIdx, String value) {
		Cell cell = row.getCell(cellIdx);
		if (cell == null)
			cell = row.createCell(cellIdx);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
	}
}

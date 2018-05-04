package com.example.websocket.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtils {
	private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
//	public static void main(String[] args) {
//		// ExcelUtils.ConvertXlsToCSV("data\\d1\\D1_tc3");
//		try {
//			ExcelUtils.importData("data\\d1\\D1_tc3");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EncryptedDocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@SuppressWarnings("deprecation")
	private static void convertXlsToCSV(String filePath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\" + filePath + ".xls"));
		Sheet sheet = wb.getSheetAt(0);
		FormulaEvaluator eval = wb.getCreationHelper().createFormulaEvaluator();
		String cellValue = "";
		String buffer = "";
		int cols = sheet.getRow(1).getLastCellNum();
		int rows = sheet.getLastRowNum();
//		System.out.println(cols);
//		System.out.println(rows);
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				Cell c = sheet.getRow(i).getCell(j);
				if (c == null) {
					c = sheet.getRow(i).createCell(j);
					c.setCellType(Cell.CELL_TYPE_STRING);
					c.setCellValue("");
				}
				switch (c.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					cellValue = c.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					cellValue = c.getStringCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					cellValue = Double.toString(c.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					eval.evaluateFormulaCell(c);
					c.setCellType(Cell.CELL_TYPE_STRING);
					try {
						cellValue = Double.toString(c.getNumericCellValue());
					} catch (IllegalStateException e) {
						cellValue = c.getRichStringCellValue().toString();
					}
					break;
				case Cell.CELL_TYPE_ERROR:
					break;
				}
				buffer += cellValue + ",";

			}
			buffer = buffer.substring(0, buffer.lastIndexOf(",")).toString();
			buffer += "\n";
		}
		File csvFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filePath + ".csv");
		try {
			if (!csvFile.exists())
				csvFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
			writer.write(buffer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importData(String filePath) throws ClassNotFoundException, SQLException, EncryptedDocumentException, InvalidFormatException, IOException {
		convertXlsToCSV(filePath);
		String csvFilePath = System.getProperty("user.dir")+ "\\src\\test\\resources\\" + filePath
				+ ".csv";
		String sql = "LOAD DATA LOCAL INFILE '" + csvFilePath.replace("\\", "/")
				+ "' IGNORE INTO TABLE ofg_flight CHARACTER SET utf8 FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n'";
		
		QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
		int deleleCount=qr.update("delete from ofg_flight");
		int num = qr.update(sql);
		
//		logger.info("删除"+num+"条数据");
//		logger.info("导入 " + num + " 条数据！");
		if(num>0) {
			logger.info("成功导入"+num+"条测试数据");
		}
		qr=null;
	}

}

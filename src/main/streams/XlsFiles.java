package main.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import main.projects.miniprojects.queue.classes.Contact;

public class XlsFiles {

	public static void main(String[] args) throws IOException {
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/test.xls");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		System.out.println("---------- Criando ---------- ");
		createXls(file);
		readXls(file);
		System.out.println("---------- Editando ---------- ");
		editXls(file);
		readXls(file);
	}
	
	public static void createXls(File file) throws IOException {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Rodrigo", "rodrigo@gmail.com"));
		contacts.add(new Contact("Erick", "erick@gmail.com"));
		contacts.add(new Contact("Maria", "maria@gmail.com"));
		contacts.add(new Contact("Fernanda", "fernanda@gmail.com"));
		
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet = workbook.createSheet("Teste Excel");
		
		int currentRow = 0;
		
		// Criar Cabecalho
		HSSFRow titleRow = sheet.createRow(currentRow++);
		
		HSSFCell cellTitleName = titleRow.createCell(0);
		cellTitleName.setCellValue("Nome");
		
		HSSFCell cellTitleEmail = titleRow.createCell(1);
		cellTitleEmail.setCellValue("Email");
		
		for (Contact contact : contacts) {
			// Criar Corpo da Tabela
			HSSFRow row = sheet.createRow(currentRow++);
			
			int currentCell = 0;
			
			HSSFCell cellName = row.createCell(currentCell++);
			cellName.setCellValue(contact.getName());
			
			HSSFCell cellEmail = row.createCell(currentCell++);
			cellEmail.setCellValue(contact.getEmail());
		}
		
		OutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		workbook.close();
	}
	
	public static void readXls(File file) throws IOException {
		ArrayList<String> xlsData = new ArrayList<String>();
		
		InputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		rowIterator.next(); // Remover Cabecalho
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.iterator();
			
			String rowContent = "";
			while (cellIterator.hasNext()) {
				rowContent = rowContent.isEmpty()
					? cellIterator.next().getStringCellValue()
					: rowContent + ", " + cellIterator.next().getStringCellValue();
			}
			xlsData.add(rowContent);
		}
		
		xlsData.forEach((data) -> System.out.println(data));
	}
	
	public static void editXls(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		Row rowHeader = rowIterator.next();
		Cell newHeader = rowHeader.createCell(rowHeader.getPhysicalNumberOfCells());
		newHeader.setCellValue("Idade");
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell newCell = row.createCell(row.getPhysicalNumberOfCells());
			newCell.setCellValue(Double.valueOf(Math.floor(Math.random() * (50 - 18 + 1) + 18)).toString());
		}
		OutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
	}
}

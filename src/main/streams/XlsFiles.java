package main.streams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import main.projects.miniprojects.queue.classes.Contact;

public class XlsFiles {

	public static void main(String[] args) throws IOException {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Rodrigo", "rodrigo@gmail.com"));
		contacts.add(new Contact("Erick", "erick@gmail.com"));
		contacts.add(new Contact("Maria", "maria@gmail.com"));

		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/test.xls");

		if (!file.exists()) {
			file.createNewFile();
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet = workbook.createSheet("Teste Excel");
		
		int currentRow = 0;
		int cell = 0;
		
		// Criar Headers
		HSSFRow titleRow = sheet.createRow(currentRow++);
		
		HSSFCell cellTitleName = titleRow.createCell(cell++);
		cellTitleName.setCellValue("Nome");
		
		HSSFCell cellTitleEmail = titleRow.createCell(cell++);
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

}

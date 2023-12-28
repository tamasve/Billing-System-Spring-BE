package com.billingsystem.repository;

import com.billingsystem.entity.Category;
import com.billingsystem.entity.Customer;
import com.billingsystem.entity.Product;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

// == DATA LOADER TO DB FROM EXCEL FILES ==

@Component
public class DataInjector implements CommandLineRunner {
	
	public Logger log = LoggerFactory.getLogger(this.getClass());
	
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	private CustomerRepository customerRepository;
	@Autowired
	public DataInjector(CategoryRepository categoryRepository,
						ProductRepository productRepository,
						CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("CommandLineRunner -- Data Injector starts >>");

		log.info("CommandLineRunner -- Categories... >>");

		if (categoryRepository.findAll().isEmpty()) {
			String fileLocation = "categories.xlsx";

			Workbook workbook = new XSSFWorkbook(new FileInputStream(fileLocation));
			Sheet sheet = workbook.getSheet("categories");

			for (Row row : sheet) {
				log.info(">> data row of " + row.getCell(0).getStringCellValue());
				if (row.getRowNum() != 0) {
					categoryRepository.save(
							new Category(
									row.getCell(0).getStringCellValue()
							)
					);
				}
			}
		}

		log.info("CommandLineRunner -- Products... >>");

		if (productRepository.findAll().isEmpty()) {
			String fileLocation = "products.xlsx";

			Workbook workbook = new XSSFWorkbook(new FileInputStream(fileLocation));
			Sheet sheet = workbook.getSheet("products");

			for (Row row : sheet) {
				log.info(">> data row of " + row.getCell(0).getStringCellValue());
				if (row.getRowNum() != 0) {
					Long id = Double.valueOf( row.getCell(3).getNumericCellValue() ).longValue();
					try {
						productRepository.save(
							new Product(
									row.getCell(0).getStringCellValue(),
									row.getCell(1).getStringCellValue(),
									row.getCell(2).getNumericCellValue(),
									categoryRepository.findById( id ).orElseThrow()
									));
					} catch (Exception e) {
						log.error("Inserting row " + String.valueOf(row.getRowNum()) + " into DB failed");
					}
				}
			}
		}

		log.info("CommandLineRunner -- Customers... >>");

		if (customerRepository.findAll().isEmpty()) {
			String fileLocation = "customers.xlsx";

			Workbook workbook = new XSSFWorkbook(new FileInputStream(fileLocation));
			Sheet sheet = workbook.getSheet("customers");

			for (Row row : sheet) {
				log.info(">> data row of " + row.getCell(0).getStringCellValue());
				if (row.getRowNum() != 0) {
					customerRepository.save(
							new Customer(
									row.getCell(0).getStringCellValue(),
									row.getCell(1).getStringCellValue(),
									row.getCell(2).getStringCellValue()
							)
					);
				}
			}
		}
		
		
//		// The mere printing of Excel data - as a TEST of it working well
//		for (Row row : sheet) {
//			if (row.getRowNum() == 0) {
//				log.info("-- Header --");
//				log.info(row.toString());
//			} else {
//				for (Cell cell : row) {
//					if (cell.getCellType() == CellType.STRING)
//						log.info(String.valueOf(cell.getColumnIndex())+" - "+cell.getStringCellValue());
//					if (cell.getCellType() == CellType.NUMERIC)
//						log.info(String.valueOf(cell.getColumnIndex())+" - "+String.valueOf((int) cell.getNumericCellValue()));
//				}
//			}
//		}
		
		log.info("CommandLineRunner -- Data Injector ends <<");
	}

}

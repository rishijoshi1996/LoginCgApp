package com.cgapp.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;
import com.cgapp.exception.EmployeeNotFoundException;

/**
 * 
 * @author risjoshi
 *
 */
@Service("empservice")
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;

	// Create new Employee
	public List<Employees> createEmployees(List<Employees> employee) {

		for (Employees e : employee) {
			e.setManager(emprepo.findOne(e.getManager().getEmpId()));
		}
		return emprepo.save(employee);
	}

	// Fetch All Employees
	public List<Employees> getEmployees() throws EmployeeNotFoundException {
		return emprepo.findAll();
	}

	public Employees findEmp(int id) {
		return emprepo.findOne(id);
	}

	public String deleteAll() {
		emprepo.deleteAll();
		return "Deleted all";
	}

	public String deleteOne(int empId) {
		emprepo.delete(empId);
		return "Deleted one";
	}

	private final Path rootLocation = Paths.get("upload-dir1");

//////////////////////////////////////////////////////////////////////////////////////////
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("FAIL!");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////
	public void deleteExcelData() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

//////////////////////////////////////////////////////////////////////////////////////////
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////
	public List<Employees> readExcelData(String originalFilename) {

		List<Employees> employeeList = new ArrayList<>();
		FileInputStream inputStream = null;
		Workbook workbook = null;

		try {
			inputStream = new FileInputStream("./upload-dir1/" + originalFilename);

			if (originalFilename.toLowerCase().endsWith("xlsx"))
				workbook = new XSSFWorkbook(inputStream);
			else if (originalFilename.toLowerCase().endsWith("xls"))
				workbook = new HSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					Employees employee = new Employees();
					employee.setEmpId(Integer.parseInt(dataFormatter.formatCellValue(row.getCell(0))));
					employee.setEmpName(dataFormatter.formatCellValue(row.getCell(1)));
					employee.setEmpUserName(dataFormatter.formatCellValue(row.getCell(2)));
					employee.setEmpPassword(dataFormatter.formatCellValue(row.getCell(0)));
					employee.setEmpEmail(dataFormatter.formatCellValue(row.getCell(3)));
					employee.setEmpContact("NA");
					employee.setEmpJobTitle(dataFormatter.formatCellValue(row.getCell(4)));
					employee.setEmpPosition(dataFormatter.formatCellValue(row.getCell(5)));
					employee.setEmpLocation("NA");
					employee.setEmpDepartment(dataFormatter.formatCellValue(row.getCell(14)));
					emprepo.save(employee);
				}
			}

			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					Employees employee = emprepo
							.findOne(Integer.parseInt(dataFormatter.formatCellValue(row.getCell(0))));

					Employees manager = emprepo
							.findOne(Integer.parseInt(dataFormatter.formatCellValue(row.getCell(44))));

					if (manager != null) {
						employee.setManager(manager);
						emprepo.save(employee);
					}
					employeeList.add(employee);
				}
			}

			inputStream.close();
			workbook.close();
			return employeeList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

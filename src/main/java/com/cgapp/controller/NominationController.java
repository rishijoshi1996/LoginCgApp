package com.cgapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Employees;
import com.cgapp.entity.Nomination;
import com.cgapp.service.NominationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class NominationController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private NominationService nominationservice;

	@PostMapping(path = "/nominations", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Nomination> createNominee(@RequestBody Nomination nomination) {
		nominationservice.createNomination(nomination);
		logger.info("Nomination details added");
		return new ResponseEntity<Nomination>(nomination, HttpStatus.CREATED);
	}

	@GetMapping(path = "/nominations", produces = "application/json")
	public List<Nomination> getNomination() {
		logger.info("Succesfull");
		return nominationservice.getNomination();
	}

	@GetMapping(path = "/nominations/{empId}", produces = "application/json")
	public ResponseEntity<List<Nomination>> getNominationByEmpId(@PathVariable("empId") int empId) {
		List<Nomination> noms = nominationservice.getNominationByEmpId(empId);
		logger.info("Succesfull");
		return new ResponseEntity<List<Nomination>>(noms, HttpStatus.OK);
	}

	@GetMapping(path = "/nominations/manager/{empId}", produces = "application/json")
	public ResponseEntity<List<Nomination>> getNominationOfEmployees(@PathVariable("empId") int empId) {
		List<Nomination> noms = nominationservice.getNominationOfEmployees(empId);
		logger.info("Succesfull");
		return new ResponseEntity<List<Nomination>>(noms, HttpStatus.OK);
	}

	@PutMapping(path = "/nominations/status/{nomId}/{status}", produces = "application/json")
	public ResponseEntity<String> changeEmployeeStatus(@PathVariable("nomId") int nomId,
			@PathVariable("status") String status) {
		String result = nominationservice.changeStatus(nomId, status);
		return new ResponseEntity<String>("{ \"status\" : \"" + result + "\" }", HttpStatus.OK);
	}

	@GetMapping(path = "nominations/manager/{empId}/excel")
	public ResponseEntity<InputStreamResource> getNominationOfEmp(@PathVariable("empId") int empId) {
		List<Nomination> nomination = nominationservice.getNomEmployees(empId);

		// file write
		Workbook workbook = new HSSFWorkbook();

		try {
			OutputStream fileOut = new FileOutputStream("C:\\Users\\risjoshi\\Desktop\\Excel\\Manager.xls");

			Sheet sheet = workbook.createSheet("First Sheet");

			for (int i = 1; i <= nomination.size(); i++) {
				Row row = sheet.createRow(i);
				Cell[] cell = new Cell[10];

				for (int cellIdx = 0; cellIdx < cell.length; cellIdx++) {
					cell[cellIdx] = row.createCell(cellIdx);
				}

				cell[0].setCellValue(nomination.get(i - 1).getNominationId());
				cell[1].setCellValue(nomination.get(i - 1).getStatus());
				cell[2].setCellValue(nomination.get(i - 1).getEmployees().getEmpId());
				cell[3].setCellValue(nomination.get(i - 1).getEmployees().getEmpName());
				cell[4].setCellValue(nomination.get(i - 1).getTrainingcatalog().getTrainingName());
			}

			workbook.write(fileOut);
			// System.out.println("File created");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		File file = new File("C:\\\\Users\\\\risjoshi\\\\Desktop\\\\Excel\\\\Manager.xls");
		InputStreamResource resource = null;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return new ResponseEntity<List<Nomination>>(nomination, HttpStatus.OK);
		Employees emp = nomination.get(0).getEmployees();
		String fn = emp.getManager().getEmpId() + "_" + emp.getManager().getEmpName() + ".xls";
		logger.info("Excel File Downloaded");

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=" + fn)
				.contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	@DeleteMapping(path = "/nominations")
	public String deleteAll() {
		return nominationservice.deleteAll();
	}

	@DeleteMapping(path = "/nominations/{nid}")
	public String deleteOne(@PathVariable("nid") int id) {
		return nominationservice.deleteOne(id);
	}

}

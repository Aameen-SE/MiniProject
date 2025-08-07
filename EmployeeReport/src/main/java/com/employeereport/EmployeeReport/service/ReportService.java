package com.employeereport.EmployeeReport.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.employeereport.EmployeeReport.model.Employee;
import com.employeereport.EmployeeReport.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
		
	String path = "D:\\Generated JasperReport";
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		List<Employee> employee = employeeRepository.findAll();
		
		File file = ResourceUtils.getFile("classpath:employee.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employee);
		Map<String,Object> parameter = new HashMap<>();
		parameter.put("createdBy", "Aameen");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\employee.html");
		}
		
if(reportFormat.equalsIgnoreCase("pdf")) {
	JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employee.pdf");

		}
		return "report generated successfully path : "+path;
	}
	
}

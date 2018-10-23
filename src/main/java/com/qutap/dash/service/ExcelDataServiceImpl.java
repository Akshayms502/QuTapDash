package com.qutap.dash.service;




import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.commonUtils.StatusCode;
import com.qutap.dash.config.ReadQutapProperties;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.domain.TestExecutionDomain;
import com.qutap.dash.domain.TestScenarioDomain;
import com.qutap.dash.domain.TestStepDomain;
import com.qutap.dash.model.TestCaseModel;
import com.qutap.dash.model.TestStepModel;
import com.qutap.dash.repository.ExcelDataDao;
import com.qutap.dash.repository.RequirementDao;
import com.qutap.dash.repository.RequirementDaoImpl;
import com.qutap.dash.repository.TestScenarioDao;

@Service
public class ExcelDataServiceImpl implements ExcelDataService{
	
Logger log= LoggerFactory.getLogger(ExcelDataServiceImpl.class);
	
	@Autowired
	ExcelDataDao excelDataDao;
	
	@Autowired
	ReadQutapProperties readProperties;
	
	@Autowired
	TestScenarioDao testScenarioDao;

	Response response=new Response();

	@Override
	public Response readExcelData(MultipartFile multipartFile) {		
		try {
			try {
				if (readProperties.getExcelPath() != null && !"".equals(readProperties.getExcelPath().trim())) {
					File dirFileObj = FileUtils.getFile(readProperties.getExcelPath());
					if (!dirFileObj.exists()) {
						FileUtils.forceMkdir(dirFileObj);
					}
					byte[] bytes = multipartFile.getBytes();
					Path path = Paths.get(readProperties.getExcelPath() + "/" + multipartFile.getOriginalFilename());
					Files.write(path, bytes);
				}
			} catch (IOException ex) {
				response.setErrors(ex.getMessage());
			}

			Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
			int numberOfSheets = workbook.getNumberOfSheets();
			String testCaseValue;
			TestCaseDomain testCaseDomain = new TestCaseDomain();
			Row row;
			TestStepDomain testStepDomain;
			DataFormatter dataFormatter = new DataFormatter();
			List<TestCaseDomain> testCaseDomainList = new ArrayList<>();

			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();
					int rownum = row.getRowNum();
					if (rownum >= 6) {
						if (!((dataFormatter.formatCellValue(row.getCell(0)).isEmpty()))) {
							testCaseDomain = new TestCaseDomain();
							testCaseDomain.setTestCaseId(dataFormatter.formatCellValue(row.getCell(2)));
							testCaseDomain.setTestCaseName(dataFormatter.formatCellValue(row.getCell(3)));
							testCaseDomain.setTestCaseCategory(dataFormatter.formatCellValue(row.getCell(4)));
							testCaseDomain.setTestCasePriority(dataFormatter.formatCellValue(row.getCell(5)));
							testCaseDomain.setTestCaseTag(dataFormatter.formatCellValue(row.getCell(6)));
							testCaseDomain.setTestCaseDesciption(dataFormatter.formatCellValue(row.getCell(7)));
							testCaseDomain.setPositiveOrNegative(dataFormatter.formatCellValue(row.getCell(8)));
							testCaseDomain.setTestStepList(new ArrayList<>());
							testCaseDomainList.add(testCaseDomain);

							while (rowIterator.hasNext()) {
								row = rowIterator.next();

								if (dataFormatter.formatCellValue(row.getCell(10)).equals(StatusCode.TEST_CASE_END)) {
									break;
								}
								testStepDomain = new TestStepDomain();
								testStepDomain.setTestStepsId(new ObjectId().toString());
								testStepDomain.setRunnerType(dataFormatter.formatCellValue(row.getCell(9)));
								testStepDomain.setAction(dataFormatter.formatCellValue(row.getCell(11)));
								testStepDomain.setExcecuteOrSkip(dataFormatter.formatCellValue(row.getCell(12)));
								testStepDomain.setDependency(dataFormatter.formatCellValue(row.getCell(14)));
								testStepDomain.setParamGroupObject(dataFormatter.formatCellValue(row.getCell(15)));
								testStepDomain.setExpectedResult(dataFormatter.formatCellValue(row.getCell(17)));
								testStepDomain.setActualResult(dataFormatter.formatCellValue(row.getCell(18)));
								testStepDomain.setParamGroupId(dataFormatter.formatCellValue(row.getCell(19)));
								testCaseValue = dataFormatter.formatCellValue(row.getCell(16));
								List<String> testParamData = new ArrayList<String>();
								if (testCaseValue.equals("")) {
									testStepDomain.setTestParamData(testParamData);
								} else {
									for (String eachValue : testCaseValue.split(",")) {
										testParamData.add(eachValue);
									}
									testStepDomain.setTestParamData(testParamData);
								}
								testCaseDomain.getTestStepList().add(testStepDomain);
							}

						}
					}

				}
				for (TestCaseDomain testCaseDomainVal : testCaseDomainList) {
					response = excelDataDao.saveExcelData(testCaseDomainVal);
				}
			}
		} catch (Exception e) {
			response.setErrors(e.getMessage());
		}
		return response;
	}
	
	

	@Override
	public TestCaseModel getTestCaseData(String testCaseId) {
		try {
			TestCaseModel testCaseModel = new TestCaseModel();
			TestCaseDomain testCaseDomain = excelDataDao.getTestCaseData(testCaseId);
			BeanUtils.copyProperties(testCaseDomain, testCaseModel);
			return testCaseModel;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}


	
	
	
}
		

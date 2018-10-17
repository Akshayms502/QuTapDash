package com.qutap.dash.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.qutap.dash.commonUtils.Response;

public interface ExcelDataService {

	Response readExcelData(MultipartFile multipartFile) throws IOException;

}

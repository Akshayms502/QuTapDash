package com.qutap.dash.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qutap.dash.commonUtils.Response;
import com.qutap.dash.config.ReadQutapProperties;
import com.qutap.dash.config.TestTransport;
import com.qutap.dash.domain.TestCaseDomain;
import com.qutap.dash.repository.ExcelDataDao;
import com.qutap.dash.repository.ExecutionDao;

@Service
public class ExecutionServiceImpl implements ExecutionService{
	
	Logger log = LoggerFactory.getLogger(ExecutionServiceImpl.class);

	

	@Autowired
	ExcelDataDao  excelDataDao;
	
	@Autowired
	ReadQutapProperties readQutapProperties;
	
	

	@Override
	public Response executeData(String testCaseId) {
		JSONObject resJSON = null;
		JSONObject json = null;
		try {
			
			TestCaseDomain testCaseDomain=excelDataDao.getTestCaseData(testCaseId);
			json=new JSONObject(testCaseDomain);
			resJSON = TestTransport
					.postRequestExec(readQutapProperties.getExcecutionPath(), json);
			System.out.println(resJSON);
	/*		JSONObject resJSONFromServer = new JSONObject();

			resJSONFromServer.put("runner", testCaseDomain.getRunnerType());
			resJSONFromServer.put("testCaseId", testCaseDomain.getTestCaseId());

			JSONObject jsonMainArr = resJSON.getJSONObject("testCase");
			JSONArray jsonSubArr = jsonMainArr.getJSONArray("testStepList");

			

			for (int k = 0; k < jsonSubArr.length(); k++) {
				JSONObject childJSONObject = jsonSubArr.getJSONObject(k);
                int result;
				String status = childJSONObject.getString("status");
				String error = childJSONObject.getString("error");
				Object response = childJSONObject.get("response");
				
				if(status.equalsIgnoreCase("pass"))
				{
					result=1;
				}
				else
				{
					result=0;
				}

				resJSONFromServer.put("error", error.trim());
				resJSONFromServer.put("testStepId", k);
				resJSONFromServer.put("status",result);
				resJSONFromServer.put("response",response.toString());  

		//		executionDao.saveExecutionData(resJSONFromServer);
			}  */

		}catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		}

	/*	if (resJSON.getString("status").equals("FAIL")) {

			JSONObject JsonObject = (JSONObject) json.get("payload");

			if (JsonObject.getString("dependency").equals("Y")) {
				try {
					throw new TestFeedInitException("cant send next test case because of dependency", null);
				} catch (TestFeedInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		}  */
		return null;
		
	}

}

package org.eql.TheProject_2G3;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestStepResult;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

import org.junit.Test;




public class AppTest 
{
	private final String soapProject = "src/test/resources/v1_SOAP-Logicaldoc-soapui-project.xml";
	private final Logger LOGGER = Logger.getLogger(AppTest.class.getName());

	@Test
	public void testIntermediaire()
	        throws XmlException, IOException, SoapUIException {
		
	    // Creer une nouvelle instance de WsdlProject en specifiant le chemin absolu du projet SoapUI
	    WsdlProject project = new WsdlProject(soapProject);
	    // Recupere tous les TestSuites inclus dans le projet SoapUI
	     
		
	    List<TestSuite> testSuiteList = project.getTestSuiteList();
	    // Iteration sur tous les TestSuites du projet
	    for (TestSuite ts : testSuiteList) {
	        LOGGER.info("******Running " + ts.getName() + "***********");
	        // Recupere tous les TestCases d'une TestSuite
	        List<TestCase> testCaseList = ts.getTestCaseList();
	        // Iteration sur tous les TestCases d'un TestSuite particulier
	        for (TestCase testcase : testCaseList) {
	            LOGGER.info("******Running " + testcase.getName() + "***********");
	            // Execute le TestCase specifie
	            TestCaseRunner testCaseRunner = testcase.run(new PropertiesMap(), false);
	            // Verifie si le TestCase s'est termine correctement
	            // ou s'il a echoue a cause d'un echec d'assertion
	            //assertEquals(TestRunner.Status.FINISHED, testCaseRunner.getStatus());
	            List<TestStepResult> resultats = testCaseRunner.getResults();
	            String log = "\n";
	            for(TestStepResult tsr : resultats) {
	            	log += tsr.getTestStep().getName() + " = "+tsr.getStatus()+"  en : "+tsr.getTimeTaken() +" ms"+ "\n";
	            }
            	LOGGER.info(log);
	        }
	    }
	}
    
}

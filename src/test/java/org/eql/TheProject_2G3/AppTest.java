package org.eql.TheProject_2G3;

import org.apache.log4j.Logger;

import com.eviware.soapui.tools.SoapUITestCaseRunner;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	@Test
	public void test() throws Exception {
	    SoapUITestCaseRunner testCaseRunner = new SoapUITestCaseRunner();
	    testCaseRunner.setProjectFile("src/test/ressources/REST-Simpleplan-soapui-project.xml");
	    try {
	        testCaseRunner.run();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    
}

package TestCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.fileUtility.ReadFromExcelFile;
import com.crm.javaUtility.GenerateRandomNumbers;
import com.crm.pom.HomePage;
import com.crm.pom.Organization;

public class OraganizationTestCase extends VtigerBase{
@Test
public void testCase1() throws EncryptedDocumentException, IOException, InterruptedException {
	HomePage hp=new HomePage(driver);
	assertTrue(hp.home().isDisplayed(),"iam not in Vtiger Home Page");
	Reporter.log("iam in vtiger home page");
	hp.organization();
	Organization org=new Organization(driver);
	org.plusOrg();
	String org_name = ReadFromExcelFile.readexcel("Organization", 0, 0);
	int dynamicNumbers = GenerateRandomNumbers.random();
	String expected_org=org_name+dynamicNumbers;
	org.accountName(org_name+dynamicNumbers);
	org.save();
	String actual_Org = org.header().getText();
	assertTrue(actual_Org.contains(expected_org));
	Thread.sleep(4000);
}
}

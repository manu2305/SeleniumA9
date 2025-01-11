package TestCase;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;

public class PracticeExecution extends VtigerBase {
@Test
public void main() throws InterruptedException {
	Reporter.log("iam a Practice TestCase1");
	Thread.sleep(3000);
}
}

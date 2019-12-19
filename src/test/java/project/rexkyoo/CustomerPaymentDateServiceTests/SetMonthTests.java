package project.rexkyoo.CustomerPaymentDateServiceTests;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class SetMonthTests
{
    enum TestType
    {
        SUCCESSFUL,
        FAILING
    }
    private TestType testType;
    CustomerPaymentDateModel customerPaymentDates;
    String expectedResult;

    public SetMonthTests(TestType testType, CustomerPaymentDateModel customerPaymentDates, String expectedResult)
    {
        this.testType = testType;
        this.customerPaymentDates = customerPaymentDates;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name= "{index} should be: {1}")
    public static Iterable<Object[]> validPaymentDatesData() {
        return Arrays.asList(new Object[][]
                {
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-01-12", new CustomerModel()),
                            "JAN"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-02-12", new CustomerModel()),
                            "FEB"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-03-12", new CustomerModel()),
                            "MAR"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-04-12", new CustomerModel()),
                            "APR"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-05-12", new CustomerModel()),
                            "MAY"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-06-12", new CustomerModel()),
                            "JUN"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-07-12", new CustomerModel()),
                            "JUL"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-08-12", new CustomerModel()),
                            "AUG"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-09-12", new CustomerModel()),
                            "SEP"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-10-12", new CustomerModel()),
                            "OCT"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-11-12", new CustomerModel()),
                            "NOV"},
                    {TestType.SUCCESSFUL, new CustomerPaymentDateModel
                            ("Afventer betaling", "2019-12-12", new CustomerModel()),
                            "DEC"}
                }
        );
    }

    @Test
    public void validCalendarYear_Succeeds()
    {
        // Arrange
        Assume.assumeTrue(testType == TestType.SUCCESSFUL);
        CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

        // Act
        customerPaymentDateService.setMonth(customerPaymentDates);

        // Assert
        assertEquals(expectedResult, customerPaymentDates.getMonth());
    }

    @Parameterized.Parameters(name= "{index} should be: {2}")
    public static Iterable<Object[]> invalidPaymentDatesData() {
        return Arrays.asList(new Object[][]
                {
                        {TestType.FAILING, new CustomerPaymentDateModel
                                ("Afventer betaling", "Invalid Data", new CustomerModel()),
                                "NOT FOUND"},
                        {TestType.FAILING, new CustomerPaymentDateModel
                                ("Afventer betaling", "", new CustomerModel()),
                                "NOT FOUND"},
                        {TestType.FAILING, new CustomerPaymentDateModel
                                ("Afventer betaling", "2s19-e4-4r", new CustomerModel()),
                                "NOT FOUND"},
                }
        );
    }

    @Test
    public void invalidData_MonthIsNotFound()
    {
        // Arrange
        Assume.assumeTrue(testType == TestType.FAILING);
        CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

        // Act
        customerPaymentDateService.setMonth(customerPaymentDates);

        // Assert
        assertEquals(expectedResult, customerPaymentDates.getMonth());
    }
}

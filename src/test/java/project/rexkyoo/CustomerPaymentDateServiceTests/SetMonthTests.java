package project.rexkyoo.CustomerPaymentDateServiceTests;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class SetMonthTests
{

    @RunWith(Parameterized.class)
    public static class ValidPaymentDates
    {
        private CustomerPaymentDateModel customerPaymentDates;
        private String expectedResult;

        public ValidPaymentDates(CustomerPaymentDateModel customerPaymentDates, String expectedResult)
        {
            this.customerPaymentDates = customerPaymentDates;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters(name= "{index} should be: {1}")
        public static Iterable<Object[]> validPaymentDatesData() {
            return Arrays.asList(new Object[][]
                    {
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-01-12", new CustomerModel()),
                                    "JAN"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-02-12", new CustomerModel()),
                                    "FEB"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-03-12", new CustomerModel()),
                                    "MAR"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-04-12", new CustomerModel()),
                                    "APR"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-05-12", new CustomerModel()),
                                    "MAY"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-06-12", new CustomerModel()),
                                    "JUN"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-07-12", new CustomerModel()),
                                    "JUL"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-08-12", new CustomerModel()),
                                    "AUG"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-09-12", new CustomerModel()),
                                    "SEP"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-10-12", new CustomerModel()),
                                    "OCT"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-11-12", new CustomerModel()),
                                    "NOV"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-12-12", new CustomerModel()),
                                    "DEC"}
                    }
            );
        }

        @Test
        public void validCalendarYear_Succeeds()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

            // Act
            customerPaymentDateService.setMonth(customerPaymentDates);

            // Assert
            assertEquals(expectedResult, customerPaymentDates.getMonth());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvalidPaymentDates
    {

        private CustomerPaymentDateModel customerPaymentDates;
        private String expectedResult;

        public InvalidPaymentDates(CustomerPaymentDateModel customerPaymentDates, String expectedResult)
        {
            this.customerPaymentDates = customerPaymentDates;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters(name= "{index} should be: {2}")
        public static Iterable<Object[]> invalidPaymentDatesData() {
            return Arrays.asList(new Object[][]
                    {
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "Invalid Data", new CustomerModel()),
                                    "NOT FOUND"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "", new CustomerModel()),
                                    "NOT FOUND"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2s19-e4-4r", new CustomerModel()),
                                    "NOT FOUND"},
                    }
            );
        }

        @Test
        public void invalidData_MonthIsNotFound()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

            // Act
            customerPaymentDateService.setMonth(customerPaymentDates);

            // Assert
            assertEquals(expectedResult, customerPaymentDates.getMonth());
        }
    }


}

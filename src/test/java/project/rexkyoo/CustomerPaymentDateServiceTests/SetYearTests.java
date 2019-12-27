package project.rexkyoo.CustomerPaymentDateServiceTests;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class SetYearTests
{
    @RunWith(Parameterized.class)
    public static class ValidPaymentDates
    {
        private CustomerPaymentDateModel customerPaymentDateModel;
        private String expectedResult;

        public ValidPaymentDates(CustomerPaymentDateModel customerPaymentDateModel, String expectedResult)
        {
            this.customerPaymentDateModel = customerPaymentDateModel;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters(name= "{index} should be: {1}")
        public static Iterable<Object[]> validPaymentDatesData()
        {
            return Arrays.asList(new Object[][]
                    {
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2025-01-12", new CustomerModel()),
                                    "2025"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2024-02-12", new CustomerModel()),
                                    "2024"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2023-03-12", new CustomerModel()),
                                    "2023"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2022-04-12", new CustomerModel()),
                                    "2022"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2021-05-12", new CustomerModel()),
                                    "2021"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2020-06-12", new CustomerModel()),
                                    "2020"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-07-12", new CustomerModel()),
                                    "2019"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2018-08-12", new CustomerModel()),
                                    "2018"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2017-09-12", new CustomerModel()),
                                    "2017"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2016-10-12", new CustomerModel()),
                                    "2016"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2015-11-12", new CustomerModel()),
                                    "2015"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2014-12-12", new CustomerModel()),
                                    "2014"}
                    }
            );
        }


        @Test
        public void validYears_Succeeds()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

            // Act
            customerPaymentDateService.setYear(customerPaymentDateModel);

            // Assert
            assertEquals(expectedResult, customerPaymentDateModel.getYear());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvalidPaymentDates
    {
        private CustomerPaymentDateModel customerPaymentDateModel;
        private String expectedResult;

        public InvalidPaymentDates(CustomerPaymentDateModel customerPaymentDateModel, String expectedResult)
        {
            this.customerPaymentDateModel = customerPaymentDateModel;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters(name= "{index} should be: {1}")
        public static Iterable<Object[]> invalidPaymentDatesData()
        {
            return Arrays.asList(new Object[][]
                    {
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "202", new CustomerModel()),
                                    "NOT FOUND"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", "2019-01-03:00:00:00", new CustomerModel()),
                                    "NOT FOUND"},
                            {new CustomerPaymentDateModel
                                    ("Afventer betaling", null, new CustomerModel()),
                                    "NOT FOUND"}

                    }
            );
        }


        @Test
        public void invalidDates_YearIsNotFound()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

            // Act
            customerPaymentDateService.setYear(customerPaymentDateModel);

            // Assert
            assertEquals(expectedResult, customerPaymentDateModel.getYear());
        }
    }




}

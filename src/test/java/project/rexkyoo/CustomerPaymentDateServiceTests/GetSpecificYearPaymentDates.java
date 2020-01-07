package project.rexkyoo.CustomerPaymentDateServiceTests;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// SRC

@RunWith(Enclosed.class)
public class GetSpecificYearPaymentDates
{
    private static HashSet<CustomerPaymentDateModel> getValidPaymentDates(int numberOfSameYears)
    {
        HashSet<CustomerPaymentDateModel> customerPaymentDates = new HashSet<>();

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < numberOfSameYears; j++)
            {
                CustomerPaymentDateModel customerPaymentDate =
                        new CustomerPaymentDateModel("Afventer betaling",
                                "201" + i + "-01-01", new CustomerModel());

                customerPaymentDates.add(customerPaymentDate);
            }
        }

        return customerPaymentDates;
    }

    @RunWith(Parameterized.class)
    public static class ValidPaymentDates
    {
        private HashSet<CustomerPaymentDateModel> customerPaymentDates;
        private String expectedResult;
        private int numberOfSameYears;

        public ValidPaymentDates(HashSet<CustomerPaymentDateModel> customerPaymentDates, String expectedResult, int numberOfSameYears)
        {
            this.customerPaymentDates = customerPaymentDates;
            this.expectedResult = expectedResult;
            this.numberOfSameYears = numberOfSameYears;
        }

        @Parameterized.Parameters(name= "{index}: Year should be: {1}. Size should be: {2}")
        public static Iterable<Object[]> validPaymentDatesData()
        {
            return Arrays.asList(new Object[][]
                    {
                            {getValidPaymentDates(5), "2010", 5},
                            {getValidPaymentDates(11), "2011", 11},
                            {getValidPaymentDates(7), "2012", 7},
                            {getValidPaymentDates(4), "2013", 4},
                            {getValidPaymentDates(1), "2014", 1}
                    }
            );
        }

        @Test
        public void validDates_Succeeds()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();
            Set<CustomerPaymentDateModel> specificYearPaymentDates;

            // Act
            specificYearPaymentDates = customerPaymentDateService.getSelectedYearPaymentDates(customerPaymentDates, expectedResult);

            for (CustomerPaymentDateModel paymentDate : customerPaymentDates)
            {
                customerPaymentDateService.setYear(paymentDate);
            }

            // Assert
            for (CustomerPaymentDateModel paymentDate : specificYearPaymentDates)
            {
                assertEquals(paymentDate.getYear(), expectedResult);
            }

            assertEquals(specificYearPaymentDates.size(), numberOfSameYears);
        }

    }

    @RunWith(Parameterized.class)
    public static class NoPaymentDates
    {
        private HashSet<CustomerPaymentDateModel> customerPaymentDates;
        private String expectedResult;
        private int numberOfSameYears;

        public NoPaymentDates(HashSet<CustomerPaymentDateModel> customerPaymentDates, String expectedResult, int numberOfSameYears)
        {
            this.customerPaymentDates = customerPaymentDates;
            this.expectedResult = expectedResult;
            this.numberOfSameYears = numberOfSameYears;
        }

        @Parameterized.Parameters(name= "{index}: Result should be: {1}")
        public static Iterable<Object[]> validPaymentDatesData()
        {
            return Arrays.asList(new Object[][]
                    {
                            {getValidPaymentDates(5), "Invalid data", 5},
                            {getValidPaymentDates(5), "100", 5},
                            {getValidPaymentDates(5), "", 5}
                    }
            );
        }

        @Test
        public void noPaymentDatesFound_SetIsEmpty()
        {
            // Arrange
            CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();
            Set<CustomerPaymentDateModel> specificYearPaymentDates;

            // Act
            specificYearPaymentDates = customerPaymentDateService.getSelectedYearPaymentDates(customerPaymentDates, expectedResult);

            for (CustomerPaymentDateModel paymentDate : customerPaymentDates)
            {
                customerPaymentDateService.setYear(paymentDate);
            }

            // Assert
            assertTrue(specificYearPaymentDates.isEmpty());
        }

    }
}

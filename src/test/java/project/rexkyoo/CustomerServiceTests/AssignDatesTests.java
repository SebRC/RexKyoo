package project.rexkyoo.CustomerServiceTests;

import org.junit.experimental.runners.Enclosed;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(Enclosed.class)
public class AssignDatesTests
{

    @RunWith(Parameterized.class)
    public static class ValidDatesSucceeds
    {
        private CustomerModel customer;
        private String expectedResult;

        public ValidDatesSucceeds(CustomerModel customer, String expectedResult)
        {
            this.customer = customer;
            this.expectedResult = expectedResult;
        }

        public static CustomerModel getCustomerWithValidDates()
        {
            CustomerModel customer = new CustomerModel();
            Set<CustomerPaymentDateModel> customerPaymentDates = new HashSet<>();

            customer.setCustomerPaymentDateModels(customerPaymentDates);

            for (int i = 1; i < 10; i++)
            {
                CustomerPaymentDateModel customerPaymentDateModel =
                        new CustomerPaymentDateModel("Afventer betaling", "2019-12-0" + i, customer);

                customer.getCustomerPaymentDates().add(customerPaymentDateModel);
            }

            return customer;
        }

        @Parameterized.Parameters(name= "{index}: Should be {1}")
        public static Iterable<Object[]> validPaymentDatesData()
        {
            return Arrays.asList(new Object[][]
                    {
                            {getCustomerWithValidDates(), "2019-12-09"}
                    }
            );
        }

        @Test
        public void validDates_Succeeds()
        {
            // Arrange
            String actualExpectedPaymentDate;
            CustomerService customerService = new CustomerService();

            // Act
            customerService.assignDates(customer);
            actualExpectedPaymentDate = customer.getExpectedPaymentDate();

            // Assert
            assertEquals(expectedResult, actualExpectedPaymentDate);
        }
    }

}

package project.rexkyoo.CustomerServiceTests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;

import java.util.HashSet;
import java.util.Set;

class AssignDatesTests
{
    @Test
    void validData_Succeeds()
    {
        // Arrange
        String expectedPaymentDate = "2019-12-9";
        String actualExpectedPaymentDate;
        CustomerService customerService = new CustomerService();

        CustomerModel customerModel = new CustomerModel();
        Set<CustomerPaymentDateModel> customerPaymentDates = new HashSet<>();

        customerModel.setCustomerPaymentDateModels(customerPaymentDates);

        for (int i = 1; i < 10; i++)
        {
            CustomerPaymentDateModel customerPaymentDateModel =
                    new CustomerPaymentDateModel("Afventer betaling", "2019-12-" + i, customerModel);

            customerModel.getCustomerPaymentDates().add(customerPaymentDateModel);
        }

        // Act
        customerService.assignDates(customerModel);
        actualExpectedPaymentDate = customerModel.getExpectedPaymentDate();

        // Assert
        assertEquals(expectedPaymentDate, actualExpectedPaymentDate);
    }
}

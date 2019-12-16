package project.rexkyoo;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;

import java.util.HashSet;
import java.util.Set;

class CustomerModelTests
{
    @Test
    void assignDates_ValidData_Succeeds()
    {
        // Arrange
        String expectedPaymentDate = "2019-12-9";
        String actualExpectedPaymentDate;

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
        customerModel.assignDates();
        actualExpectedPaymentDate = customerModel.getExpectedPaymentDate();

        // Assert
        assertEquals(expectedPaymentDate, actualExpectedPaymentDate);
    }
}

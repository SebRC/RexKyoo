package project.rexkyoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class CustomerPaymentDatesServiceTests
{
    CustomerPaymentDateModel customerPaymentDateModel;
    String month;

    public CustomerPaymentDatesServiceTests(CustomerPaymentDateModel customerPaymentDateModel, String month)
    {
        this.customerPaymentDateModel = customerPaymentDateModel;
        this.month = month;
    }

    @Parameterized.Parameters(name= "{index} should be: {1}")
    public static Iterable<Object[]> paymentDatesData() {
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
    public void setMonth_ValidCalendarYear_Succeeds()
    {
        // Arrange
        CustomerPaymentDateService customerPaymentDateService = new CustomerPaymentDateService();

        // Act
        customerPaymentDateService.setMonth(customerPaymentDateModel);

        // Assert
        assertEquals(month, customerPaymentDateModel.getMonth());
    }
}

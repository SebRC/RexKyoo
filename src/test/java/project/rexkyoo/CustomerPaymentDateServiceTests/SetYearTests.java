package project.rexkyoo.CustomerPaymentDateServiceTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SetYearTests
{
    CustomerPaymentDateModel customerPaymentDateModel;
    String year;

    public SetYearTests(CustomerPaymentDateModel customerPaymentDateModel, String year)
    {
        this.customerPaymentDateModel = customerPaymentDateModel;
        this.year = year;
    }

    @Parameterized.Parameters(name= "{index} should be: {1}")
    public static Iterable<Object[]> paymentDatesData() {
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
        assertEquals(year, customerPaymentDateModel.getYear());
    }

}

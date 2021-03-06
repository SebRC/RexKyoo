package project.rexkyoo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

// SRC

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerPaymentDateService customerPaymentDateService;

    public List<CustomerModel> getAllPrivateCustomers()
    {
        // SRC

        String type = "private";

        List<CustomerModel> privateCustomers = customerRepository.findAllByTypeEquals(type);

        for (CustomerModel privateCustomer : privateCustomers)
        {
            assignDates(privateCustomer);
        }

        return privateCustomers;
    }

    public void assignDates(CustomerModel customer)
    {
        // SRC

        CustomerPaymentDateModel relevantPaymentDates = new CustomerPaymentDateModel();

        relevantPaymentDates = resolveRelevantPaymentDates(customer, relevantPaymentDates);

        customer.setExpectedPaymentDate(relevantPaymentDates.getExpectedPaymentDate());

        customer.setActualPaymentDate(relevantPaymentDates.getActualPaymentDate());
    }

    private CustomerPaymentDateModel resolveRelevantPaymentDates(CustomerModel customer, CustomerPaymentDateModel relevantPaymentDates)
    {
        // SRC

        Date mostRecentDate = new Date(1);

        for (CustomerPaymentDateModel paymentDates : customer.getCustomerPaymentDates())
        {
            Date currentEvaluatedDate = convertDate(paymentDates.getExpectedPaymentDate());

            boolean isEvaluatedDateMostRecent = currentEvaluatedDate.compareTo(mostRecentDate) > 0;

            if(isEvaluatedDateMostRecent)
            {
                mostRecentDate = currentEvaluatedDate;

                relevantPaymentDates = paymentDates;
            }
        }

        return relevantPaymentDates;
    }

    private Date convertDate(String expectedDate)
    {
        // SRC

        SimpleDateFormat yearMonthDate = new SimpleDateFormat("yyyy-MM-dd");

        try
        {
            return yearMonthDate.parse(expectedDate);
        }
        catch(ParseException parseException)
        {

            return null;
        }
    }

    public List<CustomerModel> getAllBusinessCustomers()
    {
        // SRC

        String type = "business";

        List<CustomerModel> businessCustomers = customerRepository.findAllByTypeEquals(type);

        for (CustomerModel businessCustomer : businessCustomers)
        {
            assignDates(businessCustomer);
        }

        return businessCustomers;
    }

    public List<CustomerModel> getAll()
    {
        List<CustomerModel> Customers = customerRepository.findAll();

        return Customers;
    }

    public CustomerModel getOne(int id)
    {
        // SRC

        CustomerModel customer = customerRepository.getOne(id);

        assignDates(customer);

        setMonthsAndYears(customer);

        return customer;
    }

    private void setMonthsAndYears(CustomerModel customer)
    {
        // SRC

        Set<CustomerPaymentDateModel> customerPaymentDates = customer.getCustomerPaymentDates();

        for (CustomerPaymentDateModel customerPaymentDate : customerPaymentDates)
        {
            customerPaymentDateService.setMonth(customerPaymentDate);
            customerPaymentDateService.setYear(customerPaymentDate);
        }
    }

    public void save(CustomerModel customerModel)
    {
        customerRepository.save(customerModel);
    }

    public void delete(int id)
    {
        customerRepository.deleteById(id);
    }
}

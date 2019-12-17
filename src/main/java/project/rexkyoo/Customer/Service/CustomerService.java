package project.rexkyoo.Customer.Service;

import com.oracle.tools.packager.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Repository.CustomerRepository;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerPaymentDateService customerPaymentDateService;

    public List<CustomerModel> getAllPrivateCustomers()
    {
        String type = "private";

        List<CustomerModel> privateCustomers = customerRepository.findAllByTypeEquals(type);

        for (CustomerModel privateCustomer : privateCustomers)
        {
            assignDates(privateCustomer);
        }

        return privateCustomers;
    }

    public List<CustomerModel> getAllBusinessCustomers() throws Exception
    {
        String type = "business";

        List<CustomerModel> businessCustomers = customerRepository.findAllByTypeEquals(type);

        for (CustomerModel businessCustomer : businessCustomers)
        {
            businessCustomer.assignDates();
        }

        return businessCustomers;
    }

    public CustomerModel getOne(int id)
    {
        CustomerModel customerModel = customerRepository.getOne(id);

        Set<CustomerPaymentDateModel> customerPaymentDateModels = customerModel.getCustomerPaymentDates();

        assignDates(customerModel);
        for (CustomerPaymentDateModel customerPaymentDateModel : customerPaymentDateModels)
        {
            customerPaymentDateService.setMonth(customerPaymentDateModel);
            customerPaymentDateService.setYear(customerPaymentDateModel);
        }

        return customerModel;
    }

    public void save(CustomerModel customerModel)
    {
        customerRepository.save(customerModel);
    }

    public void delete(int id)
    {
        customerRepository.deleteById(id);
    }

    public void assignDates(CustomerModel customerModel)
    {
        CustomerPaymentDateModel relevantPaymentDates = new CustomerPaymentDateModel();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date mostRecentDate = new Date(1);

        for (CustomerPaymentDateModel paymentDates : customerModel.getCustomerPaymentDates())
        {
            Date currentEvaluatedDate;

            try
            {
                currentEvaluatedDate = simpleDateFormat.parse(paymentDates.getExpectedPaymentDate());
            }
            catch(ParseException parseException)
            {
                Log.debug(parseException.getLocalizedMessage());

                return;
            }


            boolean isEvaluatedDateMostRecent = currentEvaluatedDate.compareTo(mostRecentDate) > 0;

            if(isEvaluatedDateMostRecent)
            {
                mostRecentDate = currentEvaluatedDate;

                relevantPaymentDates = paymentDates;
            }
        }

        customerModel.setExpectedPaymentDate(relevantPaymentDates.getExpectedPaymentDate());

        customerModel.setActualPaymentDate(relevantPaymentDates.getActualPaymentDate());
    }
}

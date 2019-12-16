package project.rexkyoo.CustomerPaymentDate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Repository.CustomerPaymentDateRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CustomerPaymentDateService
{
    @Autowired
    private CustomerPaymentDateRepository customerPaymentDateRepository;

    public List<CustomerPaymentDateModel> getAll()
    {
        return customerPaymentDateRepository.findAll();
    }

    public CustomerPaymentDateModel getOne(int id)
    {
        return customerPaymentDateRepository.getOne(id);
    }

    public void save(CustomerPaymentDateModel customerPaymentDateModel)
    {
        customerPaymentDateRepository.save(customerPaymentDateModel);
    }

    public void delete(int id)
    {
        customerPaymentDateRepository.deleteById(id);
    }

    public void setMonth(Set<CustomerPaymentDateModel> customerPaymentDateModels)
    {
        SimpleDateFormat yearMonthDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (CustomerPaymentDateModel paymentDates : customerPaymentDateModels)
        {
            Date currentEvaluatedDate;

            try
            {
                currentEvaluatedDate = yearMonthDateFormat.parse(paymentDates.getExpectedPaymentDate());
            }
            catch(ParseException parseException)
            {
                return;
            }

            int monthIndex = currentEvaluatedDate.getMonth();

            Month month = Month.of(monthIndex + 1);

            String formattedMonth = month.toString().substring(0,3);

            paymentDates.setMonth(formattedMonth);
        }
    }
}

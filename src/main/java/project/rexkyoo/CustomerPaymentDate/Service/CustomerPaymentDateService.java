package project.rexkyoo.CustomerPaymentDate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Repository.CustomerPaymentDateRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.HashSet;
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

    public void setMonth(CustomerPaymentDateModel customerPaymentDateModel)
    {
        SimpleDateFormat yearMonthDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date currentEvaluatedDate;

        try
        {
            currentEvaluatedDate = yearMonthDateFormat.parse(customerPaymentDateModel.getExpectedPaymentDate());
        } catch (ParseException parseException)
        {
            customerPaymentDateModel.setMonth("NOT FOUND");
            return;
        }

        int monthIndex = currentEvaluatedDate.getMonth();

        Month month = Month.of(monthIndex + 1);

        String formattedMonth = extractMonth(month);

        customerPaymentDateModel.setMonth(formattedMonth);
    }

    private String extractMonth(Month month)
    {
        String formattedMonth = month.toString().substring(0, 3);

        return formattedMonth;
    }

    public Set<CustomerPaymentDateModel> getSelectedYearPaymentDates(Set<CustomerPaymentDateModel> customerPaymentDates, String selectedYear)
    {
        Set<CustomerPaymentDateModel> selectedYearPaymentDates = extractSelectedYearPaymentDates(customerPaymentDates, selectedYear);

        return selectedYearPaymentDates;
    }

    private Set<CustomerPaymentDateModel> extractSelectedYearPaymentDates(Set<CustomerPaymentDateModel> customerPaymentDates, String selectedYear)
    {
        Set<CustomerPaymentDateModel> selectedYearPaymentDates = new HashSet<>();

        for (CustomerPaymentDateModel customerPaymentDate : customerPaymentDates)
        {
            String expectedPaymentDate = customerPaymentDate.getExpectedPaymentDate();

            String paymentDateYear = extractYear(expectedPaymentDate);

            boolean isPaymentDateSelectedYear = selectedYear.equals(paymentDateYear);

            if (isPaymentDateSelectedYear)
            {
                selectedYearPaymentDates.add(customerPaymentDate);
            }
        }

        return selectedYearPaymentDates;
    }

    private String extractYear(String date)
    {
        String year = date.substring(0,4);

        return year;
    }

    public void setYear(CustomerPaymentDateModel customerPaymentDateModel)
    {
        String date = customerPaymentDateModel.getExpectedPaymentDate();

        boolean isValidYear = validateDateYear(date);

        String year;

        if(isValidYear)
        {
            year = extractYear(date);
        }
        else
        {
            year = "NOT FOUND";
        }

        customerPaymentDateModel.setYear(year);
    }

    private boolean validateDateYear(String date)
    {
        boolean isValidYear = date != null && date.length() == 10;

        return isValidYear;
    }
}

package project.rexkyoo.Customer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Repositories.CustomerRepository;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
}

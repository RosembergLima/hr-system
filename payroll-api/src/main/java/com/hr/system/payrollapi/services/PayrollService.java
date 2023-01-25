package com.hr.system.payrollapi.services;

import com.hr.system.payrollapi.domain.Payroll;
import com.hr.system.payrollapi.feignClients.UserFeign;
import com.hr.system.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollService {

    private final Environment env;
    private final UserFeign userFeign;
    public Payroll getPayment(Long id, Payroll payroll){
        log.info("Payroll Service ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = userFeign.findById(id).getBody();
            if(Objects.nonNull(user))
            return new Payroll(
                    user.getName(), payroll.getDescription(),
                    user.getHourlyPrice(), payroll.getWorkedHours(),
                    user.getHourlyPrice() * payroll.getWorkedHours()
            );
        }catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException("User not found");
        }catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}

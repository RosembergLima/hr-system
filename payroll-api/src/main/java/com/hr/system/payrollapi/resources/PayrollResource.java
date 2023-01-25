package com.hr.system.payrollapi.resources;

import com.hr.system.payrollapi.domain.Payroll;
import com.hr.system.payrollapi.domain.User;
import com.hr.system.payrollapi.feignClients.UserFeign;
import com.hr.system.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    private final UserFeign userFeign;
    private final PayrollService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long id, @RequestBody Payroll payment){
        return ResponseEntity.ok().body(
                service.getPayment(id, payment)
                );
    }

}

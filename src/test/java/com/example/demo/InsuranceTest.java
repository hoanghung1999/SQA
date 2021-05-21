package com.example.demo;

import com.example.demo.entity.Insurance;
import com.example.demo.service.InsuranceImpl;
import com.example.demo.service.InsuranceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private ApplicationContext context;

    // Insurance
    @Test
    void TestGetAllInsurance(){
        InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
        Assertions.assertEquals(3,insuranceService.getAllInsurance().size());
    }

    @Test
    void TestUpdateInsuranceInDB(){
        InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
        //thong tin insurance update
        Insurance insurance=new Insurance();
        insurance.setId(1);
        insurance.setNametype("BH_update");
        insurance.setPrice(100000);

        //Insurance Truoc khi update
        Insurance insuranceDB=insuranceService.findInsuranceById(1).get();

        //update
        insuranceService.UpdateInsurance(insurance);
        // Sau update
        Insurance insuranceAfterUD=insuranceService.findInsuranceById(1).get();

        Assertions.assertEquals(insurance.getId(),insuranceAfterUD.getId());
        Assertions.assertEquals(insurance.getNametype(),insuranceAfterUD.getNametype());
        Assertions.assertEquals(insurance.getPrice(),insuranceAfterUD.getPrice());

        //Back up lai du lieu
        insuranceService.UpdateInsurance(insuranceDB);
    }

    @Test
    void UpdateInsuranceNotInDB(){
        InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
        //thong tin insurance update
        Insurance insurance=new Insurance();
        insurance.setId(4);
        insurance.setNametype("BH_update");
        insurance.setPrice(100000);
        // update
        Assertions.assertEquals(null,insuranceService.UpdateInsurance(insurance));
    }
}

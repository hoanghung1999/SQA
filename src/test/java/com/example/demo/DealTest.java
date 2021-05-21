package com.example.demo;

import com.example.demo.service.DealImpl;
import com.example.demo.service.DealService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
@SpringBootTest
public class DealTest {
    @Autowired
    private ApplicationContext context;
    //Deal
    // Lay toan bo Hoa Don co trong  co so du lieu
    @Test
    void TestDealServiceGetAll() {
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(10,dealService.getAllDeal().size());
    }

    //testCase Lay so luong deal trong 1 khoang
    @Test
    void getDealByTimeValid1(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(2,dealService.getDealByDate("2020-05-05","2020-05-06").size());
    }
    @Test
    void getDealByTimeValid2(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(5,dealService.getDealByDate("2020-05-05","2020-05-08").size());
    }
    @Test
    void getDealByTimeValid3(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(10,dealService.getDealByDate("2020-04-05","2020-06-06").size());
    }
    @Test
        //Bien Duoi
    void getDealByTimeValid4(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(1,dealService.getDealByDate("2020-03-05","2020-05-04").size());
    }

    //Bien Tren
    @Test
    void getDealByTimeValid5(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(1,dealService.getDealByDate("2020-06-06","2020-06-08").size());
    }
    @Test
    void getDealByTimeValid6(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(0,dealService.getDealByDate("2020-03-05","2020-05-03").size());
    }
    @Test
    void getDealByTimeValid7(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(0,dealService.getDealByDate("2020-06-06","2020-04-05").size());
    }
    // Nhap Dai Dinh Dang
    @Test
    void getDealByTimeInValidSDD_1(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(0,dealService.getDealByDate("ABC","2020-05-05").size());
    }

    @Test
    void getDealByTimeInValidSDD_2(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(0,dealService.getDealByDate("2020-05-05","BCD").size());
    }

    @Test
    void getDealByTimeInValidSDD_3(){
        DealService dealService=context.getBean(DealImpl.class);
        Assertions.assertEquals(0,dealService.getDealByDate("EFG","BCD").size());
    }
}

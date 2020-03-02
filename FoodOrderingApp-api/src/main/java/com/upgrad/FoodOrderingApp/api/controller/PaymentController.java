package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.PaymentListResponse;
import com.upgrad.FoodOrderingApp.api.model.PaymentResponse;
import com.upgrad.FoodOrderingApp.service.businness.PaymentService;
import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(allowedHeaders = "*", origins = "*", exposedHeaders = ("access-token"))
@RestController
//This endpoint is used to get Payment information from the FoodOrderingAppBackend.
@RequestMapping("/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //This endpoint is used to Get Payment Modes from the FoodOrderingAppBackend.
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/payment",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PaymentListResponse> getPaymentList() {
        List<PaymentEntity> listPaymentEntity = paymentService.getAllPaymentMethods();
        List<PaymentResponse> listPaymentResponse = new ArrayList<PaymentResponse>();
        for (PaymentEntity paymentEntity : listPaymentEntity) {
            listPaymentResponse.add(new PaymentResponse().id(UUID.fromString(paymentEntity.getUuid())).paymentName(paymentEntity.getPaymentName()));
        }
        if (listPaymentResponse.size() == 0) {
            listPaymentResponse = null;
        }
        PaymentListResponse paymentListResponse = new PaymentListResponse().paymentMethods(listPaymentResponse);
        return new ResponseEntity<PaymentListResponse>(paymentListResponse, HttpStatus.OK);
    }
}

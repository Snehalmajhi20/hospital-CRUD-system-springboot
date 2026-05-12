package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Bill;
import com.hospital.service.BillsService;

@RestController
@RequestMapping("/api/v1/bill")
public class BillsController {
	
	@Autowired
    private BillsService billService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBill(@RequestBody Bill bill) {

        Bill bill1 = billService.billSave(bill);

        if (ObjectUtils.isEmpty(bill1)) {
            return new ResponseEntity<>("Bill could not be saved!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(bill1, HttpStatus.CREATED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listBills() {

        List<Bill> getList = billService.getAllBillList();

        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBill(@RequestBody Bill bill) {

        Bill bill2 = billService.billUpdate(bill);

        if (ObjectUtils.isEmpty(bill2)) {
            return new ResponseEntity<>("Bill could not be updated!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(bill2, HttpStatus.OK);
        }
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<?> getBillId(@PathVariable Long id) {

        Bill bill3 = billService.getBillId(id);

        if (ObjectUtils.isEmpty(bill3)) {
            return new ResponseEntity<>("Bill id not found!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(bill3, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id) {

        Bill bill4 = billService.billDelete(id);

        if (ObjectUtils.isEmpty(bill4)) {
            return new ResponseEntity<>("Bill id not found to delete!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>("Bill Deleted Successfully!",
                    HttpStatus.OK);
        }
    }

}

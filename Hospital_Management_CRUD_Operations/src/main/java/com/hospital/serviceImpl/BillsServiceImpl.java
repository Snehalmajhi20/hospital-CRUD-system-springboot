package com.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Bill;
import com.hospital.repository.BillsRepository;
import com.hospital.service.BillsService;

@Service
public class BillsServiceImpl implements BillsService{
	
	    @Autowired
	    private BillsRepository billRepository;

	    @Override
	    public Bill billSave(Bill bill) {
	        return billRepository.save(bill);
	    }

	    @Override
	    public List<Bill> getAllBillList() {
	        return billRepository.findAll();
	    }

	    @Override
	    public Bill billUpdate(Bill bill) {
	        return billRepository.save(bill);
	    }

	    @Override
	    public Bill billDelete(Long id) {

	        Bill bill = billRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Bill not found"));

	        billRepository.delete(bill);

	        return bill;
	    }

	    @Override
	    public Bill getBillId(Long id) {

	        return billRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Bill not found"));
	    }

}

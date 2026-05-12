package com.hospital.service;

import java.util.List;

import com.hospital.model.Bill;

public interface BillsService {
	
	public Bill billSave(Bill bill);

    public List<Bill> getAllBillList();

    public Bill billUpdate(Bill bill);

    public Bill billDelete(Long id);

    public Bill getBillId(Long id);

}

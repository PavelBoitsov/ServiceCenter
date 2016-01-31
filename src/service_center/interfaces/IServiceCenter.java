package service_center.interfaces;

import service_center.dao.*;

public interface IServiceCenter {
	public boolean addReceipt(Receipt receipt);
	
	public Iterable<Receipt> getAllReceipt();

}

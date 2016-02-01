package service_center.interfaces;

import service_center.dao.*;

public interface IServiceCenter {
	boolean addReceipt(Receipt receipt);
	boolean addClient(Client client);
	boolean addShop(Shop shop);
	boolean addUser(User user);
	boolean addPosition(Position position);
	
	public Iterable<Receipt> getAllReceipt();

}

package service_center.interfaces;

import service_center.dao.*;

public interface IServiceCenter {
	boolean addReceipt(Receipt receipt);
	boolean addClient(Client client);
	boolean addShop(Shop shop);
	boolean addUser(User user);
	boolean addPosition(Position position);
	boolean addProduct(Product product);
	boolean addComplexityRepair(ComplexityRepair complexityRepair);
	boolean addStatus(Status status);
	boolean addRepiatRepair(RepiatRepair repiatRepair);
	
	public Iterable<Receipt> getAllReceipt();

}

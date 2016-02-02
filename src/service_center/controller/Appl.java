package service_center.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service_center.dao.*;
import service_center.interfaces.*;

public class Appl {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		IServiceCenter controller = (IServiceCenter) ctx.getBean("database");

		Receipt receipt1 = new Receipt();
		Receipt receipt2 = new Receipt();
		Client client1 = new Client();
		Shop shop1 = new Shop("Netania", "N");
		Shop shop2 = new Shop("Rehovot", "R");
		
		ComplexityRepair cr1 = new ComplexityRepair("Notebook", 90);
		ComplexityRepair cr2 = new ComplexityRepair("Monitor", 30);
		controller.addComplexityRepair(cr1);
		controller.addComplexityRepair(cr2);
		
		Product product1 = new Product("Monitor", "BN123F987", 36, "LG", "1943W", cr2);
		Product product2 = new Product("Monitor", "123F98711", 36, "Samsung", "940N", cr2);
		Product product3 = new Product("Notebook", "BN000F980", 36, "Asus", "X551C", cr1);
		controller.addProduct(product1);
		controller.addProduct(product2);
		controller.addProduct(product3);
		
		Position position1 = new Position(1, "Tester");
		controller.addPosition(position1);
				
		User user1 = new User("login1", "password1", "Terminator", "Term", "050-1234567");
		
		user1.setPosition(position1);
		controller.addUser(user1);
						
		controller.addShop(shop1);
		controller.addShop(shop2);

		client1.setfName("Ivan");
		client1.setsName("Ivanov");
		controller.addClient(client1);
		
		Status st = (Status) ctx.getBean("status");
		controller.addStatus(st);
		/*for (String s : st.getStatus()) {
			System.out.println(s);
		}*/
		
		
		receipt1.setDefectClient("Super1");
		receipt1.setClient(client1);
		receipt1.setShop(shop1);
		receipt1.setUser(user1);
		receipt1.setProduct(product1);
		receipt1.setStatus(st);
		controller.addReceipt(receipt1);

		receipt2.setDefectClient("Super2");
		receipt2.setClient(client1);
		receipt2.setShop(shop2);
		receipt2.setProduct(product3);
		receipt2.setStatus(st);
		controller.addReceipt(receipt2);
		
		RepiatRepair repiatRepair1 = new RepiatRepair();
		repiatRepair1.setUser(user1);
		repiatRepair1.setProduct(product2);
		repiatRepair1.setStatus(st);
		repiatRepair1.setReceipt(receipt1);
		controller.addRepiatRepair(repiatRepair1);
		

		System.out.println(receipt1);
		ctx.close();
	}

}

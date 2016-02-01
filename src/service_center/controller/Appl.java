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

		receipt1.setDefectClient("Super1");
		receipt1.setClient(client1);
		receipt1.setShop(shop1);
		receipt1.setUser(user1);
		controller.addReceipt(receipt1);

		receipt2.setDefectClient("Super2");
		receipt2.setClient(client1);
		receipt2.setShop(shop2);
		controller.addReceipt(receipt2);
		

		System.out.println(receipt1);
		ctx.close();
	}

}

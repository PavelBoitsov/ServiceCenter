package service_center.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service_center.dao.Receipt;
import service_center.interfaces.IServiceCenter;

public class Appl {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		IServiceCenter controller = (IServiceCenter) ctx.getBean("database");
		Receipt receipt1 = new Receipt();
		receipt1.setDefectClient("Super");
		controller.addReceipt(receipt1);
		System.out.println(receipt1);
		ctx.close();
	}

}

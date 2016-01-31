package service_center.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import service_center.dao.Receipt;
import service_center.interfaces.IServiceCenter;

public class ReceiptHibernate implements IServiceCenter {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Override
	@Transactional
	public boolean addReceipt(Receipt receipt) {
			em.persist(receipt);
			return true;
	}

	@Override
	public Iterable<Receipt> getAllReceipt() {
		// TODO Auto-generated method stub
		return null;
	}

}

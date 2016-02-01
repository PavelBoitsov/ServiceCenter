package service_center.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import service_center.dao.Client;
import service_center.dao.Position;
import service_center.dao.Receipt;
import service_center.dao.Shop;
import service_center.dao.User;
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

	@Override
	@Transactional
	public boolean addClient(Client client) {
		em.persist(client);
		return true;
	}

	@Override
	@Transactional
	public boolean addShop(Shop shop) {
		em.persist(shop);
		return true;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		em.persist(user);
		return true;
	}

	@Override
	@Transactional
	public boolean addPosition(Position position) {
		// TODO Auto-generated method stub
		em.persist(position);
		return true;
	}

}

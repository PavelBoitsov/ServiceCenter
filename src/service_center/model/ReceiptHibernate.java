package service_center.model;

import java.util.*;
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import service_center.dao.*;
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
		Position positionEntity = getPosition(position.getAccessLevel(), position.getPositionJob());
		if (positionEntity == null) {
			positionEntity = new Position(position.getAccessLevel(), position.getPositionJob());
			em.persist(positionEntity);
			return true;
		}
		return false;
	}

	private Position getPosition(int accessLevel, String positionJob) {
		Query query = em.createQuery(
				"SELECT p FROM Position p WHERE p.accessLevel = accessLevel AND p.positionJob = positionJob");
		List<Position> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	@Override
	@Transactional
	public boolean addProduct(Product product) {
		em.persist(product);
		return true;
	}

	@Override
	@Transactional
	public boolean addComplexityRepair(ComplexityRepair complexityRepair) {
		em.persist(complexityRepair);
		return true;
	}

	@Override
	@Transactional
	public boolean addStatus(Status status) {
		em.persist(status);
		return true;
	}

	@Override
	@Transactional
	public boolean addRepiatRepair(RepiatRepair repiatRepair) {
		em.persist(repiatRepair);
		return true;
	}

	@Override
	@Transactional
	public boolean addHistory(History history) {
		em.persist(history);
		return true;
	}

}

package service_center.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import service_center.dao.Client;
import service_center.dao.ComplexityRepair;
import service_center.dao.Position;
import service_center.dao.Product;
import service_center.dao.Receipt;
import service_center.dao.RepiatRepair;
import service_center.dao.Shop;
import service_center.dao.Status;
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
		Client clientEntity = em.find(Client.class, client.getTelNumber());
		if (clientEntity == null) {
			clientEntity = new Client(client.getfName(), client.getsName(), client.getTelNumber(), client.getEmail(),
					client.getAddress());
			em.persist(clientEntity);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addShop(Shop shop) {
		Shop shopEntity = em.find(Shop.class, shop.getId());
		if (shopEntity == null) {
			shopEntity = new Shop(shop.getName(), shop.getCode());
			em.persist(shop);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		User userEntity = getUser(user.getTelNumber());
		if (userEntity == null) {
			userEntity = new User(user.getLogin(), user.getPassword(), user.getfName(), user.getsName(),
					user.getTelNumber());
			em.persist(userEntity);
			return true;
		}
		return false;
	}

	private User getUser(String telNumber) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.telNumber = ?1");
		query.setParameter(1, telNumber);
		List<User> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	@Override
	@Transactional
	public boolean addPosition(Position position) {
		Position positionEntity = getPosition(position.getPositionJob());
		if (positionEntity == null) {
			positionEntity = new Position(position.getAccessLevel(), position.getPositionJob());
			em.persist(positionEntity);
			return true;
		}
		return false;
	}

	private Position getPosition(String positionJob) {
		Query query = em.createQuery("SELECT p FROM Position p WHERE p.positionJob = ?1");
		query.setParameter(1, positionJob);
		List<Position> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	@Override
	@Transactional
	public boolean addProduct(Product product) {
		Product productEntity = getProdut(product.getModel(), product.getManufacturer());
		if (productEntity == null) {
			productEntity = new Product(product.getName(), product.getSerialNumber(), product.getWarranty(),
					product.getManufacturer(), product.getModel(), product.getComplexityRepair());
			em.persist(productEntity);
			return true;
		}
		return false;
	}

	private Product getProdut(String model, String manufacturer) {
		Query query = em.createQuery("SELECT p FROM Product p WHERE p.model = ?1 AND p.manufacturer = ?2");
		query.setParameter(1, model);
		query.setParameter(2, manufacturer);
		List<Product> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	@Override
	@Transactional
	public boolean addComplexityRepair(ComplexityRepair complexityRepair) {
		ComplexityRepair complRepEntity = getComplRep(complexityRepair.getComplexity());
		if (complRepEntity == null) {
			complRepEntity = new ComplexityRepair(complexityRepair.getComplexity(), complexityRepair.getTime());
			em.persist(complRepEntity);
			return true;
		}
		return false;
	}

	private ComplexityRepair getComplRep(String complexity) {
		Query query = em.createQuery("SELECT c FROM ComplexityRepair c WHERE c.complexity = ?1");
		query.setParameter(1, complexity);
		List<ComplexityRepair> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	@Override
	@Transactional
	public boolean addStatus(Status status) {
		Status statusEntity = em.find(Status.class, status.getId());
		if (statusEntity == null) {
			statusEntity = new Status();
			em.persist(statusEntity);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addRepiatRepair(RepiatRepair repiatRepair) {
		RepiatRepair repEntity = em.find(RepiatRepair.class, repiatRepair.getId());
		if (repEntity == null) {
			repEntity = new RepiatRepair();
			em.persist(repEntity);
			return true;
		}
		return false;
	}

}

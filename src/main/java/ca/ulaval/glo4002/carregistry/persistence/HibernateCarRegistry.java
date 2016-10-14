package ca.ulaval.glo4002.carregistry.persistence;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;

import ca.ulaval.glo4002.carregistry.domain.CarOwner;
import ca.ulaval.glo4002.carregistry.domain.CarRegistry;

public class HibernateCarRegistry implements CarRegistry {
	
	@SuppressWarnings("unused")
	private EntityManager entityManager;

	public HibernateCarRegistry() {
		this.entityManager = new EntityManagerProvider().getEntityManager();
	}

	@Override
	public CarOwner findOwner(int ownerId) {
		return this.entityManager.find(CarOwner.class,ownerId);
	}

	@Override
	public void insert(CarOwner owner) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(owner);
		this.entityManager.getTransaction().commit();

	}

	@Override
	public void update(CarOwner owner) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(owner);
		this.entityManager.getTransaction().commit();
	}

	@Override
	public Collection<CarOwner> findAllOwners() {
		return this.entityManager.createQuery("SELECT co FROM CarOwner co",CarOwner.class).getResultList();
	}

}

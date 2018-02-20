package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GalleryItem;

public class GalleryItemHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GalleryRhodes");

	public void insertItem(GalleryItem toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<GalleryItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<GalleryItem> allResults = em.createQuery("select li from GalleryItem li", GalleryItem.class);
		List<GalleryItem> allItems = allResults.getResultList();
		em.close();
		return allItems;
		
	}

	public void deleteItem(GalleryItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryItem> typedQuery = em.createQuery("select li from GalleryItem li where li.title = :selectedTitle and li.artistName = :selectedArtistName and li.media = :selectedMedia and li.year = :selectedYear and li.value = :selectedValue", GalleryItem.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedArtistName", toDelete.getArtistName());
		typedQuery.setParameter("selectedMedia", toDelete.getMedia());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedValue", toDelete.getValue());
		typedQuery.setMaxResults(1);
		GalleryItem result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

		

	public List<GalleryItem> searchForItemsByName(String artworkName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryItem> typedQuery = em.createQuery("select la from Artwork la where la.artwork = :selectedArtwork", GalleryItem.class);
		typedQuery.setParameter("selectedArtwork", artworkName);
		List<GalleryItem> result = typedQuery.getResultList();
		em.close();
		return result;
	
	}

}

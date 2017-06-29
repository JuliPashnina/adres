package ru.esbt.adres.service;

import java.util.List;
 
import javax.annotation.Resource;
 
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.esbt.adres.entity.Naspunkt;
 
/**
 *
 * @author Y.Pashnina
 */
@Service("naspunktService")
@Transactional
public class NaspunktService {
 
 protected static Logger logger = Logger.getLogger("service");
  
 @Resource(name="sessionFactory")
 private SessionFactory sessionFactory;
  
 /**
  * Retrieves all cities
  *
  * @return a list of cities
  */
 public List<Naspunkt> getAll() {
  logger.debug("Retrieving all cities");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Create a Hibernate query (HQL)
  Query query = session.createQuery("FROM  CM_NASPUNKT");
   
  // Retrieve all
  return  query.list();
 }
  
 /**
  * Retrieves a single city
  */
 public Naspunkt get( Integer id ) {
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing city first
  Naspunkt city = (Naspunkt) session.get(Naspunkt.class, id);
   
  return city;
 }
 /**
  * Adds a new person
  */
 public void add(Naspunkt city) {
  logger.debug("Adding new city");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Save
  session.save(city);
 }
  
 /**
  * Deletes an existing city
  * @param id the id of the existing city
  */
 public void delete(Integer id) {
  logger.debug("Deleting existing city");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing person first
  Naspunkt city = (Naspunkt) session.get(Naspunkt.class, id);
   
  // Delete
  session.delete(city);
 }
  
 /**
  * Edits an existing city
  */
 public void edit(Naspunkt city) {
  logger.debug("Editing existing person");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing person via id
  Naspunkt existingCity = (Naspunkt) session.get(Naspunkt.class, city.getCmOkato());
   
  // Assign updated values to this person
  existingCity.setCmCtext(city.getCmCtext());
  existingCity.setCmSocr(existingCity.getCmSocr());
  existingCity.setCmNterr(existingCity.getCmNterr());
  existingCity.setCmPoselen(existingCity.getCmPoselen());
  existingCity.setState(existingCity.getState());
 
  // Save updates
  session.save(existingCity);
 }
}
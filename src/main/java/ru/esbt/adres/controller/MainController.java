package ru.esbt.adres.controller;

import java.util.List;
 
import javax.annotation.Resource;
 
import org.apache.log4j.Logger;
import ru.esbt.adres.entity.Naspunkt;
import ru.esbt.adres.service.NaspunktService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
/**
 *
 * @author Y.Pashnina
 */
@Controller
@RequestMapping("/main")
public class MainController {
 
 protected static Logger logger = Logger.getLogger("controller");
  
 @Resource(name="naspunktService")
 private NaspunktService naspunktService;
  
 /**
  * Handles and retrieves all cities and show it in a JSP page
  *
  * @return the name of the JSP page
  */
    @RequestMapping(value = "/naspunkt", method = RequestMethod.GET)
    public String getPersons(Model model) {
      
     logger.debug("Received request to show all cities");
      
     // Retrieve all cities by delegating the call to NaspunktService
     List<Naspunkt> cities = naspunktService.getAll();
      
     // Attach cities to the Model
     model.addAttribute("persons", cities);
      
     // This will resolve to /WEB-INF/jsp/naspunktpage.jsp
     return "naspunktpage";
 }
     
    /**
     * Retrieves the add page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/naspunkt/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
     logger.debug("Received request to show add page");
     
     // Create new Naspunkt and add to model
     // This is the formBackingOBject
     model.addAttribute("naspunktAttribute", new Naspunkt());
 
     // This will resolve to /WEB-INF/jsp/addpage.jsp
     return "addpage";
 }
  
    /**
     * Adds a new city by delegating the processing to NaspunktService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/naspunkt/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("naspunktAttribute") Naspunkt city) {
  logger.debug("Received request to add new city");
   
     // The "naspunktAttribute" model has been passed to the controller from the JSP
     // We use the name "naspunktAttribute" because the JSP uses that name
   
  // Call NaspunktService to do the actual adding
  naspunktService.add(city);
 
     // This will resolve to /WEB-INF/jsp/addedpage.jsp
  return "addedpage";
 }
     
    /**
     * Deletes an existing city by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/naspunkt/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="cmOkato", required=true) Integer cmOkato,
              Model model) {
    
  logger.debug("Received request to delete existing person");
   
  // Call PersonService to do the actual deleting
  naspunktService.delete(cmOkato);
   
  // Add id reference to Model
  model.addAttribute("id", cmOkato);
      
     // This will resolve to /WEB-INF/jsp/deletedpage.jsp
  return "deletedpage";
 }
     
    /**
     * Retrieves the edit page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/naspunkt/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="cmOkato", required=true) Integer cmOkato, 
              Model model) {
     logger.debug("Received request to show edit page");
     
     // Retrieve existing Person and add to model
     // This is the formBackingOBject
     model.addAttribute("personAttribute", naspunktService.get(cmOkato));
      
     // This will resolve to /WEB-INF/jsp/editpage.jsp
     return "editpage";
 }
     
    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/naspunkt/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("naspunktAttribute") Naspunkt city,
                 @RequestParam(value="cmOkato", required=true) Integer cmOkato,
                Model model) {
     logger.debug("Received request to update city");
     
     // The "personAttribute" model has been passed to the controller from the JSP
     // We use the name "personAttribute" because the JSP uses that name
      
     // We manually assign the id because we disabled it in the JSP page
     // When a field is disabled it will not be included in the ModelAttribute
     city.setCmOkato(cmOkato);
      
     // Delegate to PersonService for editing
     naspunktService.edit(city);
      
     // Add id reference to Model
  model.addAttribute("id", cmOkato);
   
     // This will resolve to /WEB-INF/jsp/editedpage.jsp
  return "editedpage";
 }
     
}
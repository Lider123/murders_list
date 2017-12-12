package ru.babaets.databaseinterface.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.babaets.databaseinterface.dao.KillerDAO;
import ru.babaets.databaseinterface.dao.MurderDAO;
import ru.babaets.databaseinterface.model.Killer;
import ru.babaets.databaseinterface.model.Murder;

@Controller
@RequestMapping(value="/tables")
public class TablesController {
	
	@Autowired
	private MurderDAO murderDAO;
	
	@Autowired
	private KillerDAO killerDAO;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView listMurderAndKiller(ModelAndView model) throws IOException {
		List<Murder> listMurder = murderDAO.listMurder();
		List<Killer> listKiller = killerDAO.listKiller();
		model.addObject("listMurder", listMurder);
		model.addObject("listKiller", listKiller);
		model.setViewName("tables");
		return model;
	}
	
	@RequestMapping(value="/addMurder", method= RequestMethod.GET)
	public ModelAndView addMurder(HttpServletRequest request) throws IOException {
		Murder newMurder = new Murder();
		ModelAndView model = new ModelAndView("MurderForm");
		model.addObject("murder", newMurder);
		List<Killer> killers = killerDAO.listKiller();
		model.addObject("killers", killers);
		return model;
	}
	
	@RequestMapping(value="/addMurder", method = RequestMethod.POST)
	public ModelAndView saveMurder(@ModelAttribute @Valid Murder murder, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("MurderForm");
			model.addObject("murder", murder);
			List<Killer> killers = killerDAO.listKiller();
			model.addObject("killers", killers);
			return model;
		}
		
		murderDAO.saveOrUpdateMurder(murder);
		return new ModelAndView("redirect:/tables");
	}
	
	@RequestMapping(value="/editMurder", method = RequestMethod.GET)
	public ModelAndView editMurder(HttpServletRequest request) {
		int murderId = Integer.parseInt(request.getParameter("id"));
		Murder murder = murderDAO.getMurder(murderId);
		ModelAndView model = new ModelAndView("MurderForm");
		model.addObject("murder", murder);
		List<Killer> killers = killerDAO.listKiller();
		model.addObject("killers", killers);
		return model;
	}
	
	@RequestMapping(value="/editMurder", method = RequestMethod.POST)
	public ModelAndView editAndSaveMurder(@ModelAttribute @Valid Murder murder, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("MurderForm");
			model.addObject("murder", murder);
			List<Killer> killers = killerDAO.listKiller();
			model.addObject("killers", killers);
			return model;
		}
		
		murderDAO.saveOrUpdateMurder(murder);
		return new ModelAndView("redirect:/tables");
	}
	
	@RequestMapping(value="/deleteMurder", method = RequestMethod.GET)
	public ModelAndView deleteMurder(HttpServletRequest request) {
		int murderId = Integer.parseInt(request.getParameter("id"));
		murderDAO.deleteMurder(murderId);
		return new ModelAndView("redirect:/tables");
	}
	
	@RequestMapping(value="/addKiller", method= RequestMethod.GET)
	public ModelAndView addKiller(ModelAndView model) throws IOException {
		Killer newKiller = new Killer();
		model.addObject("killer", newKiller);
		model.setViewName("KillerForm");
		return model;
	}
	
	@RequestMapping(value="/addKiller", method = RequestMethod.POST)
	public ModelAndView saveKiller(@ModelAttribute @Valid Killer killer, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("KillerForm");
		
		killerDAO.saveKiller(killer);
		return new ModelAndView("redirect:/tables");
	}
	
	@RequestMapping(value="/deleteKiller", method = RequestMethod.GET)
	public ModelAndView deleteKiller(HttpServletRequest request) {
		int killerId = Integer.parseInt(request.getParameter("id"));
		killerDAO.deleteKiller(killerId);
		return new ModelAndView("redirect:/tables");
	}
	
	@InitBinder /* Converts empty strings into null when a form is submitted */ 
	public void initBinder(WebDataBinder binder) {  
	      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
	  }
}

package ru.babaets.databaseinterface.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.babaets.databaseinterface.dao.MurderWithKillerDAO;
import ru.babaets.databaseinterface.model.MurderWithKiller;

@Controller
@RequestMapping(value="")
public class HomeController {
	
	@Autowired
	private MurderWithKillerDAO murderWithKillerDAO;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView listMurderWithKiller(ModelAndView model) throws IOException {
		List<MurderWithKiller> listMurderWithKiller = murderWithKillerDAO.listMurderWithKiller();
		model.addObject("listMurderWithKiller", listMurderWithKiller);
		model.setViewName("home");
		return model;
	}
}

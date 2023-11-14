package ua.project.buyers.controller;

import java.sql.SQLException;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.project.buyers.dao.PoultryFarmDao;
import ua.project.buyers.entity.Buyer;
import ua.project.buyers.form.AddBuyerForm;
import ua.project.buyers.form.DeleteBuyerForm;
import ua.project.buyers.form.FindBuyerByNameForm;


@Controller
public class FarmController {

	@Autowired
	private PoultryFarmDao dao;

	@RequestMapping(value = { "/", "/buyers" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String getAllBuyers(Model model) throws SQLException {
		List<Buyer> list = dao.getAllBuyers();
		model.addAttribute("allBuyers", list);
		return "buyersPage";
	}

	@GetMapping(value = { "/addBuyer" })
	public String showAddBuyerView(Model model) {
		AddBuyerForm addBuyerForm = new AddBuyerForm();
		model.addAttribute("addBuyerForm", addBuyerForm);
		return "addBuyerPage";
	}

	@PostMapping(value = { "/addBuyer" })
	public String addBuyer(Model model, AddBuyerForm addBuyerForm) throws SQLException {
		// validate adStudentForm object
		dao.addBuyer(new Buyer(addBuyerForm.getNameOfBuyer(), addBuyerForm.getFirstNameOfRepresentative(),
				addBuyerForm.getLastNameOfRepresentative(), addBuyerForm.getAddress(), addBuyerForm.getTelNumber()));
		return "redirect:/buyers";
	}

	@GetMapping(value = { "/deleteBuyer" })
	public String showDeleteStudentView(Model model) {
		DeleteBuyerForm deleteBuyerForm = new DeleteBuyerForm();
		model.addAttribute("deleteBuyerForm", deleteBuyerForm);
		return "deleteBuyerPage";
	}

	@PostMapping(value = { "/deleteBuyer" })
	public String deleteBuyer(Model model, DeleteBuyerForm deleteBuyerForm) throws SQLException {
		dao.deleteBuyer(deleteBuyerForm.getNameOfBuyer());
		return "redirect:/buyers";
	}

	@GetMapping(value = { "/buyersByName" })
	public String showFindBuyerByNameView(Model model) {
		FindBuyerByNameForm findBuyerByNameForm = new FindBuyerByNameForm();
		model.addAttribute("findBuyerByNameForm", findBuyerByNameForm);
		return "findBuyerByNamePage";
	}

	@PostMapping(value = { "/buyersByName" })
	public String findBuyerByName(Model model, FindBuyerByNameForm findBuyerByNameForm) throws SQLException {
		List<Buyer> list = dao.findBuyerByName(findBuyerByNameForm.getNameOfBuyer());
		model.addAttribute("allBuyers", list);
		return "buyersPage";
	}

}

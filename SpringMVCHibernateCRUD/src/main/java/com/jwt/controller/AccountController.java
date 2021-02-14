package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.model.Account;
import com.jwt.model.LoginForms;
import com.jwt.service.AccountService;

@Controller
public class AccountController {

	private static final Logger logger = Logger
			.getLogger(AccountController.class);

	
	@Autowired
	private AccountService accountService;
	
	//login by naveen
	@RequestMapping(value = "/")
	public ModelAndView dashboard(ModelAndView model) throws IOException {
		model.addObject("loginforms", new LoginForms());
		model.setViewName("login");
		return model;
	}

	//validation for useer and admin
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView admindashboard(@ModelAttribute LoginForms loginforms) {
		ModelAndView mav=null;
		//boolean authenticated=false;
		if(loginforms.getEmail().equals("admin@gmail.com") &&loginforms.getPass().equals("admin")) 
			mav= new ModelAndView("redirect:/adminHome");
		//authenticated=accountService.authenticateUserLogin(loginforms.getEmail(),loginforms.getPass());
		else if(accountService.authenticateUserLogin(loginforms.getEmail(),loginforms.getPass())) 
			mav= new ModelAndView("redirect:/userHome/"+loginforms.getEmail()+"/");
		else
			mav= new ModelAndView("redirect:/");
		return mav;
	}
	//accountService.authenticateUserLogin(loginforms.getEmail(),loginforms.getPass());
	
	//user dashboard
	@RequestMapping(value = "/userHome/{email}/", method = RequestMethod.GET)
	public ModelAndView userHome(ModelAndView model,@PathVariable String email) {
		System.out.println(email);
		List<Account> listOfAccount=accountService.getUserByEmail(email);
		model.addObject("listOfAccount", listOfAccount);
		model.setViewName("userHome");
		return model;
	}
	
	//admin home
	@RequestMapping(value = "/adminHome")
	public ModelAndView listAccounts(ModelAndView model) throws IOException {
		List<Account> listAccount = accountService.getAllAccount();
		model.addObject("listAccount", listAccount);
		model.setViewName("adminHome");
		return model;
	}
	//accountService.authenticateUser

	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Account account = new Account();
		model.addObject("account", account);
		model.setViewName("AccountForm");
		return model;
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Account account) {
		if (account.getAc_no() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			accountService.addAccount(account);
		} else {
			accountService.updateAccount(account);
		}
		return new ModelAndView("redirect:/adminHome");
	}


	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int ac_no = Integer.parseInt(request.getParameter("ac_no"));
		Account account = accountService.getAccount(ac_no);
		ModelAndView model = new ModelAndView("AccountForm");
		model.addObject("account", account);

		return model;
	}
	
	
//	@RequestMapping(value = "/withdraw/${account.ac_no}/${account.balance}", method = RequestMethod.GET)
//	public ModelAndView withdraw(ModelAndView model,@PathVariable String ac_no,@PathVariable String balance) {
//		String acno=new String(ac_no);
//		Integer bal=new Integer(balance);
//		model.addObject("ac_no", acno);
//		model.addObject("ac_no", bal);
//		model.setViewName("withdrowDashboards");
//		return model;
//	}
//	
//	
//		@RequestMapping(value = "/withdraw/${ac_no}/${balance}/${withrawn}", method = RequestMethod.POST)
//		public ModelAndView withdraw(ModelAndView model,@PathVariable String ac_no,@PathVariable String balance,@PathVariable String withrawn) {
//		System.out.println(withrawn);
//		return new ModelAndView("redirect:/adminHome");
//	}

	
}
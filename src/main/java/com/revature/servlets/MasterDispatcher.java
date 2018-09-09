package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ErsReimbTypeService;
import com.revature.service.ErsReimbursementService;
import com.revature.service.ErsUserService;

public class MasterDispatcher {
	private MasterDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
				
		switch (request.getRequestURI()) {
		case "/project1/login.ng":
			return ErsUserService.login(request, response);
//		case "/ers/logout.ng":
//			return ErsUserService.logout(request, response);
//		case "/ers/getReimbursementsByUser.ng":
//			return  ErsReimbursementService.getReimbursementsByUsername(request,response);
		case "/project1/getReimbursementsByUserId.ng":
			return  ErsReimbursementService.getReimbursementsByUserId(request,response);
		case "/project1/addReimbursement.ng":
			return ErsReimbursementService.addReimbursement(request, response);
		case "/project1/getAllReimbursements.ng":
			return ErsReimbursementService.getAllReimbursements(request, response);
		case "/project1/approveReimbursement.ng":
			ErsReimbursementService.approveReimbursement(request, response);
			return null;
		case "/project1/denyReimbursement.ng":
			ErsReimbursementService.denyReimbursement(request, response);
			return null;
		case "/project1/getAllReimbType.ng":
			return  ErsReimbTypeService.getAll();
		default:
			return "bad";
		}
	}
}

package com.cgapp.audit;

import org.springframework.data.domain.AuditorAware;

import com.cgapp.controller.LoginController;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return LoginController.loggedUser.getEmpEmail();
	}

}

package com.project.sporty_shoes.enumeration;

import static com.project.sporty_shoes.constant.Authority.ADMIN_AUTHORITIES;
import static com.project.sporty_shoes.constant.Authority.USER_AUTHORITIES;

public enum Role {
	ROLE_USER(USER_AUTHORITIES), ROLE_ADMIN(ADMIN_AUTHORITIES);

	private String[] authorities;

	Role(String... authorities) {
		this.authorities = authorities;
	}

	public String[] getAuthorities() {
		return authorities;
	}
}

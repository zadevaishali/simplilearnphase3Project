package com.project.sporty_shoes.constant;

public class Authority {
	public static final String[] USER_AUTHORITIES = {
	"shoes:read, cart:read, cart:update, cart:write, order:read, order:write, order:delete" };
public static final String[] ADMIN_AUTHORITIES = { "shoes:read, shoes:write, shoes:update, order:read" };

}

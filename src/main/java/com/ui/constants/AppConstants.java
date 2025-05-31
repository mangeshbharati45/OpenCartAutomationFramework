package com.ui.constants;

import java.util.List;

public class AppConstants {
	
	public static final int SHORT_DEFAULT_TIMEOUT = 5;
	public static final int MEDIUM_DEFAULT_TIMEOUT = 10;
	public static final int LONG_DEFAULT_TIMEOUT = 20;
	
	public static final String HOME_PAGE_TITLE = "My Account";
	public static final CharSequence REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static List<String> expectedAccountPageHeaders = List.of("My Account", 
			                                                        "My Orders", 
			                                                        "My Affiliate Account",
			                                                        "Newsletter");

}

package personallibrary.validate;

import personallibrary.model.User;

public class UserValidate {
	
	public static void validateCreateUser(final User user) throws Throwable {
		if(user != null) {
			notNull(user.getEmail());
			notNull(user.getName());
		}
		
	}
	
	
	private static void notNull(Object object) throws Throwable {
		if(object.equals(null)) {
			throw new Exception("Falta de informação para prosseguir");
		}
	}

}

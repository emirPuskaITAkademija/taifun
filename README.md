##Konfigurisati Spring Security:##
		  1. User <-> UserDetails
		  
		      UserAdapterDetails implements UserDetails 
			  UserAdapterDetailsService implements UserDetailsService
			  
			  
		  2. Mehanizam heširanja
		     05b3c324-5df6-4c27-abb0-2f76fd2b7084
			 
			 Ja hoću Bcrypt(Pbkdf2)
			 
		  3. login page -> hoću svoj

  ##Spring Security##
  
    1. pom.xml -> dependencies 
     2. /login 
	   /home
	   UserDetails - interni objekat
	   username:"user"
	   password: "05b3c324-5df6-4c27-abb0-2f76fd2b7084"
	 
3. UserDetails -> nekog našeg UserEntity 
	   
	   UserDetailsAdapter: spona između UserEntity<->UserDetails

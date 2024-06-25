## Spring MVC + Spring Security + Spring Data JPA +  Auth/Register

## Kako radi Spring MVC

    1. browser : GET http://localhost:8080/home
	2. http://localhost:8080 -> taifun
	3. http://localhost:8080/home -> DispatcherServlet
	4. /home -> HandlerMapper koji kontroller
	5. HomeController -> model. "poruke"
	4. HomeController -> ViewResolver "home"
	5. View -> "home"
	6. response -> browser "home" 

## Konfigurisati Spring Security:
		  
    1. User <-> UserDetails
		  
		      UserAdapterDetails implements UserDetails 
			  UserAdapterDetailsService implements UserDetailsService
			  
			  
    2. Mehanizam heširanja
		     05b3c324-5df6-4c27-abb0-2f76fd2b7084
			 
			 Ja hoću Bcrypt(Pbkdf2)
			 
    3. login page -> hoću svoj

  ## Spring Security
  
    1. pom.xml -> dependencies 
    2. /login 
	   /home
	   UserDetails - interni objekat
	   username:"user"
	   password: "05b3c324-5df6-4c27-abb0-2f76fd2b7084"
	 
    3. UserDetails -> nekog našeg UserEntity 
	   
	   UserDetailsAdapter: spona između UserEntity<->UserDetails

  ## CI/CD  
  ### CI(Continuous Integration-Jenkins) 
  ### CD(Continuous Deployment - FluxCD or ArgoCD for K8s config)

		-> CI alat : Jenkins                git url 
		   Jenkins.file 
		     - stage 1 ->                   Taifun
											feature1
											-> master
			git clone "GIT_URL"
			 - stage 2       mvn clean install 
			 junit test 
			 
						taifun-1.1.jar 
			 - stage 3 
						build Docker image 
						publish Docket image na neki repository
			 - stage 4 
			            GitOPS 
			            FluxCD /ArgoCD
						git repository 
						1.0 -> 1.1
						deployment.yaml -> version: 1.1
						
		k8s -> zero downtime 
		   
		   pull Docker image 
		         instance1 -> pod 
				 instance2 -> pod 
				 
				 kubectl scale taifun 5
				 
				 instance1 -> pod
				 instance2 -> pod 
				 instance3 -> pod 
				 instance4 -> pod 


### DB migraton tool (Flyway or Liquibase)
	  Spring
	    resources
		  v1__user_DDL.sql 
		  v2__product_DDL.sql
		  v3__employee_DDL.sql 
		  v4__user_DML.sql
		  
		  Spring -> start 
		    flyway_schema_history
			v1 checksum
			v2 checksum
			v3 

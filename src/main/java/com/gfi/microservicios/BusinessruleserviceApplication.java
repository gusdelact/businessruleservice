package com.gfi.microservicios;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gfi.microservicios.model.Item;

@SpringBootApplication
public class BusinessruleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessruleserviceApplication.class, args);
		
		 System.out.println( "Bootstrapping the Rule Engine ..." );
		    //1) Bootstrapping a Rule Engine Session
		    KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
		    KieSession kSession =  kContainer.newKieSession();
		        
		    Item item = new Item("A", 123.0f,234.0f);  
		    System.out.println( "Item Category: " + item.getCategory());
		    //2) Provide information to the Rule Engine Context
		    kSession.insert(item);
		    //3) Execute the rules that are matching
		    int fired = kSession.fireAllRules();
		    System.out.println( "Number of Rules executed = " + fired );
		    System.out.println( "Item Category: " + item.getCategory());
	}
}

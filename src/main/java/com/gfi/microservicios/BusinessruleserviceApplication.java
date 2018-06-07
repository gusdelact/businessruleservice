package com.gfi.microservicios;

import java.io.PrintStream;

import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gfi.microservicios.model.Item;

@SpringBootApplication
public class BusinessruleserviceApplication {



	private KieSession kSession;

	public void boot() {
		System.out.println( "Bootstrapping the Rule Engine ..." );
		//1) Bootstrapping a Rule Engine Session
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		this.kSession =  kContainer.newKieSession();
	}
	public  void go(PrintStream out){
		Item item = new Item("A", 123.0f,234.0f);
		out.println( "Item Category: " + item.getCategory());
		kSession.insert(item);
		int fired = kSession.fireAllRules();
		out.println( "Number of Rules executed = " + fired );
		out.println( "Item Category: " + item.getCategory());
	}

	public static void main(String[] args) {
		SpringApplication.run(BusinessruleserviceApplication.class, args);

		BusinessruleserviceApplication bsrApp = new BusinessruleserviceApplication() ;
		bsrApp.boot();
		bsrApp.go(System.out);
	}
}

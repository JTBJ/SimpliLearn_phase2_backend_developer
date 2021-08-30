package com.component.mapping.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		
			StandardServiceRegistry standardRegistry = 
					new StandardServiceRegistryBuilder()
					.configure("bigmap.cfg.xml")
					.build();

			Metadata metadata = new MetadataSources(standardRegistry)
					.getMetadataBuilder()
					.build();

			factory = metadata.getSessionFactoryBuilder().build();
		
		return factory;
	}
}

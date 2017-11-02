import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersonaManager {

	protected SessionFactory sessionFactory;
	
	protected void setup() {
        // code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        .configure() // configures settings from hibernate.cfg.xml
		        .build();
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
		    StandardServiceRegistryBuilder.destroy(registry);
		}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    }
 
 
    protected void create(String nombre, String telefono) { // puede recibir datos desde otras clases 
    	  Persona p = new Persona();
    	    p.setNombre(""+nombre);
    	    p.setTelefono(""+telefono);
    	   
    	    Session session = sessionFactory.openSession();
    	    session.beginTransaction();
    	 
    	    session.save(p);
    	 
    	    session.getTransaction().commit();
    	    session.close();
    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void registrar() {
    	PersonaManager pm = new PersonaManager();
    	
    	pm.setup();
    	 pm.create("Alberto", "456");
        pm.exit();
    }
	
}

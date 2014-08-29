package exemplu;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
 


import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.realm.RealmBase;
 
public class MyRealm extends RealmBase {
 
  @Override
  protected String getName() {
	  System.out.println("succes");
    return this.getClass().getSimpleName();
  }
 
  @Override
  protected String getPassword(final String username) {
	  int k=0;
	  final List<String> usernames = new ArrayList<String>();
	  final List<String> passwords = new ArrayList<String>();
	  
	  DataBase db = new DataBase();
	  System.out.println("succes1");

			try {
				for (int i=1;i<3;i++) {
				usernames.add(db.readExl(1,i));
				passwords.add(db.readExl(2,i));
				}
			} catch (IOException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
		  
		  for (int i=0;i<2;i++)
			  if (usernames.get(i).equals(username)) {
		          k=i;
              }
		  System.out.println(passwords.get(k));
                 return passwords.get(k);
	
  }
 
  @Override
  protected Principal getPrincipal(final String username) {  
    int k=0; 
	final List<String> roles = new ArrayList<String>();
	final List<String> roles1 = new ArrayList<String>();
	final List<String> usernames = new ArrayList<String>();
	
	DataBase db = new DataBase();
	MyRealm m = new MyRealm();
	System.out.println("succes2");
	
    try {
    	for (int i=1;i<3;i++) {
		roles.add(db.readExl(0,i));
    	}
	} catch (IOException e) {
		e.printStackTrace();
	}
    
    for (int i=0;i<2;i++)
		  if (usernames.get(i).equals(username)) {
	          k=i;
        }
    
    roles1.add(roles.get(k));
    
    return new GenericPrincipal(username, m.getPassword(username), roles1);
  }
}
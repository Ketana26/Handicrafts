package com.sd.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.model.UserDetails;
@Repository
public class UserDetailsDaoImpl implements UserDetailDaoInt {
@Autowired
private SessionFactory sessionFactory;

public String addUser(UserDetails ud) {
	
		Session ses=sessionFactory.openSession();
		ud.setUserid(generateUserId());
		ses.save(ud);
		ses.flush();
		ses.close();
		//saveUserImage(ud);
		return ud.getUserid();
      
	}
		


	@SuppressWarnings("unchecked")
	private String generateUserId(){
		String newUid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from UserDetails");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
			newUid="USR00001";
		}			
		else {		// if table is not empty	
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(userid) from UserDetails");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}	
		return newUid;			
	}	/*
private void saveUserImage(UserDetails ud){
		
		System.out.print("\nprd img : " + ud.getUserImage());	
			
		try{				    	
			if (ud.getUserImage() != null ) {	
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\resources\images\products
				
	           //Path path=Paths.get("C://DT-22-Workspace//project1//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");	
				Path path=Paths.get("F://Workspace-DT//serdao//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");
	           	ud.getUserImage().transferTo(new File(path.toString()));                       	
	            System.out.print("\nUser Image saved");	            
	        }				
		}
		catch(Exception ex){
			System.out.print("\nUser Image not saved...");
		}				
	}	*/
	
}



package com.sd.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.model.Supplier;
import com.sd.model.UserDetails;

@Repository
public class SupplierDaoImpl implements SupplierDaoInt {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSupplier(Supplier sup) {
		Session ses = sessionFactory.openSession();
		sup.setSupplierid(generateSupplierID());
		ses.save(sup);
		ses.flush();
		ses.close();
		saveSupplierImage(sup);
	}

	public List<Supplier> getAllSuppliers() {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from Supplier");
		List<Supplier> data = qr.list();
		ses.close();
		return data;
	}

	public Supplier getSupplierById(String supid) {
		Session ses = sessionFactory.openSession();
		Supplier sup = (Supplier)ses.get(Supplier.class, supid);
		ses.close();
		return sup;
	}

	public void editSupplier(Supplier sup) {
		Session ses = sessionFactory.openSession();
		ses.update(sup);
		ses.flush();
		ses.close();
	}

	public void deleteSupplier(String supid) {
		Session ses = sessionFactory.openSession();
		Supplier sup = (Supplier)ses.get(Supplier.class, supid);
		ses.delete(sup);
		ses.flush();
		ses.close();
	}

	private String generateSupplierID() {

		String newSid = "";
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Supplier");
		List<UserDetails> data = qr.list();
		s.close();
		if (data.size() == 0) { // if table is empty
			newSid = "SUP00001";
		} else { // if table is not empty
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(supplierid) from Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newSid = "SUP0000" + id;
			else if (id <= 99)
				newSid = "SUP000" + id;
			else if (id <= 999)
				newSid = "SUP00" + id;
			else if (id <= 9999)
				newSid = "SUP0" + id;
			else
				newSid = "SUP" + id;
			System.out.print("\nGenerated : " + newSid);
			ss.close();
		}
		return newSid;
	}

	private void saveSupplierImage(Supplier sup) {

		System.out.print("\nprd img : " + sup.getSupplierImage());

		try {
			if (sup.getSupplierImage() != null) {
				// C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\
				// C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\resources\images\products

				// Path
				// path=Paths.get("C://DT-22-Workspace//project1//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");
				Path path = Paths
						.get("F://Workspace-DT//serdao//src//main//webapp//resources//images//suppliers//"
								+ sup.getSupplierid() + ".jpg");
				sup.getSupplierImage().transferTo(new File(path.toString()));
				System.out.print("\nUser Image saved");
			}
		} catch (Exception ex) {
			System.out.print("\nUser Image not saved...");
		}
	}

}

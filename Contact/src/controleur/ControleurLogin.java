package controleur;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.model.UploadedFile;

@ManagedBean(name="controleurLogin")
@RequestScoped
@SessionScoped
public class ControleurLogin implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String login;
	public ArrayList<Contact> contact  =new ArrayList<Contact>();
	public ArrayList<Contact> contact1  =new ArrayList<Contact>();
	public UploadedFile file;
	public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        List<String> p=classu.Util.bytesToStringList(file.getContents());;
        for(String l: p) {
			l=l.replace("\"", "");
			String r[]=l.split(",");
		    String nom=r[0];
		    String tel=r[1];
		    String mail=r[2];
		    Contact co=new Contact(nom, tel, mail);
		    contact1.add(co);
		    init();
		}
    }
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	@PostConstruct
	public void init() {
		this.listC();
		contact=contact1;
	}
	
	public void listC() {
		
		Contact c= new Contact("Lamine mohamed", "0669970196", "tcheklamine@gmail.com");
		contact1.add(c);
		c= new Contact("Mehdi", "066997090", "mehdi@gmail.com");
		contact1.add(c);
		c= new Contact("Moad", "066997090", "moad@gmail.com");
		contact1.add(c);
		c= new Contact("imane", "0669973090", "imane@gmail.com");
		contact1.add(c);
		 
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Contact> getContact() {
		return contact;
	}
	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String mdp;
	public String login() {
		return "login.xhtml";
	}
}

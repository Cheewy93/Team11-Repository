package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import manager.DBManager;
import manager.JPAUtil;
import model.Information;

@ManagedBean
@RequestScoped
public class InformationManagedBean {

	private Information info = new Information();
	EntityManager em = JPAUtil.getEntityManager();

	public void addInformation(){
		boolean ok = new DBManager().saveInformation(em, info);
		if (ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Uspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Neuspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}
}

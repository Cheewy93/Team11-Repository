package beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import manager.DBManager;
import manager.JPAUtil;
import model.Impression;

@ManagedBean
@RequestScoped
public class ImpressionManagedBean {
	
	@ManagedProperty(value="#{bookManagedBean}")
	private BookManagedBean bmb;

	private List<Impression> impressions;
	private Impression impression = new Impression();
	EntityManager em = JPAUtil.getEntityManager();
	
	@PostConstruct
    public void init() {
		impressions =  new DBManager().getImpressionsForBook(em , bmb.getSelectedBook());
    }
	
	public ImpressionManagedBean(){
		
	}
	
	public String addImpression() {
		impression.setBook(bmb.getSelectedBook());
		impression.setDate(new Date());
		impression.setUser(bmb.getLmb().getCurrentUser());
		boolean ok = new DBManager().saveImpression(em, impression);
		if (ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Uspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Neuspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	
	public List<Impression> getImpressions() {
		return impressions;
	}

	public void setImpressions(List<Impression> impressions) {
		this.impressions = impressions;
	}
	public BookManagedBean getBmb() {
		return bmb;
	}

	public void setBmb(BookManagedBean bmb) {
		this.bmb = bmb;
	}

	public Impression getImpression() {
		return impression;
	}

	public void setImpression(Impression impression) {
		this.impression = impression;
	}
}

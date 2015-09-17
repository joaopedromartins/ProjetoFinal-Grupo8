package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;



@Named
@SessionScoped
public class JobApplicationBean implements Serializable {
	private static final long serialVersionUID = 1L;


	@EJB
	private IJobApplicationFacade jobApplicationFacade;
	
	@EJB
	private ICandidateFacade candidateFacade;
	
	@Inject
	private LoginBean loginBean;
	
	private String address;
	private String city;
	private String country;
	private BigInteger phone;
	private String diploma;
	private String school;
	private String letter; 
	private String cv;
	private String source;
	private String status;
	
	private IPositionProxy positionProxy;
	
	/*private String uploadDirectory="/cv/";*/
	
	
	//constructors
	public JobApplicationBean() {
	}

	//Getters e Setters

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public IPositionProxy getPositionProxy() {
		return positionProxy;
	}
	public void setPositionProxy(IPositionProxy positionProxy) {
		this.positionProxy = positionProxy;
	}
	
	
	//methods
	public String applyPosition() {
		return "/pages/candidate/applyPosition?faces-redirect=true";
	}
	
	public String applyJobApplication() {
		IJobApplicationProxy proxy;
		proxy=jobApplicationFacade.createNewJobApplication(
				 address,  city,  country, phone, diploma,
				 school,  letter,  cv, source, status, loginBean.getUser(), positionProxy);
		if(proxy!=null){
			address=null;
			city=null;
			country=null;
			phone=null;
			diploma=null;
			school=null;
			letter=null; 
			cv=null;
			source=null;
			status=null;
						
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Job Position applied successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			// vai para a pagina ver candidaturas
			return "/pages/candidate/candidate";
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error applying job position.\nPlease check if you applied already to this position.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			//Volta à mesma pagina
			return "/pages/candidate/applyPosition";
		}
	}
	
	
//	private void redirect(String path){
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
//        
//        try {
//            response.sendRedirect(request.getContextPath()+path);
//        } catch (IOException e) {
//            // Redirection error
//            e.printStackTrace();
//        }
//    }
	
	public void upload(FileUploadEvent event ) {  
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file        
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			// TODO send to logger
			System.out.println(e.getMessage());
		}
	}  

	
	public void copyFile(String fileName, InputStream in) {
		try {
			String filePrefix = /*uploadDirectory +*/ positionProxy.getCode() + "_CV_" + loginBean.getUser().getUsername() + "_";
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File("./cv", filePrefix + fileName));
			

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();
			// TODO send to logger
			System.out.println("New file created!");
			this.cv = "./cv/" + filePrefix + fileName;
		} catch (IOException e) {
			// TODO send to logger
			System.out.println(e.getMessage());
		}
	}

}	

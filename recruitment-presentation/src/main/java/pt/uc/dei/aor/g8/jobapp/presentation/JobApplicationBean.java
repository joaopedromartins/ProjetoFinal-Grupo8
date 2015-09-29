package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobAdversitingChanelFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;



@Named
@SessionScoped
public class JobApplicationBean implements Serializable {
	private static final long serialVersionUID = 1L;


	@EJB
	private IJobApplicationFacade jobApplicationFacade;
	
	@EJB
	private ICandidateFacade candidateFacade;
	
	@EJB 
	private IJobAdversitingChanelFacade jobAdvertisingChanelFacade;
	
	@Inject
	private LoginBean loginBean;
	
	private String address;
	private String city;
	private String country;
	private String phone;
	private String diploma;
	private String school;
	private String letter; 
	private String cv;
	private String source;
	private JobAppSituation situation;
	
	private IPositionProxy positionProxy;
	
	private IJobApplicationProxy jobApplicationProxy;
	
	private DefaultStreamedContent download;
	
	private String uploadDirectory="./cv";
	private String uploadedfilename="";
	
	private List<IJobAdvertisingChanelProxy> allJobAdvertisingChanel;
	
	
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

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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

	public JobAppSituation getStatus() {
		return situation;
	}
	public void setStatus(JobAppSituation status) {
		this.situation = status;
	}

	
	public IPositionProxy getPositionProxy() {
		return positionProxy;
	}
	public void setPositionProxy(IPositionProxy positionProxy) {
		this.positionProxy = positionProxy;
	}
	
	
	public IJobApplicationProxy getJobApplicationProxy() {
		return jobApplicationProxy;
	}
	public void setJobApplicationProxy(IJobApplicationProxy jobApplicationProxy) {
		this.jobApplicationProxy = jobApplicationProxy;
	}
	
	public DefaultStreamedContent getDownload() throws Exception {
	    System.out.println("GET = " + download.getName());
	    return download;
	}
	public void setDownload(DefaultStreamedContent download) {
	    this.download = download;
	}

	
	public String getUploadedfilename() {
		return uploadedfilename;
	}
	public void setUploadedfilename(String uploadedfilename) {
		this.uploadedfilename = uploadedfilename;
	}

	public List<IJobAdvertisingChanelProxy> getAllJobAdvertisingChanel() {
		if (allJobAdvertisingChanel==null) {
			this.allJobAdvertisingChanel = jobAdvertisingChanelFacade.listOfAllChanel();
		}
		return allJobAdvertisingChanel;
	}

	

	//methods
	public String applyPosition() {
		return "/pages/candidate/applyPosition?faces-redirect=true";
	}
	
	public String applyJobApplication() {
		IJobApplicationProxy proxy;
		proxy=jobApplicationFacade.createNewJobApplication(
				 address,  city,  country, phone, diploma,
				 school,  letter,  cv, source, loginBean.getCandidate(), positionProxy);
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
			situation=null;
			uploadedfilename="";
						
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
	
	
	public String applySpontaneousJobApplication() {
		IJobApplicationProxy proxy;
		proxy=jobApplicationFacade.creatSpontaneousJobApplication(address,  city,  country, phone, diploma,
				 school,  letter,  cv, source, loginBean.getCandidate());
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
			situation=null;
			uploadedfilename="";
						
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
	
	

	public void editJobApplication() {
		// TODO logger edit job application
		System.out.println("\n---------------------");
		System.out.println("Edit Job Application:");
		System.out.println("---------------------");
		if (jobApplicationProxy!=null) {
			System.out.println("Address: \t"+jobApplicationProxy.getAddress() );
			System.out.println("City: \t"+jobApplicationProxy.getCity() );
			System.out.println("Country: \t"+jobApplicationProxy.getCountry() );
			System.out.println("Phone: \t"+jobApplicationProxy.getPhone() );
			System.out.println("Diploma: \t"+jobApplicationProxy.getDiploma() );
			System.out.println("School: \t"+jobApplicationProxy.getSchool() );
			System.out.println("Letter: \t"+jobApplicationProxy.getLetter() );
			System.out.println("CV: \t"+jobApplicationProxy.getCv() );
			System.out.println("Source: \t"+jobApplicationProxy.getSource() );
			System.out.println("\n");

			IJobApplicationProxy proxy;
			proxy=jobApplicationFacade.editJobApplication(jobApplicationProxy);
			if(proxy!=null){
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Job Position updated successfully.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				this.uploadedfilename="";
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Error updating job position.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
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
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filePrefix = positionProxy.getCode() + "_CV_" + loginBean.getCandidate().getUsername() + "_" + timeStamp + "_";
		this.uploadedfilename=event.getFile().getFileName();
		// Do what you want with the file        
		try {
			copyFile(uploadDirectory, filePrefix + uploadedfilename, event.getFile().getInputstream());

			this.cv = uploadDirectory + "/" + filePrefix + uploadedfilename;
			
		} catch (IOException e) {
			// TODO send to logger
			System.out.println(e.getMessage());
		}
	}  

	
	public void copyFile(String uploadDirectory, String fileName, InputStream in) {
		try {
			
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(uploadDirectory , fileName));
			

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
		} catch (IOException e) {
			// TODO send to logger
			System.out.println(e.getMessage());
		}
	}
	
	public void editUploadedFile(FileUploadEvent event ) {  
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filePrefix = positionProxy.getCode() + "_CV_" + loginBean.getCandidate().getUsername() + "_" + timeStamp + "_";
		this.uploadedfilename=event.getFile().getFileName();
		// Do what you want with the file        
		try {
			copyFile(uploadDirectory, filePrefix + uploadedfilename, event.getFile().getInputstream());

			this.jobApplicationProxy.setCv(uploadDirectory + "/" + filePrefix + uploadedfilename);
			
		} catch (IOException e) {
			// TODO send to logger
			System.out.println(e.getMessage());
		}
	}  
		

	public void prepDownload(){
		try {
			File file = new File( jobApplicationProxy.getCv() );
		    InputStream input;
			input = new FileInputStream(file);
		    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public List<IJobApplicationProxy> listOfCandidateJobApplication(){
		return jobApplicationFacade.listOfJobApplicationByUsername(loginBean.getUsername());
	}
	
	
	
}	

package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;

@Named
@ViewScoped
public class DownloadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DefaultStreamedContent download;



	public DownloadBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DefaultStreamedContent getDownload() throws Exception {
		return download;
	}
	public void setDownload(DefaultStreamedContent download) {
		this.download = download;
	}

	public void prepDownload(IJobApplicationProxy ja){
		try {
			File file = new File( ja.getCv() );
			InputStream input;
			input = new FileInputStream(file);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));

		} catch (FileNotFoundException e) {

		}
	}

}

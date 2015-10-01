package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class LayoutBean implements Serializable {
	private static final long serialVersionUID = 2659606888995054385L;
	private static final Logger log = LoggerFactory.getLogger(LayoutBean.class);
	
	private String companyInfoText= new String(
			"Fundada em 1998, esta empresa de Software é especializada no desenvolvimento " +
			"de soluções de software e serviços de engenharia de informação, " +
			"para o suporte de sistemas críticos orientados à segurança, " +
			"missão e ao negócio de empresas.\n" +
			"Ajudamos os nossos clientes a assegurar que os seus processos críticos " +
			"de negócio são realizados de acordo com os mais exigentes padrões de " +
			"qualidade no que respeita à segurança do software, " +
			"ao desempenho e à fiabilidade.\n" +
			"Os nossos produtos e serviços também fornecem aos clientes a informação " +
			"necessária para a gestão eficiente e segura dos seus ativos importantes, " +
			"ajudando-os a alcançar um melhor desempenho nos negócios.");
	
	private String companyInfoTextTitle = new String("About our Company");
	
	private String backgroundColour = "000000";
	private String textColour = "FFFFFF";
	private String titleTextColour = "0F0F0F";
	
	// Getters and Setters
	
	public String getCompanyInfoText() {
		return companyInfoText;
	}
	
	
	public String getCompanyInfoTextTitle() {
		return companyInfoTextTitle;
	}


	public String getBackgroundColour() {
		return backgroundColour;
	}


	public String getTextColour() {
		return textColour;
	}


	public String getTitleTextColour() {
		return titleTextColour;
	}
	
	
	

	
	//methods
	
	
}


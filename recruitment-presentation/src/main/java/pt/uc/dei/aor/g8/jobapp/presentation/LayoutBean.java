package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.LayoutTheme;

@Named
@RequestScoped
public class LayoutBean implements Serializable {
	private static final long serialVersionUID = 2659606888995054385L;
	private static final Logger log = LoggerFactory.getLogger(LayoutBean.class);
	
	private String companyInfoText= new String(
			"Founded in 1998, this software company specialized in developing software " +
			"solutions and information engineering, to support critical systems-oriented " +
			"security, mission and business enterprises.  \n" +
			"We help our customers ensure that their critical business processes are performed " +
			"according to the highest quality standards with regard to software security, " +
			"performance and reliability. \n " +
			"Our products and services also provide customers with the information necessary " +
			"for the safe and efficient management of their important assets, helping them to " +
			"achieve better business performance." );
	
	private String companyInfoTextTitle = new String("About our Company");
	
	private String backgroundColour = "000000";
	private String textColour = "FFFFFF";
	private String titleTextColour = "0F0F0F";
	
	private LayoutTheme theme;
	
	private List<Theme> themes;
    
	   
	  
	
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


	public LayoutTheme getTheme() {
		if (theme==null) {
			// TODO ler da base de dados
			theme=LayoutTheme.bootstrap;
		}
		return theme;
	}


	public void setTheme(LayoutTheme theme) {
		this.theme = theme;
		//persistir tema em admin
		// actualizar thema no layout
	}


	public String getTitleTextColour() {
		return titleTextColour;
	}


	
	public List<Theme> getThemes() {
		if (themes.isEmpty()) {
			init();
		}
		return themes;
	} 
	
	
	//methods
	
	@PostConstruct
	public void init() {
		themes = new ArrayList<Theme>();
		themes.add(new Theme(0, "Afterdark", "afterdark"));
		themes.add(new Theme(1, "Afternoon", "afternoon"));
		themes.add(new Theme(2, "Afterwork", "afterwork"));
		themes.add(new Theme(3, "Aristo", "aristo"));
		themes.add(new Theme(4, "Black-Tie", "black-tie"));
		themes.add(new Theme(5, "Blitzer", "blitzer"));
		themes.add(new Theme(6, "Bluesky", "bluesky"));
		themes.add(new Theme(7, "Bootstrap", "bootstrap"));
		themes.add(new Theme(8, "Casablanca", "casablanca"));
		themes.add(new Theme(9, "Cupertino", "cupertino"));
		themes.add(new Theme(10, "Cruze", "cruze"));
		themes.add(new Theme(11, "Dark-Hive", "dark-hive"));
		themes.add(new Theme(12, "Delta", "delta"));
		themes.add(new Theme(13, "Dot-Luv", "dot-luv"));
		themes.add(new Theme(14, "Eggplant", "eggplant"));
		themes.add(new Theme(15, "Excite-Bike", "excite-bike"));
		themes.add(new Theme(16, "Flick", "flick"));
		themes.add(new Theme(17, "Glass-X", "glass-x"));
		themes.add(new Theme(18, "Home", "home"));
		themes.add(new Theme(19, "Hot-Sneaks", "hot-sneaks"));
		themes.add(new Theme(20, "Humanity", "humanity"));
		themes.add(new Theme(21, "Le-Frog", "le-frog"));
		themes.add(new Theme(22, "Midnight", "midnight"));
		themes.add(new Theme(23, "Mint-Choc", "mint-choc"));
		themes.add(new Theme(24, "Overcast", "overcast"));
		themes.add(new Theme(25, "Pepper-Grinder", "pepper-grinder"));
		themes.add(new Theme(26, "Redmond", "redmond"));
		themes.add(new Theme(27, "Rocket", "rocket"));
		themes.add(new Theme(28, "Sam", "sam"));
		themes.add(new Theme(29, "Smoothness", "smoothness"));
		themes.add(new Theme(30, "South-Street", "south-street"));
		themes.add(new Theme(31, "Start", "start"));
		themes.add(new Theme(32, "Sunny", "sunny"));
		themes.add(new Theme(33, "Swanky-Purse", "swanky-purse"));
		themes.add(new Theme(34, "Trontastic", "trontastic"));
		themes.add(new Theme(35, "UI-Darkness", "ui-darkness"));
		themes.add(new Theme(36, "UI-Lightness", "ui-lightness"));
		themes.add(new Theme(37, "Vader", "vader"));
	}
	    
	
}


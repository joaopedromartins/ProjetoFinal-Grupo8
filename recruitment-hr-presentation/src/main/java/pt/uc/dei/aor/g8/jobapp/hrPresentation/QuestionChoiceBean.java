package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IQuestionChoiceFacade;

@Named
@ViewScoped
public class QuestionChoiceBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IQuestionChoiceFacade facade;
	private String option = "";
	private String optionNew;
	private List <IQuestionChoiceProxy> options;
	//private List <String> optionsChoice;

	public QuestionChoiceBean() {
	}


	public QuestionChoiceBean(String option) {
		this.option = option;
	}

	

	public String getOptionNew() {
		return optionNew;
	}


	public void setOptionNew(String optionNew) {
		this.optionNew = optionNew;
	}


	public List<IQuestionChoiceProxy> getOptions() {
		return options;
	}

	public void setOptions(List<IQuestionChoiceProxy> options) {
		this.options = options;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void addOptionToList (){
		if (options == null){
			options = new ArrayList<>();	
		}
		options.add(facade.newChoice(option)) ;
		this.option="";

	}
}

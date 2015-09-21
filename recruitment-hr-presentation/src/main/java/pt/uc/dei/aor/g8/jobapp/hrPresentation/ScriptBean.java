package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ReorderEvent;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IScriptFacade;

@Named
@ViewScoped
public class ScriptBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IScriptFacade facade;

	private String title = "Untitled Script";
	private List<IQuestionProxy> questions;

	private IScriptProxy   script;

	private boolean addQuestion=false; 

	private String question;
	private QuestionType questionType =QuestionType.TEXT;

	@Inject
	private QuestionScaleBean scale;
	@Inject
	private QuestionChoiceBean options;



	public ScriptBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String initialNewScript (){
		this.script = facade.initialNewScript();
		return "/administrator/addScript?faces-redirect=true";
	}


	public void changeQuestionType (){
		this.options.setOptions(new ArrayList<>());
		this.question = null;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		

		this.title = title;
	}


	public void verifyTitle() {
		IScriptProxy proxy = facade.findTitleOfScript(title);
		if (proxy == null && !(("Untitled Script").equals(title))){
			this.script.setScriptTitle(title);
		} else  {
			if ( script.getScriptTitle() == null){
				this.title = "Untitled Script"; 
			} else {
				this.title = script.getScriptTitle();
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The title of Script already exist. Change title.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public boolean isAddQuestion() {
		return addQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<IQuestionProxy> getQuestions() {
		return questions;
	}

	public void setQuestions(List<IQuestionProxy> questions) {
		this.questions = questions;
	}

	public List<QuestionType> getPossibleQuestionType (){
		return Arrays.asList(QuestionType.values());
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public List<IScriptProxy> getScripts() {
		return facade.listOfAllScripts();
	}


	public IScriptProxy getScript() {
		if ( script != null ){
			return script;
		} else {
			this.script=facade.initialNewScript();
			return script;
		}

	}
	public void setScript(IScriptProxy script) {
		this.script = script;
	}

	public void addQuestionToScript (){
		if(("Untitled Script").equals(title)|| title == null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Write title of Script.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			if ( questionType == QuestionType.SCALE){
				this.script = facade.addQuestionToScript(script, question, questionType,
						scale.getMin(), scale.getMax(), scale.getMinLabel(), scale.getMaxLabel());
			
			} else if ( questionType == QuestionType.CHECKBOXES || questionType == QuestionType.MULTIPLECHOICE ||
					questionType == QuestionType.CHOOSEFROMLIST){
				if(options.getOptions().size() >= 2){
					this.script = facade.addQuestionToScript(script, question, questionType, 
							options.getOptions());
					
				} else{
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Add, at least, two options.", "");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}

			} else {
				this.script = facade.addQuestionToScript(script, question, questionType);
			}
			this.addQuestion = false;
		}

	}

	public void showPanelAddQuestion(){
		this.addQuestion = true;
	}

	public List<Integer> getScaleValues(IQuestionProxy question){
		int max = question.getScale().getMaximum();
		int min = question.getScale().getMinimum();
		List<Integer> scale = new ArrayList<>();
		for (int i = min; i<= max ; i++){
			scale.add(i);
		}
		return scale;
	}

	public void deleteQuestion (IQuestionProxy questionDelete){
		System.out.println(questionDelete.getOrderNumber());
		this.script = facade.deleteQuestion(this.script, questionDelete);
	}

	public void onRowReorder(ReorderEvent event) {
		int fromRow = event.getFromIndex() + 1;
		int toRow  = event.getToIndex() + 1;

		this.script = facade.changeOrderOfQuestion (this.script, fromRow, toRow);

	}

}

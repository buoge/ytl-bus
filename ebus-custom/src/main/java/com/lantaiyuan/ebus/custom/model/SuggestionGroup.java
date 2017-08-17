/**
* <p>Title: SuggestionGroup.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model;

import java.util.List;

/**
* <p>Title: SuggestionGroup</p>
* <p>Description: 自定义评价组类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月19日 下午6:10:17
*/
public class SuggestionGroup {
	private EvaluationGeneral evaluationGeneral;
	private List<Suggestion> suggestions;
	
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param evaluationGeneral
	* @param suggestionQueryModels
	*/
	public SuggestionGroup(EvaluationGeneral evaluationGeneral, List<Suggestion> suggestions) {
		this.evaluationGeneral = evaluationGeneral;
		this.suggestions = suggestions;
	}
	/**
	* @return evaluationGeneral
	*/
	public EvaluationGeneral getEvaluationGeneral() {
		return evaluationGeneral;
	}
	/**
	* @param evaluationGeneral 要设置的 evaluationGeneral
	*/
	public void setEvaluationGeneral(EvaluationGeneral evaluationGeneral) {
		this.evaluationGeneral = evaluationGeneral;
	}
	/**
	* @return suggestions
	*/
	public List<Suggestion> getSuggestions() {
		return suggestions;
	}
	/**
	* @param suggestions 要设置的 suggestions
	*/
	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}
	
}

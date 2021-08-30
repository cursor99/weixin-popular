package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

public class ActivateForm {

	@JSONField(name = "card_id")
	private String cardId;
	
	@JSONField(name = "service_statement")
	private NamedUrl serviceStatement;
	
	@JSONField(name = "bind_old_card")
	private NamedUrl bindOldCard;
	
	@JSONField(name = "required_form")
	private ActivateUserForm requiredForm;
	
	@JSONField(name = "optional_form")
	private ActivateUserForm optionForm;

	public String getCardId() {
		return cardId;
	}

	public ActivateForm setCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}

	public NamedUrl getServiceStatement() {
		return serviceStatement;
	}

	public ActivateForm setServiceStatement(NamedUrl serviceStatement) {
		this.serviceStatement = serviceStatement;
		return this;
	}

	public NamedUrl getBindOldCard() {
		return bindOldCard;
	}

	public ActivateForm setBindOldCard(NamedUrl bindOldCard) {
		this.bindOldCard = bindOldCard;
		return this;
	}

	public ActivateUserForm getRequiredForm() {
		return requiredForm;
	}

	public ActivateForm setRequiredForm(ActivateUserForm requiredForm) {
		this.requiredForm = requiredForm;
		return this;
	}

	public ActivateUserForm getOptionForm() {
		return optionForm;
	}

	public ActivateForm setOptionForm(ActivateUserForm optionForm) {
		this.optionForm = optionForm;
		return this;
	}
		
}

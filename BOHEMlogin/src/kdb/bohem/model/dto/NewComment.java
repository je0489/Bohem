package kdb.bohem.model.dto;

public class NewComment {
	private int comentIndex;
	private String comentComent;
	private String username;
	private String comentDate;
	private int userIndex;
	private int recipeIndex;
	
	public NewComment(){}

	public NewComment(int comentIndex, String comentComent, String username, String comentDate) {
		super();
		this.comentIndex = comentIndex;
		this.comentComent = comentComent;
		this.username = username;
		this.comentDate = comentDate;
	}
	
	public NewComment(int comentIndex, String comentComent, String username, String comentDate, int userIndex,
			int recipeIndex) {
		super();
		this.comentIndex = comentIndex;
		this.comentComent = comentComent;
		this.username = username;
		this.comentDate = comentDate;
		this.userIndex = userIndex;
		this.recipeIndex = recipeIndex;
	}

	public int getComentIndex() {
		return comentIndex;
	}

	public void setComentIndex(int comentIndex) {
		this.comentIndex = comentIndex;
	}

	public String getComentComent() {
		return comentComent;
	}

	public void setComentComent(String comentComent) {
		this.comentComent = comentComent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComentDate() {
		return comentDate;
	}

	public void setComentDate(String comentDate) {
		this.comentDate = comentDate;
	}

	public int getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}

	public int getRecipeIndex() {
		return recipeIndex;
	}

	public void setRecipeIndex(int recipeIndex) {
		this.recipeIndex = recipeIndex;
	}
	
	
}

package kdb.bohem.model.dto;

public class Comment {
	private int comentIndex;
	private String comentComent;
	private int userIndex;
	private int recipeIndex;
	private String comentDate;
		
	public Comment(){}
	
	//삭제할 때..
	public Comment(int comentIndex){
		this.comentIndex=comentIndex;
	}

	public Comment(int comentIndex, String comentComent, int userIndex, int recipeIndex, String comentDate) {

		this.comentIndex = comentIndex;
		this.comentComent = comentComent;
		this.userIndex = userIndex;
		this.recipeIndex = recipeIndex;
		this.comentDate = comentDate;
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

	public String getComentDate() {
		return comentDate;
	}

	public void setComentDate(String comentDate) {
		this.comentDate = comentDate;
	}

	
}
	
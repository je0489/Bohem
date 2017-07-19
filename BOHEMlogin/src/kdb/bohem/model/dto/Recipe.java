package kdb.bohem.model.dto;

public class Recipe {
	private int recipeIndex;
	private String recipeTitle;
	private String recipeContent;
	private String recipeTime;
	private int recipeView;
	private int recipeLike;
	private int userIndex;
	
	public Recipe(){}

	public Recipe(int recipeIndex, String recipeTitle, String recipeContent, String recipeTime, int recipeView,
			int recipeLike, int userIndex) {
		super();
		this.recipeIndex = recipeIndex;
		this.recipeTitle = recipeTitle;
		this.recipeContent = recipeContent;
		this.recipeTime = recipeTime;
		this.recipeView = recipeView;
		this.recipeLike = recipeLike;
		this.userIndex = userIndex;
	}

	public int getRecipeIndex() {
		return recipeIndex;
	}

	public void setRecipeIndex(int recipeIndex) {
		this.recipeIndex = recipeIndex;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeContent() {
		return recipeContent;
	}

	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}

	public String getRecipeTime() {
		return recipeTime;
	}

	public void setRecipeTime(String recipeTime) {
		this.recipeTime = recipeTime;
	}

	public int getRecipeView() {
		return recipeView;
	}

	public void setRecipeView(int recipeView) {
		this.recipeView = recipeView;
	}

	public int getRecipeLike() {
		return recipeLike;
	}

	public void setRecipeLike(int recipeLike) {
		this.recipeLike = recipeLike;
	}

	public int getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	
	
}

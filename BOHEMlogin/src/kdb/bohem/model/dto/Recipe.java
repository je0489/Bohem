package kdb.bohem.model.dto;

public class Recipe {
	private int recipeIndex;
	private String recipeTitle;
	private String recipeSrc;
	private String recipeContent;
	
	public Recipe(){}

	public Recipe(int recipeIndex, String recipeTitle, String recipeSrc, String recipeContent) {
		super();
		this.recipeIndex = recipeIndex;
		this.recipeTitle = recipeTitle;
		this.recipeSrc = recipeSrc;
		this.recipeContent = recipeContent;
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

	public String getRecipeSrc() {
		return recipeSrc;
	}

	public void setRecipeSrc(String recipeSrc) {
		this.recipeSrc = recipeSrc;
	}

	public String getRecipeContent() {
		return recipeContent;
	}

	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}
}

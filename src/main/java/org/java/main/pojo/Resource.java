package org.java.main.pojo;

public class Resource {
	private int id;
	private String title;
	
	public Resource(int id , String title) {
		setId(id);
		setTitle(title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getInfo() {
		return "Id: " + getId()
			+ "\n" + "Title: "  + getTitle();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getInfo();
	}
}

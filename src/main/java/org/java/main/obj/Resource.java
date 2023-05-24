package org.java.main.obj;

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
}

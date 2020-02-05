package com.register.marriage.love;
import java.io.File;

public class Bride {
	
	private String name;
	private long contact;
	private String job;
	private File photo;
	
	public Bride(String name, long contact, String job, File photo) {
		super();
		this.name = name;
		this.contact = contact;
		this.job = job;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Bride [name=" + name + ", contact=" + contact + ", job=" + job + ", photo=" + photo + "]";
	}
	
}

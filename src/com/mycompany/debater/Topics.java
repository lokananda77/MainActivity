package com.mycompany.debater;

public class Topics {
	private long pid;
	  private long id;
	  private String topic;

	  public long getPid() {
		    return pid;
		  }

		  public void setPid(long pid) {
		    this.pid = pid;
		  }
		  
	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String gettopic() {
	    return topic;
	  }

	  public void settopic(String topic) {
	    this.topic = topic;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return topic;
	  }
}

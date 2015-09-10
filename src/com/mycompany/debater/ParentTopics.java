package com.mycompany.debater;

public class ParentTopics {
	 private long id;
	  private String parentTopic;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getparentTopic() {
	    return parentTopic;
	  }

	  public void setparentTopic(String parentTopic) {
	    this.parentTopic = parentTopic;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return parentTopic;
	  }

}

package com.fdmgroup.bookstore.model;

public class AudioBook extends Book{

	public AudioBook(BookGenre b1, int itemid, double price, String title, String author) {
		super(b1, itemid, price, title, author);
		// TODO Auto-generated constructor stub
	}

	private int timeLengthSeconds;

	/**
	 * @return the timeLengthSeconds
	 */
	public int getTimeLengthSeconds() {
		return timeLengthSeconds;
	}

	/**
	 * @param timeLengthSeconds the timeLengthSeconds to set
	 */
	public void setTimeLengthSeconds(int timeLengthSeconds) {
		this.timeLengthSeconds = timeLengthSeconds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AudioBook [timeLengthSeconds=" + timeLengthSeconds + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + timeLengthSeconds;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AudioBook other = (AudioBook) obj;
		if (timeLengthSeconds != other.timeLengthSeconds)
			return false;
		return true;
	}
	
	
}

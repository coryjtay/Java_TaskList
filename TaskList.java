package edu.orangecoastcollege.cs170.ctaylor82.ic25;

import java.io.Serializable;

public class TaskList implements Serializable {

	private String mDeadline;
	private String mDueDate;
	private String mName;
	private int mPriority;

	public TaskList(String deadline, String dueDate, String name, int priority) {
		mName = name;
		mDueDate = dueDate;
		mDeadline = deadline;
		mPriority = priority;
	}

	public TaskList(TaskList other) {
		mDeadline = other.mDeadline;
		mDueDate = other.mDueDate;
		mName = other.mName;
		mPriority = other.mPriority;
	}

	public String getDeadline() {
		return mDeadline;
	}

	public void setDeadline(String deadline) {
		mDeadline = deadline;
	}

	public String getDueDate() {
		return mDueDate;
	}

	public void setDueDate(String dueDate) {
		mDueDate = dueDate;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public int getPriority() {
		return mPriority;
	}

	public void setPriority(int priority) {
		mPriority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDeadline == null) ? 0 : mDeadline.hashCode());
		result = prime * result + ((mDueDate == null) ? 0 : mDueDate.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mPriority;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskList other = (TaskList) obj;
		if (mDeadline == null) {
			if (other.mDeadline != null)
				return false;
		} else if (!mDeadline.equals(other.mDeadline))
			return false;
		if (mDueDate == null) {
			if (other.mDueDate != null)
				return false;
		} else if (!mDueDate.equals(other.mDueDate))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mPriority != other.mPriority)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (mPriority == 1)
			return "Task[Name=" + mDeadline + ", Due Date=" + mDueDate + ", Deadline=" + mName + ", Priority=High]";
		else if (mPriority == 2)
			return "Task[Name=" + mDeadline + ", Due Date=" + mDueDate + ", Deadline=" + mName + ", Priority=Medium]";
		else
			return "Task[Name=" + mDeadline + ", Due Date=" + mDueDate + ", Deadline=" + mName + ", Priority=Low]";
	}

}

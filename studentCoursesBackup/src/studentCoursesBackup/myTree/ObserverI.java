package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node.OPERATION;

public interface ObserverI {
	public void update(int bNumber, String courseName, OPERATION operation);
}

package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node.OPERATION;

public interface SubjectI {
	public void registerObserver(ObserverI o);

	public void removeObserver(ObserverI o);

	public void notifyObservers(OPERATION operation);
}

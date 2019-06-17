package chapter5;

/*
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 17.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

public class JSingleton {
	private volatile static JSingleton instance;

	private JSingleton() {
	}

	public static JSingleton getInstance() {
		if (instance == null) {
			synchronized (JSingleton.class) {
				if (instance == null) instance = new JSingleton();
			}
		}
		return instance;
	}
}

package org.easyworld.pm.service;
/**
 * this is template class. this class define flow which describe the step by step 
 * @author Allen.Wang
 *
 */
public abstract class PmEngineTemplate {
	public boolean generateCode(){
		return false;
	}
	
	/**
	 * initialize the environment information.
	 */
	public abstract void init();
	
	public abstract void service();
	
	public abstract void distory();
	
}

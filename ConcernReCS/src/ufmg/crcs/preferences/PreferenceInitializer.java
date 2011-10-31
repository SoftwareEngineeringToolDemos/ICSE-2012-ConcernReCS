/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 27/10/2011
 */

/**Class used to initialize default preference values*/

package ufmg.crcs.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import ufmg.crcs.concernmapper.*;
import ufmg.crcs.ConcernReCS;


public class PreferenceInitializer extends AbstractPreferenceInitializer 
{
	/**@see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() 
	{
	}
	
	/**Initializes all the boolean fields with the same value
	 */
	public static void initializeDefaultPreferences(boolean value)
	{
		String[] concerns=ConcernMapperInterface.getConcernNames(); //Concerns added to the ConcernMapper plug-in
		
		for(String concern:concerns)
		{
			IPreferenceStore store = ConcernReCS.getDefault().getPreferenceStore();
			store.setDefault(concern, value);
		}
	}
}
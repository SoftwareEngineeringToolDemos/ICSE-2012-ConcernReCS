/**
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 08/01/2011
 */

/**ConcernReCS is a plug-in to find Concern Refactoring Code Smells*/

package ufmg.crcs;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConcernReCS extends AbstractUIPlugin 
{
	public static final String PLUGIN_ID = "ufmg.crcs"; //The plug-in ID

	private static ConcernReCS plugin; //The shared instance
	
	public ConcernReCS() 
	{
	}

	public void start(BundleContext context) throws Exception 
	{
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception 
	{
		plugin = null;
		super.stop(context);
	}

	/**
	 * @return the shared instance
	 */
	public static ConcernReCS getDefault() 
	{
		return plugin;
	}
}

//ConcernReCS is a plug-in to find code smells in order to guide concerns refactoring


package ufmg.crcs;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConcernReCS extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ufmg.crcs"; //$NON-NLS-1$

	// The shared instance
	private static ConcernReCS plugin;
	
	/**
	 * The constructor
	 */
	public ConcernReCS() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ConcernReCS getDefault() {
		return plugin;
	}

}

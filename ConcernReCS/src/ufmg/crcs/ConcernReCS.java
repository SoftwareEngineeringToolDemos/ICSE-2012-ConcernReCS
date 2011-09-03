/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * ConcernReCS Project
 *
 * Created by Pericles Alves
 * Date: 01/08/2011
 */

// TODO [EF] Pericles e Diogo, sugiro adotar o cabe�alho acima em todos os arquivos.
// Para o cabe�alho ser adicionado automaticamente pelo Eclipse, edite:
// Window -> Preferences -> Java -> Code Style -> Code Templates -> Comments -> Files

// TODO [EF] Comentem as classes e m�todos usando o estilo Java Doc, ou seja: /** coment�rio */.

// TODO [EF] Estou usando a tag [EF] para identificar meus coment�rios (EF = Eduardo Figueiredo).
// Quando acharem necess�rio se identificar, vcs podem fazer o mesmo: [PA] = P�ricles e [DM] = Diogo.

//ConcernReCS is a plug-in to find code smells in order to guide concerns refactoring

package ufmg.crcs;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

//The activator class controls the plug-in life cycle
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

	/**@return the shared instance*/
	public static ConcernReCS getDefault() 
	{
		return plugin;
	}
}

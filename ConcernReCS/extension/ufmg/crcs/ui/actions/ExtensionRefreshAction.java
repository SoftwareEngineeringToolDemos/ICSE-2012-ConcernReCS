package ufmg.crcs.ui.actions;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.TableViewer;

import ufmg.crcs.ConcernReCS;
import ufmg.crcs.concernmapper.*;
import ufmg.crcs.badsmells.*;
import ufmg.crcs.ui.views.ConcernReCSExtensionModelProvider;

public class ExtensionRefreshAction extends Action
{	
	public ExtensionRefreshAction(TableViewer viewer)
	{	
		setText("Refresh");
		setToolTipText("Refresh");
		setImageDescriptor( ConcernReCS.getImageDescriptor("icons/refresh.gif") );
	}
	
	/**
	 * Executes the refresh action
	 */
	public void run() 
	{	
		ArrayList<BadSmell> bad_smells; //Concern Refactoring Bad Smells found in the source code 
//		IPreferenceStore store = ConcernReCS.getDefault().getPreferenceStore(); // TODO: preferences.
		BadSmellsCollector collector = new BadSmellsCollector();
//		ArrayList<String> disabled_badSmells = new ArrayList<String>(); // TODO: disabled Bad Smell || metrics
//		ArrayList<String> disabled_concerns = new ArrayList<String>(); //Concerns in which Code Smells should not to be sought
//		ArrayList<String> bad_smells_names = collector.getBadSmellsNames(); //The names of all possible kinds of Code Smells
//		ArrayList<String> concerns_names = ConcernMapperInterface.getConcernNames(); //The names of all concerns added to the ConcernMapper
		
//		//Verifies which Code Smells should not to be sought in the code
//		for (String smell : bad_smells_names)
//		{
//			if (store.contains(smell))
//			{
//				if(store.getBoolean(smell)==false) {
//					disabled_smells.add(smell);
//				}
//			}
//		}
		
//		//Verifies the concerns in which Bad Smells should not to be sought
//		for(String concern:concerns_names)
//		{
//			if(store.contains(concern))
//			{
//				if(store.getBoolean(concern)==false) {
//					disabled_concerns.add(concern);
//				}
//			}
//		}
				
//		collector.disableSmells(disabled_smells);
		
//		collector.disableConcerns(disabled_concerns);		
		
		bad_smells = collector.collectBadSmells(); //Retrieves the list of Code Smells existing in the source code
		
		ConcernReCSExtensionModelProvider.INSTANCE.badSmellsChanged(bad_smells); //Reset the input data for the ConcernReCS main view
	}
}

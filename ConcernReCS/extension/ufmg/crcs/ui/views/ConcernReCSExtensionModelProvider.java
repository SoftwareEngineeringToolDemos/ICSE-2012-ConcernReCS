package ufmg.crcs.ui.views;

import java.util.*;

import org.eclipse.jface.viewers.TableViewer;

import ufmg.crcs.ConcernReCS;
import ufmg.crcs.badsmells.*;

public enum ConcernReCSExtensionModelProvider 
{
	INSTANCE; //The singleton instance

	private ArrayList<BadSmell> bad_smells; //Bad Smells to be shown in the viewer
	private TableViewer viewer; //TableViewer in which the Bad Smells should be shown
	private ConcernReCSExtensionView view; //ConcernReCS main view
	
	private ConcernReCSExtensionModelProvider() 
	{
		bad_smells=null;
	}

	/**
	 * Initializes the model provider and return an empty list of bad Smells
	 */
	public ArrayList<BadSmell> initializeModelProvider(ConcernReCSExtensionView view) 
	{
		this.view=view;
		
		setViewer(view.getViewer());
		
		return bad_smells;
	}
	
	/**
	 * Sets the viewer in which the bad Smells will be shown
	 * @param viewer
	 */
	private void setViewer(TableViewer viewer)
	{
		this.viewer=viewer;
	}
	
	/**
	 * Sets the new list of bad Smells to be shown in the viewer
	 * @param bad_smells
	 */
	private void setBadSmells(ArrayList<BadSmell> bad_smells)
	{
		this.bad_smells=bad_smells;
	}
	
	/**
	 * Returns the bad Smells being presented in the viewer
	 */
	public ArrayList<BadSmell> getBadSmells()
	{
		return bad_smells;
	}
	
	/**
	 * Responsible for change the Smells being presented in the viewer
	 * @param bad_smells
	 */
	public void badSmellsChanged(ArrayList<BadSmell> bad_smells)
	{
		setBadSmells(bad_smells);
		
		resetViewerInput();
		
		ConcernReCS.getDefault().contentChanged();
		
		view.updateActionState();
	}
	
	/**
	 * Reset the input data in order to redrawn the viewer
	 */
	private void resetViewerInput()
	{
		viewer.setInput(bad_smells.toArray());
	}
}

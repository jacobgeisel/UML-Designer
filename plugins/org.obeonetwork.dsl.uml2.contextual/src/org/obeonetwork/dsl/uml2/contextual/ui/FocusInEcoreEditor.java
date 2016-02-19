/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.contextual.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.view.focus.IFocusInEditor;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;

/**
 * @author Jacob Geisel <a href="mailto:jacob.geisel@obeo.fr">jacob.geisel@obeo.fr</a>
 */
public class FocusInEcoreEditor implements IFocusInEditor {

	public boolean accept(IEditorPart activeEditor_p, ISelection selection_p) {
		final IStructuredSelection selection = (IStructuredSelection)selection_p;
		final Object element = selection.getFirstElement();
		return activeEditor_p instanceof EcoreEditor && element instanceof EModelElement;
	}

	public boolean focusInEditor(IEditorPart activeEditor_p, ISelection selection_p) {
		try {
			final EcoreEditor editor = (EcoreEditor)activeEditor_p;
			final Object element = ((IStructuredSelection)selection_p).getFirstElement();
			if (element instanceof EObject) {
				final List<Object> parents = new ArrayList<Object>();
				final EObject eElement = (EObject)element;
				parents.add(eElement);
				final ResourceSet input = (ResourceSet)editor.getViewer().getInput();
				parents.add(0, input.getResources().get(0));
				final TreePath treePath = new TreePath(parents.toArray());
				final TreeSelection selection = new TreeSelection(treePath);
				editor.getViewer().setSelection(selection, true);
			}
			return true;
		} catch (final Exception e) {
			return false;
		}

	}

}

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
package org.obeonetwork.dsl.uml2.contextual.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;

/**
 * @author Jacob Geisel <a href="mailto:jacob.geisel@obeo.fr">jacob.geisel@obeo.fr</a>
 */
public class UMLElementInverseReferences implements IQuery {

	public List<Object> compute(Object object_p) {
		final List<Object> result = new ArrayList<Object>();
		final Collection<Setting> tempResult = UML2Util.getInverseReferences((EObject)object_p);
		for (final Setting setting : tempResult) {
			final EObject object = setting.getEObject();
			if (object instanceof Element) {
				result.add(object);
			}
		}
		return result;
	}

}

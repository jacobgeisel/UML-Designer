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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.uml2.uml.Class;

/**
 * @author Jacob Geisel <a href="mailto:jacob.geisel@obeo.fr">jacob.geisel@obeo.fr</a>
 */
public class UMLClassSuperclassesQuery implements IQuery {

	public List<Object> compute(Object object_p) {
		final List<Object> result = new ArrayList<Object>();
		if (object_p instanceof Class) {
			result.addAll(computeAllSuperclasses((Class)object_p));
		}
		return result;
	}

	private Set<Object> computeAllSuperclasses(Class class_p) {
		final Set<Object> result = new HashSet<Object>();
		result.addAll(class_p.getSuperClasses());
		for (final Class object : class_p.getSuperClasses()) {
			result.addAll(computeAllSuperclasses(object));
		}

		return result;
	}

}

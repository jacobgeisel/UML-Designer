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
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.uml2.uml.Package;

/**
 * @author Jacob Geisel <a href="mailto:jacob.geisel@obeo.fr">jacob.geisel@obeo.fr</a>
 */
public class UMLPackagePackagedElementsQuery implements IQuery {

	public List<Object> compute(Object object_p) {
		final List<Object> result = new ArrayList<Object>();
		if (object_p instanceof Package) {
			result.addAll(((Package)object_p).getPackagedElements());
		}
		return result;
	}

}

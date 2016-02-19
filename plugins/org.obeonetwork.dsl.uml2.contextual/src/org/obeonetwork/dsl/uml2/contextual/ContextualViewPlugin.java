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
package org.obeonetwork.dsl.uml2.contextual;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 *
 * @author Jacob Geisel <a href="mailto:jacob.geisel@obeo.fr">jacob.geisel@obeo.fr</a>
 */
public class ContextualViewPlugin extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.uml2.contextual"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static ContextualViewPlugin plugin;

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static ContextualViewPlugin getDefault() {
		return plugin;
	}

	/**
	 * A helper to log plugin errors.
	 *
	 * @param severity
	 *            the error severity.
	 * @param message
	 *            the error message.
	 * @param exception
	 *            the error exception.
	 */
	public static void log(int severity, String message, Throwable exception) {
		getDefault().getLog().log(new Status(severity, PLUGIN_ID, message, exception));
	}

	/**
	 * The constructor
	 */
	public ContextualViewPlugin() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}

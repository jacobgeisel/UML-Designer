/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.properties.uml.components;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;

import org.obeonetwork.dsl.uml2.properties.uml.parts.OperationsPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;

/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cédric Brun</a>
 * @generated
 */
public class DataTypeOperationsPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    /**
     * @generated
     */

    public static String OPERATIONS_PART = "Operations"; //$NON-NLS-1$

    /**
     * Settings for operations ReferencesTable
     */
    protected ReferencesTableSettings operationsSettings;

    /**
     * Default constructor
     * 
     * @generated
     */
    public DataTypeOperationsPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dataType, String editing_mode) {
        super(editingContext, dataType, editing_mode);
        parts = new String[] { OPERATIONS_PART };
        repositoryKey = UmlViewsRepository.class;
        partKey = UmlViewsRepository.Operations.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object,
     *      int, org.eclipse.emf.ecore.EObject,
     *      org.eclipse.emf.ecore.resource.ResourceSet)
     * @generated
     */
    public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
        setInitializing(true);
        if (editingPart != null && key == partKey) {
            editingPart.setContext(elt, allResource);

            final DataType dataType = (DataType) elt;
            final OperationsPropertiesEditionPart operationsPart = (OperationsPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(UmlViewsRepository.Operations.operations_)) {
                operationsSettings = new ReferencesTableSettings(dataType, UMLPackage.eINSTANCE.getDataType_OwnedOperation());
                operationsPart.initOperations(operationsSettings);
            }
            // init filters
            if (isAccessible(UmlViewsRepository.Operations.operations_)) {
                operationsPart.addFilterToOperations(new ViewerFilter() {
                    /**
                     * {@inheritDoc}
                     * 
                     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
                     *      java.lang.Object, java.lang.Object)
                     */
                    public boolean select(Viewer viewer, Object parentElement, Object element) {
                        return (element instanceof String && element.equals("")) || (element instanceof Operation); //$NON-NLS-1$ 
                    }

                });
            }
            // init values for referenced views

            // init filters for referenced views

        }
        setInitializing(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
     */
    public EStructuralFeature associatedFeature(Object editorKey) {
        if (editorKey == UmlViewsRepository.Operations.operations_) {
            return UMLPackage.eINSTANCE.getDataType_OwnedOperation();
        }
        return super.associatedFeature(editorKey);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * @generated
     */
    public void updateSemanticModel(final IPropertiesEditionEvent event) {
        DataType dataType = (DataType) semanticObject;
        if (UmlViewsRepository.Operations.operations_ == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.ADD) {
                EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, operationsSettings, editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy policy = provider.getPolicy(context);
                    if (policy instanceof CreateEditingPolicy) {
                        policy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.EDIT) {
                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
                    if (editionPolicy != null) {
                        editionPolicy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
                operationsSettings.removeFromReference((EObject) event.getNewValue());
            } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
                operationsSettings.move(event.getNewIndex(), (Operation) event.getNewValue());
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
     */
    public void updatePart(Notification msg) {
        super.updatePart(msg);
        if (editingPart.isVisible()) {
            OperationsPropertiesEditionPart operationsPart = (OperationsPropertiesEditionPart) editingPart;
            if (UMLPackage.eINSTANCE.getDataType_OwnedOperation().equals(msg.getFeature()) && isAccessible(UmlViewsRepository.Operations.operations_))
                operationsPart.updateOperations();

        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
     */
    @Override
    protected NotificationFilter[] getNotificationFilters() {
        NotificationFilter filter = new EStructuralFeatureNotificationFilter(UMLPackage.eINSTANCE.getDataType_OwnedOperation());
        return new NotificationFilter[] { filter, };
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object,
     *      int)
     * @generated
     */
    public boolean isRequired(Object key, int kind) {
        return key == UmlViewsRepository.General.Qualifiers.abstract_ || key == UmlViewsRepository.General.Qualifiers.leaf;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * @generated
     */
    public Diagnostic validateValue(IPropertiesEditionEvent event) {
        Diagnostic ret = Diagnostic.OK_INSTANCE;
        if (event.getNewValue() != null) {
            try {
            } catch (IllegalArgumentException iae) {
                ret = BasicDiagnostic.toDiagnostic(iae);
            } catch (WrappedException we) {
                ret = BasicDiagnostic.toDiagnostic(we);
            }
        }
        return ret;
    }

}

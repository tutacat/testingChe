/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.java.client.refactoring.rename.wizard.similarnames;

import com.google.inject.ImplementedBy;
import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.ext.java.shared.dto.refactoring.RenameSettings.MachStrategy;

/**
 * The visual part of Similar name wizard.
 *
 * @author Valeriy Svydenko
 */
@ImplementedBy(SimilarNamesConfigurationViewImpl.class)
interface SimilarNamesConfigurationView extends View<SimilarNamesConfigurationView.ActionDelegate> {

  MachStrategy getMachStrategy();

  /** Show Similar Names Configuration panel. */
  void showDialog();

  interface ActionDelegate {}
}

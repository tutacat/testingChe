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
package org.eclipse.che.api.core.model.factory;

import java.util.List;

/**
 * Defines IDE look and feel on application closed event.
 *
 * @author Anton Korneta
 */
public interface OnAppClosed {

  /** Returns actions for current event. */
  List<? extends Action> getActions();
}

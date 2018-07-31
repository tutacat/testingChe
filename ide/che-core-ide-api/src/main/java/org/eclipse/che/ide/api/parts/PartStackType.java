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
package org.eclipse.che.ide.api.parts;

/** Defines Part's position on the Screen */
public enum PartStackType {
  /**
   * Contains navigation parts. Designed to navigate by project, types, classes and any other
   * entities. Usually placed on the LEFT side of the IDE.
   */
  NAVIGATION,
  /**
   * Contains informative parts. Designed to display the state of the application, project or
   * processes. Usually placed on the BOTTOM side of the IDE.
   */
  INFORMATION,
  /**
   * Contains editing parts. Designed to provide an ability to edit any resources or settings.
   * Usually placed in the CENTRAL part of the IDE.
   */
  EDITING,
  /**
   * Contains tooling parts. Designed to provide handy features and utilities, access to other
   * services or any other features that are out of other PartType scopes. Usually placed on the
   * RIGHT side of the IDE.
   */
  TOOLING
}

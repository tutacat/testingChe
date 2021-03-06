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
package org.eclipse.che.api.installer.server;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.eclipse.che.api.installer.server.impl.LocalInstallerRegistry;
import org.eclipse.che.api.installer.server.impl.RemoteInstallerRegistry;

/**
 * Provides corresponding instance of {@link InstallerRegistry}.
 *
 * <p>Instance of {@link RemoteInstallerRegistry} will be provided if it is configured otherwise
 * instance of {@link LocalInstallerRegistry} will be provided.
 *
 * @author gazarenkov
 * @author Sergii Leshchenko
 */
@Singleton
public class InstallerRegistryProvider implements Provider<InstallerRegistry> {
  private final LocalInstallerRegistry localInstallerRegistry;
  private final RemoteInstallerRegistry remoteInstallerRegistry;

  @Inject
  public InstallerRegistryProvider(
      LocalInstallerRegistry localInstallerRegistry,
      RemoteInstallerRegistry remoteInstallerRegistry) {
    this.localInstallerRegistry = localInstallerRegistry;
    this.remoteInstallerRegistry = remoteInstallerRegistry;
  }

  @Override
  public InstallerRegistry get() {
    return remoteInstallerRegistry.isConfigured()
        ? remoteInstallerRegistry
        : localInstallerRegistry;
  }
}

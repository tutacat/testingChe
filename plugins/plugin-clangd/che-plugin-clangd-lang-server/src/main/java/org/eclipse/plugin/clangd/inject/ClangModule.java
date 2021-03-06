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
package org.eclipse.plugin.clangd.inject;

import static com.google.inject.multibindings.MapBinder.newMapBinder;
import static com.google.inject.multibindings.Multibinder.newSetBinder;

import com.google.inject.AbstractModule;
import org.eclipse.che.api.languageserver.LanguageServerConfig;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.plugin.cpp.projecttype.CProjectType;
import org.eclipse.che.plugin.cpp.projecttype.CppProjectType;
import org.eclipse.plugin.clangd.languageserver.ClangDLanguageServerConfig;

/**
 * @author Alexander Andrienko
 * @author Hanno Kolvenbach
 */
@DynaModule
public class ClangModule extends AbstractModule {
  public static final String LANGUAGE_ID = "clangd";

  @Override
  protected void configure() {
    newSetBinder(binder(), ProjectTypeDef.class).addBinding().to(CProjectType.class);
    newSetBinder(binder(), ProjectTypeDef.class).addBinding().to(CppProjectType.class);

    newMapBinder(binder(), String.class, LanguageServerConfig.class)
        .addBinding("org.eclipse.che.plugin.clangd.languageserver")
        .to(ClangDLanguageServerConfig.class)
        .asEagerSingleton();
  }
}

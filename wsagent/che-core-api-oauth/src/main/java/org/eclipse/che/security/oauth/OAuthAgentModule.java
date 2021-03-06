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
package org.eclipse.che.security.oauth;

import com.google.inject.AbstractModule;
import org.eclipse.che.security.oauth.oauth1.RemoteOAuthAuthorizationHeaderProvider;
import org.eclipse.che.security.oauth.shared.OAuthAuthorizationHeaderProvider;

/**
 * Represent single guice module that bind classes to get out tokens from workspace agent.
 *
 * @author Sergii Kabashniuk
 */
public class OAuthAgentModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(OAuthAuthorizationHeaderProvider.class).to(RemoteOAuthAuthorizationHeaderProvider.class);
  }
}

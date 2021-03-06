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
package org.eclipse.che.everrest;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.eclipse.che.commons.lang.concurrent.ThreadLocalPropagateContext;
import org.everrest.core.impl.EverrestConfiguration;
import org.everrest.core.impl.async.AsynchronousJobPool;

/** @author Vitaly Parfonov */
@Singleton
@Provider
public class CheAsynchronousJobPool extends AsynchronousJobPool
    implements ContextResolver<AsynchronousJobPool> {

  @Inject
  public CheAsynchronousJobPool(EverrestConfiguration everrestConfiguration) {
    super(everrestConfiguration);
  }

  @Override
  protected Callable<Object> newCallable(Object resource, Method method, Object[] params) {
    return ThreadLocalPropagateContext.wrap((super.newCallable(resource, method, params)));
  }
}

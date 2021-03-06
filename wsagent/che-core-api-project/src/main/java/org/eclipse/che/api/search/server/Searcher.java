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
package org.eclipse.che.api.search.server;

import java.nio.file.Path;
import org.eclipse.che.api.core.ServerException;

public interface Searcher {
  /**
   * Return paths of matched items on virtual filesystem.
   *
   * @param query query expression
   * @return results of search
   * @throws ServerException if an error occurs
   */
  SearchResult search(QueryExpression query) throws InvalidQueryException, QueryExecutionException;

  /**
   * Add VirtualFile to index.
   *
   * @param fsPath file to add
   * @throws ServerException if an error occurs
   */
  void add(Path fsPath);

  /**
   * Delete VirtualFile from index.
   *
   * @param fsPath path of VirtualFile
   * @throws ServerException if an error occurs
   */
  void delete(Path fsPath);

  /**
   * Updated indexed VirtualFile.
   *
   * @param fsPath path of a file to update
   * @throws ServerException if an error occurs
   */
  void update(Path fsPath);
}

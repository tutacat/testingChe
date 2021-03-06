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
package org.eclipse.che.ide.util;

/** @author Sergii Leschenko */
public class Base64 {

  /**
   * Creates a base-64 encoded ASCII string from a "string" of binary data
   *
   * @param text to encode
   * @return base-64 encoded ASCII string
   */
  public static native String encode(String text) /*-{
        return btoa(text);
    }-*/;

  /**
   * Decodes a string of data which has been encoded using base-64 encoding
   *
   * @param text to decode
   * @return decoded from base-64 string
   */
  public static native String decode(String text) /*-{
        return atob(text);
    }-*/;
}

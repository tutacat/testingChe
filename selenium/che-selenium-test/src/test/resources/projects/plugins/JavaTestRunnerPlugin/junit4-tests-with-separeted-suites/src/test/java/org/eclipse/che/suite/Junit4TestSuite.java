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
package org.eclipse.che.suite;

import org.eclipse.che.tests.AppAnotherTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * JUnit 4x Test Suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AppAnotherTest.class,
                     AppAnotherTest.class})
public class Junit4TestSuite {
}
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
package org.eclipse.che.ide.ui.dialogs.confirm;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gwt.event.dom.client.ClickEvent;
import org.eclipse.che.ide.ui.UILocalizationConstant;
import org.eclipse.che.ide.ui.dialogs.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Testing {@link ConfirmDialogFooter} functionality.
 *
 * @author Artem Zatsarynnyi
 */
public class ConfirmDialogFooterTest extends BaseTest {
  @Mock private UILocalizationConstant uiLocalizationConstant;
  @Mock private ConfirmDialogView.ActionDelegate actionDelegate;
  @InjectMocks private ConfirmDialogFooter footer;

  @Before
  @Override
  public void setUp() {
    super.setUp();
    footer.setDelegate(actionDelegate);
  }

  @Test
  public void shouldCallAcceptedOnOkClicked() throws Exception {
    footer.handleOkClick(mock(ClickEvent.class));

    verify(actionDelegate).accepted();
  }

  @Test
  public void shouldCallCancelledOnCancelClicked() throws Exception {
    footer.handleCancelClick(mock(ClickEvent.class));

    verify(actionDelegate).cancelled();
  }
}

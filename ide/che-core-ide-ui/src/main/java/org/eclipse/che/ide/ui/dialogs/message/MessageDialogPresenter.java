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
package org.eclipse.che.ide.ui.dialogs.message;

import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import javax.validation.constraints.NotNull;
import org.eclipse.che.commons.annotation.Nullable;
import org.eclipse.che.ide.ui.dialogs.confirm.ConfirmCallback;

/**
 * {@link MessageDialog} implementation.
 *
 * @author Mickaël Leduque
 * @author Artem Zatsarynnyi
 */
public class MessageDialogPresenter implements MessageDialog, MessageDialogView.ActionDelegate {

  /** This component view. */
  private final MessageDialogView view;

  /** The callback used on OK. */
  private final ConfirmCallback confirmCallback;

  @AssistedInject
  public MessageDialogPresenter(
      @NotNull MessageDialogView view,
      @NotNull @Assisted("title") String title,
      @NotNull @Assisted("message") String message,
      @Nullable @Assisted ConfirmCallback confirmCallback) {
    this(view, title, new InlineHTML(message), confirmCallback);
  }

  @AssistedInject
  public MessageDialogPresenter(
      @NotNull MessageDialogView view,
      @NotNull @Assisted String title,
      @NotNull @Assisted IsWidget content,
      @Nullable @Assisted ConfirmCallback confirmCallback) {
    this(view, title, content, confirmCallback, null);
  }

  @AssistedInject
  public MessageDialogPresenter(
      @NotNull MessageDialogView view,
      @NotNull @Assisted("title") String title,
      @NotNull @Assisted IsWidget content,
      @Nullable @Assisted ConfirmCallback confirmCallback,
      @Nullable @Assisted("confirmButtonText") String confirmButtonText) {
    this.view = view;
    this.view.setContent(content);
    this.view.setTitleCaption(title);
    this.confirmCallback = confirmCallback;
    this.view.setDelegate(this);

    if (content.asWidget() != null) {
      content.asWidget().ensureDebugId("info-window-message");
    }

    if (confirmButtonText != null) {
      view.setConfirmButtonText(confirmButtonText);
    }
  }

  @Override
  public void accepted() {
    this.view.closeDialog();
    if (this.confirmCallback != null) {
      this.confirmCallback.accepted();
    }
  }

  @Override
  public void show() {
    this.view.showDialog();
  }
}

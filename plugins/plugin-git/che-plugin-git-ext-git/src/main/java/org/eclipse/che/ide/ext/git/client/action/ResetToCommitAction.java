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
package org.eclipse.che.ide.ext.git.client.action;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.FontAwesome;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Project;
import org.eclipse.che.ide.ext.git.client.GitLocalizationConstant;
import org.eclipse.che.ide.ext.git.client.reset.commit.ResetToCommitPresenter;

/**
 * @author Andrey Plotnikov
 * @author Vlad Zhukovskyi
 */
@Singleton
public class ResetToCommitAction extends GitAction {
  private final ResetToCommitPresenter presenter;

  @Inject
  public ResetToCommitAction(
      ResetToCommitPresenter presenter, AppContext appContext, GitLocalizationConstant constant) {
    super(
        constant.resetToCommitControlTitle(),
        constant.resetToCommitControlPrompt(),
        FontAwesome.BAN,
        appContext);
    this.presenter = presenter;
  }

  /** {@inheritDoc} */
  @Override
  public void actionPerformed(ActionEvent e) {
    final Project project = appContext.getRootProject();

    checkState(project != null, "Null project occurred");

    presenter.showDialog(project);
  }
}

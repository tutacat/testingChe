/*
 * Copyright (c) 2015-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
'use strict';

/**
 * Defines a directive for creating description widget, which can have "Learn more" link as well.
 *
 * @author Ann Shumilova
 */
export class CheDescription implements ng.IDirective {

  restrict = 'E';

  replace = true;
  transclude = true;
  templateUrl = 'components/widget/description/che-description.html';

  // scope values
  scope = {
    linkTitle: '@?cheLinkTitle',
    link: '@?cheLink'
  };

}

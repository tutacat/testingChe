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
import {ProfileController} from './profile.controller';

export class ProfileConfig {

  constructor(register: che.IRegisterService) {
    register.controller('ProfileController', ProfileController);

    let locationProvider = {
      title: 'Account',
      templateUrl: 'app/profile/profile.html',
      controller: 'ProfileController',
      controllerAs: 'profileController'
    };

    // config routes
    register.app.config(['$routeProvider', ($routeProvider: che.route.IRouteProvider) => {
      $routeProvider.accessWhen('/account', locationProvider);
    }]);
  }
}

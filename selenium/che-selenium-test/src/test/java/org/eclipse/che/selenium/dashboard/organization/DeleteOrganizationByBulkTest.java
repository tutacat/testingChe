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
package org.eclipse.che.selenium.dashboard.organization;

import static org.eclipse.che.selenium.pageobject.dashboard.NavigationBar.MenuItem.ORGANIZATIONS;
import static org.eclipse.che.selenium.pageobject.dashboard.organization.OrganizationListPage.OrganizationListHeader.NAME;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.google.inject.Inject;
import org.eclipse.che.selenium.core.TestGroup;
import org.eclipse.che.selenium.core.client.CheTestAdminOrganizationServiceClient;
import org.eclipse.che.selenium.core.organization.InjectTestOrganization;
import org.eclipse.che.selenium.core.organization.TestOrganization;
import org.eclipse.che.selenium.core.user.AdminTestUser;
import org.eclipse.che.selenium.pageobject.dashboard.ConfirmDialog;
import org.eclipse.che.selenium.pageobject.dashboard.Dashboard;
import org.eclipse.che.selenium.pageobject.dashboard.NavigationBar;
import org.eclipse.che.selenium.pageobject.dashboard.organization.OrganizationListPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test validates the bulk deletion of organizations in the list.
 *
 * @author Ann Shumilova
 */
@Test(groups = {TestGroup.MULTIUSER})
public class DeleteOrganizationByBulkTest {
  private static final int TEST_ROOT_ORG_NUMBER = 2;

  private int initialOrgNumber;

  @InjectTestOrganization private TestOrganization org1;
  @InjectTestOrganization private TestOrganization org2;

  @Inject private CheTestAdminOrganizationServiceClient adminOrganizationServiceClient;
  @Inject private OrganizationListPage organizationListPage;
  @Inject private AdminTestUser adminTestUser;
  @Inject private NavigationBar navigationBar;
  @Inject private ConfirmDialog confirmDialog;
  @Inject private Dashboard dashboard;

  @BeforeClass
  public void setUp() throws Exception {
    initialOrgNumber = adminOrganizationServiceClient.getAllRoot().size();
    dashboard.open(adminTestUser.getName(), adminTestUser.getPassword());
  }

  public void testOrganizationBulkDeletion() {
    // Check that created organization exist
    navigationBar.waitNavigationBar();
    navigationBar.clickOnMenu(ORGANIZATIONS);
    organizationListPage.waitForOrganizationsToolbar();
    organizationListPage.waitForOrganizationsList();

    assertEquals(organizationListPage.getOrganizationListItemCount(), initialOrgNumber);
    assertTrue(organizationListPage.getValues(NAME).contains(org1.getName()));
    assertTrue(organizationListPage.getValues(NAME).contains(org2.getName()));

    // Tests the Bulk Delete feature
    assertFalse(organizationListPage.isBulkDeleteVisible());
    organizationListPage.clickCheckbox(org1.getName());
    organizationListPage.clickCheckbox(org2.getName());
    assertTrue(organizationListPage.isBulkDeleteVisible());
    organizationListPage.clickCheckbox(org1.getName());
    organizationListPage.clickCheckbox(org2.getName());
    assertFalse(organizationListPage.isBulkDeleteVisible());
    organizationListPage.clickCheckbox(org1.getName());
    organizationListPage.clickCheckbox(org2.getName());
    assertTrue(organizationListPage.isBulkDeleteVisible());

    // Delete all organizations by the Bulk Delete feature
    organizationListPage.clickBulkDeleteButton();
    confirmDialog.waitOpened();
    assertEquals(confirmDialog.getTitle(), "Delete organizations");
    assertEquals(
        confirmDialog.getMessage(),
        String.format("Would you like to delete these %s organizations?", TEST_ROOT_ORG_NUMBER));
    assertEquals(confirmDialog.getConfirmButtonTitle(), "Delete");
    assertEquals(confirmDialog.getCancelButtonTitle(), "Close");
    confirmDialog.clickConfirm();
    confirmDialog.waitClosed();
    organizationListPage.waitForOrganizationsList();

    // Test that all organization removed
    organizationListPage.waitForOrganizationIsRemoved(org1.getName());
    organizationListPage.waitForOrganizationIsRemoved(org2.getName());

    assertEquals(
        organizationListPage.getOrganizationListItemCount(),
        initialOrgNumber - TEST_ROOT_ORG_NUMBER);
    assertFalse(organizationListPage.getValues(NAME).contains(org1.getName()));
    assertFalse(organizationListPage.getValues(NAME).contains(org2.getName()));
    assertEquals(
        navigationBar.getMenuCounterValue(ORGANIZATIONS), initialOrgNumber - TEST_ROOT_ORG_NUMBER);
  }
}

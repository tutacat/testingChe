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
package org.eclipse.che.api.core.rest;

import static com.jayway.restassured.RestAssured.expect;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.everrest.assured.EverrestJetty;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = {EverrestJetty.class})
public class RuntimeExceptionMapperTest {
  @Path("/runtime-exception")
  public static class RuntimeExceptionService {
    @GET
    @Path("/re-empty-msg")
    public String reWithEmptyMessage() {
      throw new NullPointerException();
    }
  }

  RuntimeExceptionService service;

  RuntimeExceptionMapper mapper;

  @Test
  public void shouldHandleRuntimeException() {
    final String expectedErrorMessage =
        "{\"message\":\"Internal Server Error occurred, error time:";

    expect()
        .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
        .body(Matchers.startsWith(expectedErrorMessage))
        .when()
        .get("/runtime-exception/re-empty-msg");
  }
}

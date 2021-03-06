/*
 * Copyright 2017-2018 The OpenTracing Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.opentracing.contrib.mongo.providers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixSpanNameProviderTest {

  private final MongoSpanNameProvider provider = new PrefixSpanNameProvider("mongo.");

  @Test
  public void testOperationNameExists() {
    assertEquals("mongo.insert", provider.generateName("insert"));
  }

  @Test
  public void testNullOperationName() {
    assertEquals("mongo.unknown", provider.generateName(null));
  }

  @Test
  public void testNullPrefixName() {
    assertEquals("insert", new PrefixSpanNameProvider(null).generateName("insert"));
  }
}

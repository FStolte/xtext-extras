/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmCharAnnotationValueTest extends Assert {

	private JvmCharAnnotationValue charAnnotationValue;

	@Before
	public void setUp() throws Exception {
		charAnnotationValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
	}	
	
	@Test public void testMultiValue() {
		charAnnotationValue.getValues().add('1');
		charAnnotationValue.getValues().add('1');
		assertEquals(2, charAnnotationValue.getValues().size());
	}
}

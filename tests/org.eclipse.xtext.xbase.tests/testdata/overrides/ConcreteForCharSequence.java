/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package overrides;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcreteForCharSequence extends AbstractForCharSequence {

	public <X extends CharSequence, Y extends X> X method(Class<? extends X> c) {
		return null;
	}

}

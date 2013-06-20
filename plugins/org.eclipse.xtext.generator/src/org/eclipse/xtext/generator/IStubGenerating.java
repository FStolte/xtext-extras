/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * @since 2.4
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IStubGenerating {
	
	boolean isGenerateStub();

	void setGenerateStub(boolean isGenerateStub);
	
	/**
	 * A {@link IStubGenerating} that can optionally generate Xtend.
	 * 
	 * @author koehnlein - Initial contribution and API
	 */
	interface XtendOption {
		
		/**
		 * @return true, if the fragment is configured to generate stub classes in Xtend instead of Java. 
		 *    This only has an effect if the generation of stubs is enabled in general 
		 *    {@link IStubGenerating#isGenerateStub()}. 
		 */
		boolean isGenerateXtendStub();

		/**
		 * @param isGenerateXtendStub decide if the fragment should generate stub classes in Xtend instead of Java.  
		 *    This only has an effect if the generation of stubs is enabled in general 
		 *    {@link IStubGenerating#setGenerateStub(boolean)}. 
		 */
		void setGenerateXtendStub(boolean isGenerateXtendStub);
	}
}

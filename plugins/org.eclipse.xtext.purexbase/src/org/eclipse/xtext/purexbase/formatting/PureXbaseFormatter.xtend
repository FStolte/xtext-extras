/*
 * generated by Xtext
 */
package org.eclipse.xtext.purexbase.formatting

import com.google.inject.Inject
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess
import org.eclipse.xtext.xbase.formatting.XbaseFormatter

/**
 * This class contains custom formatting description.
 * 
 * See http://www.eclipse.org/Xtext/documentation/15_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 */
class PureXbaseFormatter extends AbstractDeclarativeFormatter {

	@Inject extension PureXbaseGrammarAccess

	@Inject XbaseFormatter xbaseFormatter
	
	override protected void configureFormatting(FormattingConfig c) {
		xbaseFormatter.configure(c, xbaseGrammarAccess)

		val sbee = specialBlockExpressionAccess
		c.setLinewrap(1, 2, 3).after(sbee.expressionsAssignment_1_0)
		c.setLinewrap(1, 2, 3).after(sbee.semicolonKeyword_1_1)
		c.setNoSpace().before(sbee.semicolonKeyword_1_1)

		c.setLinewrap(1, 2, 3).after(XImportSectionAccess.getImportDeclarationsAssignment())
		c.setLinewrap(0, 1, 3).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 3).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 3).after(ML_COMMENTRule)
		
	}
}

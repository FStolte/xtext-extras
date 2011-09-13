package org.eclipse.xtext.purexbase.jvmmodel
 
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.purexbase.pureXbase.Model

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. 
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link IJvmModelAssociator}.</p>     
 */
class PureXbaseJvmModelInferrer implements IJvmModelInferrer {

	@Inject extension JvmTypesBuilder
	@Inject IEarlyExitComputer computer
	@Inject XbaseCompiler compiler

   	def dispatch void infer(EObject e, IAcceptor<JvmDeclaredType> acceptor) {
   	}
   	def dispatch void infer(Model m, IAcceptor<JvmDeclaredType> acceptor) {
   		val e  = m.block
   		acceptor.accept(e.toClazz(e.eResource.name) [
   			members += e.toMethod("main", e.newTypeRef(Void::TYPE)) [
   				^static = true
   				parameters += e.toParameter("args", e.newTypeRef(typeof(String)).addArrayTypeDimension)
   				if (!e.containsReturn) {
   					it.body ['''
						try {
							�e.compile(it)�
						} catch (Throwable t) {}
   					''']
   				} else {
   					it.body ['''
						try {
							xbaseExpression();
						} catch (Throwable t) {}
   					''']
   				}
   				null
   			]
   			if ( e.containsReturn ) {
   				members += e.toMethod("xbaseExpression", e.newTypeRef(typeof(Object))) [
   				^static = true
				it.body ['''
					if (Boolean.TRUE) {
						�e.compile(it)�
					}
					return null;
				''']
   				null
   			]
   			}
   			null
   		])
   	}
   	
   	def name(Resource res) {
		val s = res.URI.lastSegment
		return s.substring(0, s.length - '.xbase'.length)
	}
	
	def containsReturn(XExpression expr) {
		val exitPoints = computer.getExitPoints(expr as XExpression)
		for (point : exitPoints) {
			if (point.expression instanceof XReturnExpression)
				return true
		}
		return false
	}
	
	def compile(XExpression obj, ImportManager mnr) {
		val appendable = new StringBuilderBasedAppendable(mnr)
		compiler.toJavaStatement(obj as XExpression, appendable, false)
		return appendable.toString
	}
}

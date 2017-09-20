package at.hschroedl.fluentast.ast.expression


import at.hschroedl.fluentast.annotation
import at.hschroedl.fluentast.ast.pair
import at.hschroedl.fluentast.i
import at.hschroedl.fluentast.test.dummyLiteral
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.MarkerAnnotation
import org.eclipse.jdt.core.dom.NormalAnnotation
import org.eclipse.jdt.core.dom.SingleMemberAnnotation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AnnotationTest {

    @Test
    internal fun annotation_withQualfiedName_returnsAnnotation() {
        val expression = annotation("test.test1.Test2").build() as MarkerAnnotation

        assertEquals("@test.test1.Test2", expression.toInlineString())
    }


    @Test
    internal fun annotation_withParameter_returnsAnnotation() {
        val expression = annotation("Test", dummyLiteral(1)).build() as SingleMemberAnnotation

        assertEquals("@Test(1)", expression.toInlineString())
    }

    @Test
    internal fun annotation_withMoreParameters_returnsAnnotation() {
        val expression = annotation("Test", pair("param1", i(1)),
                pair("param2", i(2))).build() as NormalAnnotation

        assertEquals("@Test(param1=1,param2=2)", expression.toInlineString())
    }
}